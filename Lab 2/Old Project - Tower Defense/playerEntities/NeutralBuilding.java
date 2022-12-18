package playerEntities;

public class NeutralBuilding {
    private NeutralBuildingType type;

    private int posX;
    private int posY;

    private int reward;
    private int rewardRate; // Seconds until next reward
    private int cost;

    public NeutralBuilding(NeutralBuildingType type) {
        this.type = type;
        initializeNeutralBuilding();
    }

    private void initializeNeutralBuilding() {
        switch (this.type) {
            case Mill:
                this.reward = 100;
                this.rewardRate = 15;
                this.cost = 200;
                break;
            case Farm:
                this.reward = 150;
                this.rewardRate = 15;
                this.cost = 300;
                break;
            case Mine:
                this.reward = 400;
                this.rewardRate = 25;
                this.cost = 400;
                break;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    public NeutralBuildingType getNeutralBuildingType() {
        return this.type;
    }

    public int getReward() {
        return this.reward;
    }

    public int rewardRate() {
        return this.rewardRate;
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
