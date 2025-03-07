public class Player {
    int id;
    int position;

    public Player(int id)
    {
        this.id = id;
        this.position = 0;
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
