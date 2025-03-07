import java.util.Map;

public class Board {
    private static Board board;
    int size;
    Map<Integer, Snake> snakes;
    Map<Integer, Ladder> ladders;
    ObstacleFactory obstacleFactory;
    private Board(int size)
    {
        this.size = size;
        obstacleFactory = new ObstacleFactory();

    }

    public void addSnakes(Map<Integer, Integer> snakePositions)
    {
        snakes = obstacleFactory.createsSnakes(snakePositions);
    }

    public void addLadders(Map<Integer, Integer> ladderPositions)
    {
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
