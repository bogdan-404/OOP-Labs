package playerEntities;

public class defenseSoldier {
    private int posX;
    private int posY;

    private int health = 15;
    private int damage = 10;
    private int hitCooldown = 1;
    private int spawnCooldown = 2;
    private boolean alive = true;

    public void receiveHit(int damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
        } else {
            health = 0;
            this.alive = false;
        }
    }

    public int getDamage() {
        return this.damage;
    }

    public int getHealth() {
        return this.health;
    }

    public double getHitCooldown() {
        return this.hitCooldown;
    }

    public boolean getAlive() {
        return this.alive;
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
