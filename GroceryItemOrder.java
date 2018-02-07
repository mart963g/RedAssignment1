public class GroceryItemOrder
{
    private String name;
    private int quantity;
    private double costPerUnit;

    public GroceryItemOrder(String name)
    {
        this.name = name;
        this.quantity = 1;
        this.costPerUnit = 10.00;
    }

    public GroceryItemOrder(String name, int quantity, double costPerUnit)
    {
        this.name = name;
        this.quantity = quantity;
        this.costPerUnit = costPerUnit;
    }

    public double getTotalCost()
    {
        return (double)(this.quantity*this.costPerUnit);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getCostPerUnit()
    {
        return this.costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit)
    {
        this.costPerUnit = costPerUnit;
    }


    @Override
    public boolean equals(Object other)
    {
        boolean result = false;
        if(other instanceof GroceryItemOrder)
        {
            GroceryItemOrder that = (GroceryItemOrder) other;
            result=(this.name.toLowerCase().equals(that.name.toLowerCase()));
        }
        return result;
    }

    @Override
    public String toString()
    {
        return String.format("\nName: %s, Quantity: %d, Total Cost: %.2f",this.name,this.quantity,this.getTotalCost());
    }
}
