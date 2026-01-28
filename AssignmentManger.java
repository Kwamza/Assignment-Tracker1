import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class AssignmentManger {
    Assignment assignment;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String format = "%-5s %-20s %-15s %-12s %-10s%n";
    LinkedList<Assignment> priority = new LinkedList<>();
    ArrayList<Date> dueDates = new ArrayList<>();
    ArrayList<Assignment> assignments = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();




    public void AddAssignment(Assignment assignment){
        assignments.add(assignment);
        titles.add(assignment.title);
        assignment.id = titles.indexOf(assignment.title);
        Date dueDate = null;
        try {
            dueDate = sdf.parse(assignment.dueDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        dueDates.add(dueDate);

    }

    public void titleSearch(String title){
        title = title.strip();
        Assignment result = null;
        for(Assignment ass : assignments){
            if(ass.title.equalsIgnoreCase(title)){
                result = ass;
                displayResult(ass);
                break;
            }
        }
        if(result.equals(null)){
            System.out.println("result not found.");
        }
    }

    public void idSearch(int id){
        int result = -1;
        for(Assignment ass : assignments){
            if(ass.id == id){
                result = id;
                displayResult(ass);
                break;
            }
        }
        if(result == -1){
            System.out.println("result not found.");
        }
    }

    public void deleteAss(int id){
        int result = -1;
        for(Assignment ass : assignments){
            if(ass.id == id){
                result = id;
                assignments.remove(id);
                System.out.println("Assignment Deleted.");
                break;
            }
        }
        if(result == -1){
            System.out.println("result not found.");
        }
    }

    public void markComplete(int id){
        for(Assignment ass : assignments){
            if(ass.id == id){
                ass.completed = true;
                System.out.println("Assignment Complete.");
                break;
            }
        }
    }

    private void displayResult(Assignment ass){
        System.out.println("\nResult Found:");
            System.out.printf(format, "ID", "Assignment", "Course", "Due Date", "Complete");
            System.out.println("----------------------------------------------------------------");

            // 3. Print the specific row
            System.out.printf(format, 
                ass.id, 
                ass.title, 
                ass.courseName, 
                ass.dueDate, 
                ass.completed
            );
    }

    public void displayAll(){
        // 1. Define a format string
        // %-5s  means: Left-align (-) string (s) within 5 spaces
        // %-20s means: Left-align (-) string (s) within 20 spaces
        // %n    means: New line

        // 2. Print the Header using the format
        System.out.printf(format, "ID", "Assignment", "Course", "Due Date", "Complete");
        System.out.println("----------------------------------------------------------------");

        // 3. Print the Rows using the SAME format
        for (Assignment ass : assignments) {
            System.out.printf(format, 
                ass.id, 
                ass.title, 
                ass.courseName, 
                ass.dueDate, 
                ass.completed
            );
        }
    }

    public void editAss(int id) {
        for(Assignment ass : assignments){
            Scanner input = new Scanner(System.in);
            if(ass.id == id){
                System.out.println("Assignment ready to edit");
                System.out.println("1. Edit assignment title");
                System.out.println("2. Edit due date");

                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(input.nextLine());

                if(choice == 1){
                    System.out.print("Enter new title: ");
                    String newTitle = input.nextLine().strip();
                    ass.title = newTitle;
                    System.out.println("Title updated.");
                    return;
                }
                else if(choice == 2){
                    System.out.print("Enter new due date(dd-MM-YYYY): ");
                    String newDate = input.nextLine().strip();
                    ass.dueDate = newDate;
                    Date dueDate = null;
                    try {
                        dueDate = sdf.parse(ass.dueDate);
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    dueDates.set(id, dueDate);
                    System.out.println("Due date updated");
                    return;  
                }
            }

        }
        System.out.println("Assignment ID " + id + "not found");
    }
  
    
}
