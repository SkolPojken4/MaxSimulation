public class Agent {

    int[] pos = new int[2];
    int diameter = 50;

    Agent(int[] pos) {
        this.pos = pos;
    }

    Agent() {
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public void move(int dx, int dy) {
        this.pos[0] += dx;
        this.pos[1] += dy;
    }

}
