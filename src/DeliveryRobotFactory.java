public class DeliveryRobotFactory extends RobotFactory {
    @Override
    public Robot createRobot(String id, String... args) {
        return new DeliveryRobot(id, args[0]);
    }
}
