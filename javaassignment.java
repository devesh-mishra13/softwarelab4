import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Process {
    String pId;
    String name;
    int startTime;
    String priority;

    public Process(String pId, String name, int startTime, String priority) {
        this.pId = pId;
        this.name = name;
        this.startTime = startTime;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "P_ID: " + pId + ", Process: " + name + ", Start Time: " + startTime + ", Priority: " + priority;
    }
}

public class javaassignment {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", "VSCode", 100, "MID"));
        processes.add(new Process("P23", "Eclipse", 234, "MID"));
        processes.add(new Process("P93", "Chrome", 189, "High"));
        processes.add(new Process("P42", "JDK", 9, "High"));
        processes.add(new Process("P9", "CMD", 7, "High"));
        processes.add(new Process("P87", "NotePad", 23, "Low"));

        System.out.println("Sort by:");
        System.out.println("1. Process ID (P_ID)");
        System.out.println("2. Start Time (ms)");
        System.out.println("3. Priority");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.close();

        Comparator<Process> comparator;
        switch (choice) {
            case 1:
                comparator = Comparator.comparing(process -> process.pId);
                break;
            case 2:
                comparator = Comparator.comparingInt(process -> process.startTime);
                break;
            case 3:
                comparator = Comparator.comparing(process -> process.priority);
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        processes.sort(comparator);
        processes.forEach(System.out::println);
    }
}
