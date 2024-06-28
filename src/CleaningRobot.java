import java.util.ArrayList;

public class CleaningRobot extends Robot {
    private int numTasks;
    private final ArrayList<Integer> areas;

    public CleaningRobot(String id, int numTasks, ArrayList<Integer> areas) {
        super(id);
        this.numTasks = numTasks;
        this.areas = areas;
    }

    public int getNumTasks() {
        return numTasks;
    }

    public void decreaseTasks() {
        numTasks--;
    }

    public ArrayList<Integer> getAreas() {
        return areas;
    }

    @Override
    public String getType() {
        return "cleaning";
    }

    public void clean(int area) {
        if (numTasks == 0)
            System.out.println("this robot is retired");
        else if (!areas.contains(area))
            System.out.println("invalid area");
        else {
            decreaseTasks();
            System.out.println("cleaning robot " + id + " cleaned the area");
        }
    }
}
