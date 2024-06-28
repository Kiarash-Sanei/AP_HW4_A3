import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        while (true) {
            String command = scanner.nextLine();
            manager.executeCommand(command);
        }
    }
}
