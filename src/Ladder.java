public class Ladder {
    int id;
    int start;
    int end;

    public Ladder(int id, int start, int end)
    {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
