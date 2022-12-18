package enemyEntities;

public class EnemyInfantry {
    private EnemyInfantryType type;

    private int posX;
    private int posY;

    private int damage;
    private double speed; // How many tiles per move
    private int health;
    private int reward;
    private double hitRateCooldown; // How many seconds of cooldown after it hits
    private boolean encountered = false; // If it is encountered by a player's hero, the enemy won't move
    private boolean dead = false;

    private static int totalEnemies;
    private static int aliveEnemies;

    public EnemyInfantry(EnemyInfantryType type) {
        this.type = type;
        totalEnemies++;
        aliveEnemies++;
        initializeEnemyInfantry();
    }

    private void initializeEnemyInfantry() {
        switch (this.type) {
            case Soldier:
                this.damage = 10;
                this.speed = 1;
                this.health = 20;
                this.reward = 50;
                this.hitRateCooldown = 1;
                break;
            case ArmouredSoldier:
                this.damage = 10;
                this.speed = 0.75;
                this.health = 25;
                this.reward = 100;
                this.hitRateCooldown = 1;
                break;
            case BossSoldier:
                this.damage = 40;
                this.speed = 0.5;
                this.health = 35;
                this.reward = 400;
                this.hitRateCooldown = 2;
                break;
            case Wolf:
                this.damage = 5;
                this.speed = 2;
                this.health = 20;
                this.reward = 150;
                this.hitRateCooldown = 1;
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    public void receiveHit(int damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
        } else {
            health = 0;
            this.dead = true;
            aliveEnemies--; // If == 0, the game should end (for future implimentation)
        }
    }

    private void move() {
        if (this.encountered == false) {
            // This will be implemented when linking to map
        }
    }

    public void setEncountered(boolean encounter) {
        this.encountered = encounter;
    }

    public EnemyInfantryType getEnemyInfantryType() {
        return this.type;
    }

    public int getDamage() {
        return this.damage;
    }

    public double getSpeed() {
        return this.speed;
    }

    public int getHealth() {
        return this.health;
    }

    public int getReward() {
        return this.reward;
    }

    public double getHitRateCooldown() {
        return this.hitRateCooldown;
    }

    public boolean getDead() {
        return this.dead;
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
