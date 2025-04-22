import java.util.*;

public class Game {
    Board board;
    Queue<Player> players;
    List<DiceStrategy> dices;
    Scanner scanner;
    public Game(int boardSize)
    {
        scanner = new Scanner(System.in);
        this.dices = new ArrayList<>();
        this.players = new LinkedList<>();
        board = Board.getInstance(boardSize);
        board.addLadders();
        board.addSnakes();
        intializePlayers();
        initializeDices();
    }

    public void intializePlayers()
    {
        System.out.println("Please enter the number of players");
        int playersCount = scanner.nextInt();
        for(int i=0;i<playersCount;i++)
        {
            Player player = new Player(i);
            this.players.add(player);
        }

    }
    public void initializeDices()
    {
        System.out.println("please enter the number of dices");
        int diceCount = scanner.nextInt();
        for(int i=0;i<diceCount;i++)
        {
            System.out.println("please enter the dice size");
            int diceSize = scanner.nextInt();
            DiceStrategy dice = new NormalDice(diceSize);
            this.dices.add(dice);
        }
    }

    public void startGame()
    {
        while(true)
        {
            Player currentPlayer = players.poll();
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
