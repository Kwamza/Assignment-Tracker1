import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main{
    public static void main(String[] args){
        
        System.out.println("Welcome to the Assignment Tracker");
        System.out.println();

        System.out.println("1. Add Assignment");
        System.out.println("2. Assignment Search");
        System.out.println("3. Manage Assignments");
        System.out.println("4. Display Assignments");

        Scanner input = new Scanner(System.in);
        int choice = Integer.parseInt(input.nextLine());

        if(choice == 1){
            System.out.print("\nEnter assignment name: ");
            String assName = input.nextLine();

            System.out.print("\nEnter course: ");
            String courseName = input.nextLine();

            System.out.print("\nEnter due date(DD-MM-YYYY): ");
            String dueDate = input.nextLine();

        }
    }
}