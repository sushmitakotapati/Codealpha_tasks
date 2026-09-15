import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
  
        Scanner sc = new Scanner(System.in);

        System.out.println("STUDENT GRADE TRACKER");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];
        int[] marks = new int[n];

        int total = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Enter student name: ");
            names[i] = sc.nextLine();

            System.out.print("Enter student marks: ");
            marks[i] = sc.nextInt();
            sc.nextLine();

            total = total + marks[i];
        }

        int highest = marks[0];
        int lowest = marks[0];

        int highestIndex = 0;
        int lowestIndex = 0;
        
        for (int i = 1; i < n; i++) {

            if (marks[i] > highest) {
                highest = marks[i];
                highestIndex = i;
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
                lowestIndex = i;
            }
        }

        
        double average = (double) total / n;
        
        System.out.println("\n----- STUDENT DETAILS -----");

        for (int i = 0; i < n; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }

        
        System.out.println("\n----- CLASS RESULT -----");

        System.out.println("Average Marks: " + average);

        System.out.println("Highest Marks: " + highest);
        System.out.println("Student Name: " + names[highestIndex]);

        System.out.println("Lowest Marks: " + lowest);
        System.out.println("Student Name: " + names[lowestIndex]);

        sc.close();
    }
}