import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class Game {
    Board board;
    Deque<Player> players;
    List<DiceStrategy> dices;

    public Game(int boardSize, List<DiceStrategy> dices, int playersCount , Map<Integer, Integer> snakePositions, Map<Integer, Integer> ladderPositions)
    {
        board = Board.getInstance(boardSize);
        board.addLadders(ladderPositions);
        board.addSnakes(snakePositions);
        players = new ArrayDeque<>();
        for(int i=0;i<playersCount;i++)
        {
            Player player = new Player(i);
            players.add(player);
        }
        this.dices = dices;
    }


    public void startGame()
    {
        while(true)
        {
            Player currentPlayer = players.pop();
            int currentPosition = currentPlayer.position;
            System.out.println("Player " + currentPlayer.getId() + " is at position " + currentPosition);
            int roll = 0;
            for(int i=0;i<dices.size();i++)
            {
                int curRoll = dices.get(i).roll();
                roll += curRoll;
                System.out.println("Rolling dice");
                System.out.println("Dice rolled a " + curRoll);
            }

            int newPosition = currentPosition + roll;
            System.out.println("Moving to position " + newPosition);
            if(board.hasSnake(newPosition))
            {
                System.out.println("Found a snake at the position " + newPosition );
                newPosition = board.getSnakeTail(newPosition);
                System.out.println("Bitten by snake, moved to position " + newPosition);
            }

            if(board.hasLadder(newPosition))
            {
                System.out.println("Found a ladder at the position " + newPosition );
                newPosition = board.getLadderEnd(newPosition);
                System.out.println("climbing the ladder, moved to position " + newPosition);
            }

            if(newPosition == board.size)
            {
                System.out.println("Player " + currentPlayer.getId() + " has won the game, exiting");
                break;
            }else if(newPosition > board.size)
            {
                System.out.println("New position is out of board size");
            }else {
                currentPlayer.setPosition(newPosition);
            }

            players.add(currentPlayer);
        }
    }
}
