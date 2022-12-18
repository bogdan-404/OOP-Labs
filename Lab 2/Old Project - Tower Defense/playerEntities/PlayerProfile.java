package playerEntities;

public class PlayerProfile {
    private String profileName;

    private int livesCount;
    private int initialLives = 15;
    private int resources;
    private int initialResources = 500;
    private int finalGamePoints;

    private boolean endGame = false;

    public PlayerProfile(String name) {
        this.profileName = name;
        this.livesCount = this.initialLives;
        this.resources = this.initialResources;
    }

    public void removeLives(int lostLives) {
        if (this.livesCount - lostLives > 0) {
            this.livesCount -= lostLives;
        } else {
            this.endGame = true;
            this.finalGamePoints = 0;
        }
    }

    public void addResources(int reward) {
        this.resources += reward;
    }

    public void payResources(int price) {
        if (this.resources - price >= 0) {
            this.resources -= price;
        } else {
            // Here will be the logic to cancel the payment
        }
    }

    public String getProfileName() {
        return this.profileName;
    }

    public int getLivesCount() {
        return this.livesCount;
    }

    public int getResources() {
        return this.resources;
    }

    public boolean getEndGame() {
        return this.endGame;
    }

}
