public abstract class Robot {
    protected String id;

    public Robot(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract String getType();
}
