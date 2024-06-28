public class DeliveryRobot extends Robot {
    private String vehicle;

    public DeliveryRobot(String id, String vehicle) {
        super(id);
        this.vehicle = vehicle;
    }

    public String getVehicle() {
        return vehicle;
    }

    @Override
    public String getType() {
        return "delivery";
    }

    public void deliver() {
        System.out.println("delivery robot " + id + " sent the pocket by " + vehicle);
    }
}
