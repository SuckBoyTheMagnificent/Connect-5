public class Human
{
    int numHuman;
    int i;
    String name;
    Human [] HA;
    public Human (String name)
    {
        this.name = name;
    }
    public Human (int numHuman)
    {
        this.numHuman = numHuman;
        HA = new Human[numHuman];

    }
    public boolean addHuman(String s)
    {
        if (i < HA.length)
        {
            HA[i] = new Human(s);
            i++;
            return true;
        }
        else
            return false;
    }
    public String getHumanName()
    {
        return name;
    }
}