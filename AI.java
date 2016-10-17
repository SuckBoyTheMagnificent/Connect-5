public class AI 
{
	int numAI;
    int i;
    int turnNum;
    String name;
    AI [] aiArray;
    
    public AI (String name, int turnNum)
    {
        this.name = name;
        this.turnNum = turnNum;
    }
    public AI (int numAI)
    {
        this.numAI = numAI;
        aiArray = new  AI [numAI];

    }
    public boolean addAI(String s, int n)
    {
        if (i < aiArray.length)
        {
            aiArray[i] = new AI(s, n);
            i++;
            return true;
        }
        else
        {
            return false;
        }
    }
    public String getAIName(int j)
    {
    	return aiArray[j].name;
    }
    public int getAINum(int k)
    {
    	return aiArray[k].turnNum;
    }
    public void place(int [][][] myBoard, int z, int x, int y, int t)
    {
    	int tempX = x;
    	int tempY = y;
    	int tempZ = z;
    	if (myBoard[z][x][y] != 0)
    	{
    		
    		while(myBoard[z][x][y] != 0)
    		{
    			y++;
    			if (y == myBoard[z][x].length)
    			{
    				y = tempY;
    				x++;
    			}
    			if (x == myBoard[z].length)
    			{
    				x = tempX;
    				z++;
    			}
    			if (z == myBoard.length)
    			{
    				z = tempZ;
    				break;
    			}
    		}
    		myBoard[z][x][y] = getAINum(t);
    	}
    	else
    	{
    		myBoard[z][x][y] = getAINum(t);
    	}
    }
}
