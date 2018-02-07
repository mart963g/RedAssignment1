import java.util.ArrayList;

public class GroceryList2
{
    private ArrayList<GroceryItemOrder> groceryList2;

    public GroceryList2()
    {
        this.groceryList2 = new ArrayList<GroceryItemOrder>();
    }

    public void add(GroceryItemOrder item)
    {
        this.groceryList2.add(item);
    }

    public void remove(GroceryItemOrder item)
    {
        this.groceryList2.remove(item);
    }
}
