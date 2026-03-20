public class Agent implements HasPosition, Movable {

    private int[] pos;
    private int diameter = 50;

    Agent(int[] pos) {
        this.pos = pos;
    }

    Agent() {
        this.pos = new int[2];
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public int getDiameter() {
        return this.diameter;
    }

    public void move(int dx, int dy) {
        this.pos[0] += dx;
        this.pos[1] += dy;
    }

}
