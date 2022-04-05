import java.util.*;

public class Project6 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    List<String> list = new ArrayList<String>();

    int choice;
    String s1, s2, s3;

    do {
      System.out.println("1. Insert");
      System.out.println("2. Search");
      System.out.println("3. Delete");
      System.out.println("4. Display");
      System.out.println("5. Exit");
      System.out.println("Enter your choice: ");

      choice = in.nextInt();

      switch(choice) {
        case 1:
          System.out.println("Enter the element to be inserted: ");
          s1 = in.next();
          list.add(s1);
          System.out.println("Inserted Successfully");
          break;
        case 2:
          System.out.println("Enter the element to search: ");
          s2 = in.next();
          if(list.contains(s2))
            System.out.println("Item found in the list");
          else
            System.out.println("Item not found in the list");
          break;
        case 3:
          System.out.println("Enter the element to delete: ");
          s3 = in.next();
          if(list.contains(s3)) {
            list.remove(s3);
            System.out.println("Deleted Successfully");
          }
          else
            System.out.println("Item does not exist.");
          break;
        case 4:
          System.out.println("The items in the list are: ");
          for(String s : list)
            System.out.println(s);
          break;
        case 5:
          System.exit(0);
        default:
          System.out.println("Invalid choice");
      }
    } while(choice != 5);    

    in.close();
  }
}