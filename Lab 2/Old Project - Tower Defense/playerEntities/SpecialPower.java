package playerEntities;

public class SpecialPower {
    private SpecialPowerType type;

    // Cordinates of the center:
    private int posX;
    private int posY;

    private int range; // How many tiles around the center
    private int damage;
    private int cooldown; // How many seconds of cooldown

    public SpecialPower(SpecialPowerType type) {
        this.type = type;
        initializeSpecialPower();
    }

    private void initializeSpecialPower() {
        switch (this.type) {
            case Thunder:
                this.range = 1;
                this.damage = 30;
                this.cooldown = 20;
                break;
            case RainOfBombs:
                this.range = 2;
                this.damage = 20;
                this.cooldown = 15;
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    public int getRange() {
        return this.range;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getCooldown() {
        return this.cooldown;
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
