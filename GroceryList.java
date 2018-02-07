public class GroceryList
{
    private GroceryItemOrder[] groceryList;

    public GroceryList()
    {
        this.groceryList = new GroceryItemOrder[10];
    }

    public void add(GroceryItemOrder item)
    {
        //Tjekker om arrayet er fyldt. Hvis ja laver nyt array
        //der er dobbelt så langt og fylder den første halvdel op
        //med det gamle array

        if(this.size()==this.groceryList.length)
        {
            GroceryItemOrder[] tempList = new GroceryItemOrder[this.groceryList.length*2];
            for (int i = 0; i < groceryList.length; i++)
            {
                tempList[i]=this.groceryList[i];
            }
            this.groceryList=tempList;
        }
        //Tjekker om pladsen i arrayet er fyldt
        //og tilføjer elementet til første tomme plads

        boolean added = false;
        int i = 0;
        while(!added)
        {
            if(this.groceryList[i]==null)
            {
                this.groceryList[i] = item;
                added=true;
            }
            else
            {
                i++;
            }
        }
    }

    public GroceryItemOrder get(int i)
    {
        //Returnerer objektet på index i

        if(i<this.size())
        {
            return this.groceryList[i];
        } else
        {
            System.out.println("Error, index out of bounds!");
            return null;
            //throw new IndexOutOfBoundsException();
        }
    }

    public void remove(int i)
    {
        //Tjekker om i er indenfor de fyldte pladser og sletter så
        //det valgte objekt.

        int size = this.size();
        if(i<size)
        {
            this.groceryList[i]=null;

            //Forskyder alle efterfølgende objekter i arrayet
            //én plads opad mod 0, så der ikke er nogen tomme
            //pladser før slutningen af arrayet.

            for(int j = i;j<size-1;j++)
            {
                this.groceryList[j]=this.groceryList[j+1];
            }
            this.groceryList[size-1]=null;
        } else
        {
            System.out.println("Error, index out of bounds!");
            //throw new IndexOutOfBoundsException();
        }
    }

    public void remove(GroceryItemOrder item)
    {
        //Looper arrayet igennem og tjekker om item
        //matcher det aktive objekt. Kalder herefter
        //den første remove metode på objektets index.
        //Breaker herefter loopet for kun at fjerne
        //første instans af det givne objekt.

        boolean removed = false;
        for (int i = 0; i < this.size(); i++)
        {
            if(this.groceryList[i].equals(item))
            {
                this.remove(i);
                removed = true;
                break;
            }
        }
        if(!removed)
        {
            System.out.println("Error, list does not contain item!");
        }
    }

    /*
    public void removeAll(GroceryItemOrder item)
    {
        //Præcis det samme som remove(GroceryItemOrder item)
        //bare uden at breake loopet så den
        //fjerner alle instanser af objektet

        boolean removed = false;
        for (int i = 0; i < this.size(); i++)
        {
            if(this.groceryList[i].equals(item))
            {
                this.remove(i);
                removed = true;
            }
        }
        if(!removed)
        {
            System.out.println("Error, list does not contain item!");
        }
    }
    */

    public double getTotalCost()
    {
        double cost = 0.00;
        for(int i = 0;i<this.size();i++)
        {
            cost += this.groceryList[i].getTotalCost();
        }
        return cost;
    }

    public int size()
    {
        int count = 0;
        for (int i = 0; i < groceryList.length; i++)
        {
            if(groceryList[i]!=null)
                count++;
        }
        return count;
    }

    public boolean contains(GroceryItemOrder item)
    {
        for (int i = 0; i < this.size(); i++)
        {
            if(this.groceryList[i].equals(item))
            {
                return true;
            }
        }
        return false;
    }

    public void clear()
    {
        this.groceryList = new GroceryItemOrder[10];
    }

    @Override
    public String toString()
    {
        String str = "Grocery List:\n[";
        for (int i = 0; i < this.size(); i++)
        {
            //if(this.groceryList[i]!=null)
                str = str + this.groceryList[i].toString();
        }
        return str + "\n]";
    }


}
