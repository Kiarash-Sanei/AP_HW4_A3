public class SecurityRobot extends Robot {
    private final int power;
    private int lives;

    public SecurityRobot(String id, int power, int lives) {
        super(id);
        this.power = power;
        this.lives = lives;
    }

    public int getPower() {
        return power;
    }

    public boolean isAlive() {
        return lives > 0;
    }

    public void decreaseLives() {
        lives--;
    }

    @Override
    public String getType() {
        return "security";
    }

    public void monitor() {
        System.out.println("security robot is monitoring");
    }

    public boolean attack(int enemyPower) {
        if (this.power >= enemyPower) {
            System.out.println("attack was successful");
            return true;
        } else {
            this.decreaseLives();
            System.out.println("attack was unsuccessful");
            return false;
        }
    }
}
