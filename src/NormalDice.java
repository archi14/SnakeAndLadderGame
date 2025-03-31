import java.util.Random;

public class NormalDice implements DiceStrategy{
    private int size;
    private Random random;

    public NormalDice(int size)
    {
        this.size = size;
        random = new Random();
    }

    @Override
    public int roll() {
        return random.nextInt(this.size)+1;
    }
}
