import java.util.ArrayList;
import java.util.Arrays;

public class CleaningRobotFactory extends RobotFactory {
    @Override
    public Robot createRobot(String id, String... args) {
        ArrayList<Integer> areas = new ArrayList<>();
        for (String area : Arrays.copyOfRange(args,1,args.length))
            areas.add(Integer.parseInt(area));
        return new CleaningRobot(id, Integer.parseInt(args[0]), areas);
    }
}
