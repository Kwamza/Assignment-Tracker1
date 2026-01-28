import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main{
    public static void main(String[] args){
        AssignmentManger am = new AssignmentManger();
        
        while(true){
            System.out.println("Welcome to the Assignment Tracker");
            System.out.println();

            System.out.println("1. Add Assignment");
            System.out.println("2. Assignment Search");
            System.out.println("3. Manage Assignments");
            System.out.println("4. Display Assignments");
            System.out.println("5. Exit");

            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(input.nextLine());

            if(choice == 1){
                System.out.print("Enter assignment ID: ");

                int id = Integer.parseInt(input.nextLine());

                System.out.print("\nEnter assignment name: ");
                String title = input.nextLine();

                System.out.print("\nEnter course: ");
                String courseName = input.nextLine();

                System.out.print("\nEnter due date(DD-MM-YYYY): ");
                String dueDate = input.nextLine();
                
                System.out.println("Priority level 1: high priority\nPriority level 2: lower priority");
                System.out.print("Enter priority level 1 or 2: ");
                int priority = input.nextInt();

                am.AddAssignment(new Assignment(id, courseName, title, dueDate, priority, false));

            }
            else if(choice == 2){
                System.out.println("How would you like search for your assignment?");
                System.out.println("1. ID\n2. Assignment name");
                System.out.println();
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(input.nextLine());

                if(choice == 1){
                    System.out.print("\nEnter Assignment ID: ");
                    int id = Integer.parseInt(input.nextLine());
                    am.idSearch(id);
                     
                }
                else if(choice == 2){
                    System.out.print("\nEnter assignment name: ");
                    String assName = input.nextLine();
                    am.titleSearch(assName);
                }
                
            }
            else if(choice == 3){
                System.out.println("1. Edit assignment");
                System.out.println("2. Delete assignment");
                System.out.println("3. Mark Assignment complete");
                
                System.out.print("\nEnter choice: ");
                choice = Integer.parseInt(input.nextLine());

                if(choice == 1){
                    am.displayAll();
                    System.out.println();
                    System.out.print("Enter the ID of the assignment you want to edit: ");
                    int id = input.nextInt();
                    am.editAss(id);
                }
                else if(choice == 2){
                    am.displayAll();
                    System.out.println();
                    System.out.print("Enter the ID of the assignment you want to delete: ");
                    int id = input.nextInt();
                    am.deleteAss(id);

                }
                else if(choice == 3){
                    am.displayAll();
                    System.out.println();
                    System.out.print("\nEnter the ID of the assignment you completed: ");
                    int id = input.nextInt();
                    am.markComplete(id);
                }

            }
            else if(choice == 4){
                am.displayAll();
            }
            else if(choice == 5){
                return;
            }
        }
        
    }
}