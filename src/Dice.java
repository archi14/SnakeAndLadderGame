import java.util.Random;

public class Dice {
    int size;

    public Dice(int size)
    {
        this.size = size;
    }

    public int roll()
    {
        Random random = new Random();
        return random.nextInt(1,this.size+1);
    }
}
