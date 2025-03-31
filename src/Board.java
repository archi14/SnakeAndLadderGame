import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Board {
    private static Board board;
    int size;
    Map<Integer, Snake> snakes;
    Map<Integer, Ladder> ladders;
    ObstacleFactory obstacleFactory;
    Scanner scanner;
    Random random;

    private Board(int size)
    {
        scanner = new Scanner(System.in);
        random = new Random();
        this.size = size;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        obstacleFactory = new ObstacleFactory();

    }

    public void addSnakes()
    {
        Map<Integer, Integer> snakePositions = new HashMap<>();
        System.out.println("Please enter the number of snakes");
        int snakesCount = scanner.nextInt();
        for(int i=0;i<snakesCount;i++)
        {
            int head = random.nextInt(1, this.size-1);
            while(snakePositions.get(head)!=null)
            {
                head = random.nextInt(1, this.size-1);
            }
            int tail = random.nextInt(1, head-1);
            snakePositions.put(head, tail);
        }
        snakes = obstacleFactory.createsSnakes(snakePositions);
    }

    public void addLadders()
    {
        Map<Integer, Integer> ladderPositions = new HashMap<>();
        Random random = new Random();
        System.out.println("Please enter the number of ladders");
        int ladderCount = scanner.nextInt();
        for(int i=0;i<ladderCount;i++)
        {
            int start = random.nextInt(1, this.size-1);
            while(snakes.get(start)!=null || ladderPositions.containsKey(start))
            {
                start = random.nextInt(1, this.size-1);
            }
            int end = random.nextInt(start, this.size-1);
            ladderPositions.put(start, end);
        }

        ladders = obstacleFactory.createLadders(ladderPositions);
    }

    public static Board getInstance(int size)
    {
        if(board == null)
        {
            return new Board(size);
        }
        return board;
    }

    public boolean hasSnake(int position)
    {
        if(snakes.containsKey(position))
        {
            return true;
        }
        return false;
    }

    public boolean hasLadder(int position)
    {
        if(ladders.containsKey(position))
        {
            return true;
        }
        return false;
    }

    public int getSnakeTail(int position)
    {
        return snakes.get(position).getTail();
    }

    public int getLadderEnd(int position)
    {
        return ladders.get(position).getEnd();
    }



}
