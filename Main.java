import java.io.File;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //Grocery

        GroceryItemOrder item1 = new GroceryItemOrder("Box of cookies",4,9.95);
        GroceryItemOrder item2 = new GroceryItemOrder("TidePods",1,43.50);
        GroceryItemOrder item3 = new GroceryItemOrder("Milk");
        GroceryItemOrder item4 = new GroceryItemOrder("Pasta",2,15.00);
        GroceryItemOrder item5 = new GroceryItemOrder("Juice");
        GroceryItemOrder item6 = new GroceryItemOrder("Pair of socks",3,17.95);
        GroceryItemOrder item7 = new GroceryItemOrder("Underpants",5,20.00);
        GroceryItemOrder item8 = new GroceryItemOrder("0.5 L coke");
        GroceryItemOrder item9 = new GroceryItemOrder("80 Plastic cups",1,80.00);
        GroceryItemOrder item10 = new GroceryItemOrder("Yogurt");
        GroceryItemOrder item11 = new GroceryItemOrder("Toilet Paper",2,24.95);

        /*
        GroceryList groceryList = new GroceryList();
        System.out.println(groceryList.size());
        groceryList.add(item1);
        groceryList.add(item2);
        groceryList.add(item3);
        groceryList.add(item4);
        groceryList.add(item5);
        groceryList.add(item6);
        groceryList.add(item7);
        groceryList.add(item8);
        groceryList.add(item9);
        groceryList.add(item10);
        groceryList.add(item11);
        groceryList.add(item1);
        groceryList.add(item2);
        groceryList.add(item3);
        groceryList.add(item4);
        groceryList.add(item5);
        groceryList.add(item6);
        groceryList.add(item7);
        groceryList.add(item8);
        groceryList.add(item9);
        groceryList.add(item10);
        */
        //groceryList.remove(0);
        GroceryList groceryList = new GroceryList();
        readGroceryList(groceryList);
        groceryList.removeAll(item1);
        groceryList.remove(item1);
        System.out.println(groceryList.get(0));
        System.out.println(groceryList.contains(item4));
        System.out.println(groceryList.contains(item3));
        //System.out.println(groceryList);
        System.out.println(groceryList.size());
        //groceryList.get(30);
        //groceryList.remove(30);
        groceryList.remove(0);
        System.out.println(groceryList.size());
        System.out.println(groceryList);

        System.out.printf("Total cost of list: %.2f kr,-",groceryList.getTotalCost());

    }

    public static void readGroceryList(GroceryList groceryList)
    {
        File file = new File("Orders.txt");
        try
        {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine())
            {
                String nextLine = scanner.nextLine();
                String[] order = nextLine.split(":");
                groceryList.add(new GroceryItemOrder(order[0],
                        Integer.parseInt(order[1]),
                        Double.parseDouble(order[2])));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
