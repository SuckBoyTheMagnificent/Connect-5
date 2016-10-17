public class Human
{
    int numHuman;
    int i;
    int turnNum;
    String name;
    Human [] HA;
    
    public Human (String name, int turnNum)
    {
        this.name = name;
        this.turnNum = turnNum;
    }
    public Human (int numHuman)
    {
        this.numHuman = numHuman;
        HA = new Human[numHuman];

    }
    public boolean addHuman(String s, int n)
    {
        if (i < HA.length)
        {
            HA[i] = new Human(s, n);
            i++;
            return true;
        }
        else
            return false;
    }
    public String getHumanName(int j)
    {
        return HA[j].name;
    }
    public int getHumanNum(int k)
    {
    	return HA[k].turnNum; 
    }
}