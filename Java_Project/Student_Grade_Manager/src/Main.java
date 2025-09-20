import java.util.*;

public class Main {
    // Data structure for storing students + grades
    private static final Map<String, Integer> grades = new HashMap<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Grade Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Show Statistics");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAll();
                case 3 -> searchStudent();
                case 4 -> showStats();
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter grade: ");
        int grade = sc.nextInt();

        grades.put(name,grade);
        System.out.println("Student added!");
    }

    private static void viewAll() {
        System.out.println("Total Students : "+ grades.size());
        for(Map.Entry<String,Integer> entry : grades.entrySet()){
            String key = entry.getKey();
            Integer grade = entry.getValue();

            System.out.println(key+ " got "+grade);
        }
    }

    private static void searchStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        if(grades.containsKey(name)){
            System.out.println(name + " : " + grades.get(name));
        }
        else{
            System.out.println("Student not found");
        }
    }

    private static void showStats() {
        if(grades.isEmpty()){
            System.out.println("No Students yet!");
            return;
        }
        Integer maxValue = Collections.max(grades.values());
        Integer minValue = Collections.min(grades.values());
        Integer sumValue = 0;
        for(Integer x : grades.values()){
            sumValue += x;
        }
        float average = (float) sumValue /grades.size();

        System.out.println("Average : "+average);
        System.out.println("Highest score : " + maxValue);
        System.out.println("Lowest score  : " + minValue);
        // TODO: calculate average, highest, and lowest grades
    }
}
