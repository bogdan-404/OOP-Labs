package playerEntities;

public class Barrack {
    private BarrackType type;

    private int posX;
    private int posY;

    private int cost;
    private int soldierNumber;

    public Barrack(BarrackType type) {
        this.type = type;
        initializeBarrack();
    }

    private void initializeBarrack() {
        switch (this.type) {
            case Small:
                this.cost = 100;
                this.soldierNumber = 1;
                break;
            case Big:
                this.cost = 200;
                this.soldierNumber = 2;
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    public BarrackType getBarrackType() {
        return this.type;
    }

    public int getCost() {
        return this.cost;
    }

    public int getSoldierNumber() {
        return this.soldierNumber;
    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int x) {
        this.posX = x;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int y) {
        this.posY = y;
    }
}
