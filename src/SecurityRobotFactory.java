public class SecurityRobotFactory extends RobotFactory {
    @Override
    public Robot createRobot(String id, String... args) {
        return new SecurityRobot(id, Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }
}
