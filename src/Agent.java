public class Agent implements HasPosition, Movable {

    private int[] pos;
    private int[] targetPos;
    private int diameter = 50;

    Agent(int[] pos) {
        this.pos = pos;
        this.targetPos = this.getPos();
    }

    Agent() {
        this.pos = new int[]{0, 0};
        this.targetPos = this.getPos();
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

    public int[] getTarget() {
        return targetPos;
    }

    public void setTarget(int[] targetPos) {
        this.targetPos = targetPos;
    }

    void moveTowardsTarget() {
        // Move towards targetPos
        if (this.getPos()[0] < targetPos[0]) {
            this.move(1, 0);
        } else if (this.getPos()[0] > targetPos[0]) {
            this.move(-1, 0);
        }

        if (this.getPos()[1] < targetPos[1]) {
            this.move(0, 1);
        } else if (this.getPos()[1] > targetPos[1]) {
            this.move(0, -1);
        }
    }

    public boolean isAtTarget() {
        return this.getPos()[0] == this.getTarget()[0] &&
                this.getPos()[1] == this.getTarget()[1];
    }

    void update() {
        moveTowardsTarget();
    }
}
