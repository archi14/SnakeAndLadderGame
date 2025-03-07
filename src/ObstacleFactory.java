import java.util.HashMap;
import java.util.Map;

public class ObstacleFactory {

    public Map<Integer, Snake> createsSnakes(Map<Integer, Integer> snakePositions)
    {
        Map<Integer, Snake> snakes = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : snakePositions.entrySet())
        {
            snakes.put(entry.getKey(), new Snake(entry.getKey(), "random" + entry.getKey(), entry.getKey(), entry.getValue()));
        }
        return snakes;
    }

    public Map<Integer, Ladder> createLadders(Map<Integer, Integer> ladderPositions)
    {
        Map<Integer, Ladder> ladders = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : ladderPositions.entrySet())
        {
            ladders.put(entry.getKey(), new Ladder(entry.getKey(),  entry.getKey(), entry.getValue()));
        }
        return ladders;
    }
}
