import java.util.*;

public class Manager {
    private final Map<String, Robot> robots;
    private final Map<String, RobotFactory> factories;

    public Manager() {
        robots = new HashMap<>();
        factories = new HashMap<>();
        factories.put("security", new SecurityRobotFactory());
        factories.put("delivery", new DeliveryRobotFactory());
        factories.put("cleaning", new CleaningRobotFactory());
    }

    public void executeCommand(String command) {
        String[] parts = command.split(" ");
        String action = parts[0];

        switch (action) {
            case "create":
                createRobot(parts);
                break;
            case "deliver":
                deliverRobot(parts);
                break;
            case "clean":
                cleanRobot(parts);
                break;
            case "perform":
                performTask(parts);
                break;
            case "attack":
                attackRobot(parts);
                break;
            case "get":
                getAllRobots();
                break;
            case "end":
                System.exit(0);
                break;
            default:
                System.out.println("unknown command");
        }
    }

    private void createRobot(String[] parts) {
        String type = parts[1];
        String id = parts[3];
        RobotFactory factory = factories.get(type);
        if (factory != null) {
            Robot robot = factory.createRobot(id, Arrays.copyOfRange(parts, 4, parts.length));
            robots.put(id, robot);
        } else
            System.out.println("unknown command");
    }

    private void deliverRobot(String[] parts) {
        String id = parts[2];
        Robot robot = robots.get(id);
        if (robot instanceof DeliveryRobot)
            ((DeliveryRobot) robot).deliver();
        else
            System.out.println("invalid robot id");
    }

    private void cleanRobot(String[] parts) {
        String id = parts[2];
        int area = Integer.parseInt(parts[3]);
        Robot robot = robots.get(id);
        if (robot instanceof CleaningRobot)
            ((CleaningRobot) robot).clean(area);
        else
            System.out.println("invalid robot id");
    }

    private void performTask(String[] parts) {
        String id = parts[3];
        Robot robot = robots.get(id);
        if (robot instanceof SecurityRobot)
            ((SecurityRobot) robot).monitor();
        else
            System.out.println("invalid robot id");
    }

    private void attackRobot(String[] parts) {
        String id = parts[2];
        int enemyPower = Integer.parseInt(parts[3]);
        Robot robot = robots.get(id);
        if (robot instanceof SecurityRobot) {
            ((SecurityRobot) robot).attack(enemyPower);
            if (!((SecurityRobot) robot).isAlive())
                robots.remove(id);
        } else
            System.out.println("invalid robot id");
    }

    private void getAllRobots() {
        ArrayList<Robot> allRobots = new ArrayList<>(robots.values());
        allRobots.sort(Comparator.comparing(Robot::getId));
        for (Robot robot : allRobots)
            System.out.println("robot " + robot.getId() + " " + robot.getType());
    }
}