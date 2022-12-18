package playerEntities;

public class Tower {
    private TowerType type;

    private int posX;
    private int posY;

    private int cost;
    private int damage;
    private double rateCooldown; // how many seconds of cooldown after the tower shoots
    private int range; // how many tiles around the tower can be shot

    public Tower(TowerType type) {
        this.type = type;
        initializeTower();
    }

    private void initializeTower() {
        switch (this.type) {
            case Archer:
                this.cost = 100;
                this.damage = 10;
                this.rateCooldown = 0.25;
                this.range = 2;
                break;
            case Mage:
                this.cost = 150;
                this.damage = 15;
                this.rateCooldown = 1.5;
                this.range = 3;
                break;
            case Artillery:
                this.cost = 400;
                this.damage = 25;
                this.rateCooldown = 2;
                this.range = 5;
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    public TowerType getTowerType() {
        return this.type;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getRange() {
        return this.range;
    }

    public double getRateCooldown() {
        return this.rateCooldown;
    }

    public int getCost() {
        return this.cost;
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
