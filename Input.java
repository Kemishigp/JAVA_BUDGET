import java.util.*;

public class Input
{
    public static String StringInput(){
        Scanner Input = new Scanner(System.in);  // Create a Scanner object
        String BudgetItem = Input.nextLine().toUpperCase(); // Add items to a budget
        // Input.close();
        return BudgetItem;
    }

    public static Float FloatInput(){
        Scanner Input = new Scanner(System.in);  // Create a Scanner object
        Float ItemCost = Input.nextFloat();
        // Input.close();
        return ItemCost;}
}