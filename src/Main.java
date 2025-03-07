import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter the board size");
        int boardSize = scanner.nextInt();
        System.out.println("please enter the dice size");
        int diceSize = scanner.nextInt();
        System.out.println("Please enter the number of players");
        int players = scanner.nextInt();
        System.out.println("Please enter the number of snakes");
        int snakesCount = scanner.nextInt();
        System.out.println("Please enter the number of ladders");
        int ladderCount = scanner.nextInt();
        Map<Integer, Integer> snakePositions = new HashMap<>();
        Map<Integer, Integer> ladderPositions = new HashMap<>();
        Random random = new Random();
        for(int i=0;i<snakesCount;i++)
        {
            int head = random.nextInt(1, boardSize-1);
            int tail = random.nextInt(1, head-1);
            snakePositions.put(head, tail);
        }

        for(int i=0;i<ladderCount;i++)
        {
            int start = random.nextInt(1, boardSize-1);
            while(snakePositions.containsKey(start))
            {
                start = random.nextInt(1, boardSize-1);
            }
            int end = random.nextInt(start, boardSize-1);
            ladderPositions.put(start, end);
        }

        Game game = new Game(boardSize, diceSize, players, snakePositions, ladderPositions);
        game.startGame();
    }
}