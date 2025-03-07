public class Snake {
    int id;
    String color;
    int head;
    int tail;

    public Snake(int id, String color, int head, int tail)
    {
        this.id = id;
        this.color = color;
        this.head = head;
        this.tail = tail;
    }

    public int getTail() {
        return tail;
    }

    public int getHead() {
        return head;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }
}
