import java.util.*;

public class Main {
  public static float CalculateSum(HashMap<String, Float> argsHashMap){
    float sum = 0.0f;
      for (float f : argsHashMap.values()) 
      {
        sum += f;
      }
      System.out.println("SUM: " + sum);
      return sum;
  }


  public static void main(String[] args) {
    /*Create a Hashmap for budget expenses
    and a list to store the cost of items in the budget*/
    HashMap<String, Float> BudgetHash = new HashMap<String, Float>();
    HashMap<String, Float> DummyHash = new HashMap<String, Float>();

    // ASK THE USER FOR A BUDGET LIMIT
    System.out.println("Enter a monthly budget limit");
    Float BudgetLimit = Input.FloatInput();
    System.out.println("Budget limit is: " + BudgetLimit);  // Print budget limit
    boolean EditBudget = true;
    boolean ReachedLimit = true;
    /* WHILE LOOP THAT LETS USER ADD NEW ITEMS TO BUDGET AND RECORD THEIR COST
    LOOP WILL END ONCE THE BUDGET LIMIT HAS BEEN REACHED*/
    while (EditBudget == true)
    {
      // RECORD THE BUDGET ITEM
      System.out.println("What item would you like to add to your budget? "); 
      String BudgetItem = Input.StringInput();
      // RECORD BUDGET ITEM'S COST
      System.out.println("How much does "+BudgetItem + " cost? ");
      Float ItemCost = Input.FloatInput();

      // FUNCTION TO CALCULATE TOTAL SUM OF BUDGET EXPENSES
      DummyHash.put(BudgetItem,ItemCost);
      Float sum = CalculateSum(DummyHash);
//  FOR LOOP GOES THROUGH THE DUMMY HASH TO DETERMINE IF THE BUDGET LIMIT HAS BEEN REACHED OR NOT

/* IF STATEMENTS FOR WHEN THE BUDGET LIMIT IS REACHED*/
      if (sum > BudgetLimit)
      {
        DummyHash.remove(BudgetItem);
        ReachedLimit = true;
        System.out.println("Cannot add "+BudgetItem+" to budget");
        System.out.println("Budget limit has been reached, you must increase the budget limit or remove previous expenses");
        System.out.println("Do you wish to remove an item from your budget? (YES/NO) ");
        // WHILE STATEMENT TO ENSURE THE BUDGET LIMIT ISN'T EXCEEDED
        while (ReachedLimit == true){
          // IF THEY CHOOSE TO REMOVE AN ITEM
          String AddRemove = Input.StringInput();
          if (AddRemove.equals("YES")){
            
            System.out.println("What item would you like to remove? ");
            for (String i : BudgetHash.keySet()) 
            {
              System.out.println(i+"   $"+BudgetHash.get(i));
            }
            String ItemRemove = Input.StringInput();
            BudgetHash.remove(ItemRemove);
            DummyHash.remove(ItemRemove);
            System.out.println(ItemRemove+" has been removed");
            System.out.println("Budget: ");
            for (String i : BudgetHash.keySet()) 
            {
              System.out.println(i+"   $"+BudgetHash.get(i));
            }
            ReachedLimit = false;
          }
// IF THEY DON'T CHOOSE TO REMOVE AN ITEM
          else if (AddRemove.equals("NO")){
            boolean response = false;
            while(response == false){
              System.out.println("Do you want to increase the budget Limit? (YES/NO) ");
              String Increase = Input.StringInput();
          // LOOP ENDS IF THEY DON'T DECIDE TO EDIT THE BUDGET
              if (Increase.equals("NO")){
                EditBudget = false;
                ReachedLimit = false;
                response = true;
              }
              else if (Increase.equals("YES")){
                System.out.println("Enter new budget limit: ");
                BudgetLimit = Input.FloatInput();
                ReachedLimit = false;
                response = true;
              }
              else {
                System.out.println(Increase+" wasn't a valid response please enter Yes or No: ");
              }
          }
          }
          // IF THEY DON'T ENTER YES OR NO
          else{
            System.out.println(AddRemove+" wasn't a valid response please enter Yes or No: ");
            ReachedLimit = true;
        }
      }
    }
      if (sum <= BudgetLimit)
      {
        BudgetHash.put(BudgetItem, ItemCost);
      }
      // END OF WHILE LOOP //
    }
    System.out.println("Congrats! You've finished building your budget");
    for (String i : BudgetHash.keySet()) 
    {
      System.out.println(i+"   $"+BudgetHash.get(i));
    }
    CalculateSum(BudgetHash);

  }
  }
/* 1. Ask for budget limit
 * 2. Ask if add item to budget
 * 3. Ask for cost/expense (float)
 * 4. Ask for item related to expense (String)
 * 5. Add item & price to dictionary
 * 6. Ask for a new expense
 * 7. Once it nears the budget limit show a warning
 * > Calculate the total sum of the values in the dictionary
 * > Check if adding the desired item would exceed the budget limit
 * 8. If budget limit is exceeded prevent additions onto the budget
 * 9. Ask to delete items from the budget
 */