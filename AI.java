public class AI 
{
	int numAI;
    int i;
    int turnNum;
    String name;
    AI [] aiArray;
    int[][][] myLocations;
    LookingClass myLooker = new LookingClass(0);
    
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
    
    //Hopeful "Pruning"//
    public boolean alphaBeta (int [][][] myBoard, int z, int x, int y, int t)
    {
    	myLocations = new int[myBoard.length][myBoard.length][myBoard.length];
    	while(z < myBoard.length)
    	{
    		for (int i = 0; i < myBoard.length; i++)
    		{
    			for(int j = 0; j < myBoard.length; j++)
    			{
    				if(myBoard[z][i][j] != t && myBoard[z][i][j] != 0)
    				{
    					myLocations[z][i][j] = myBoard[z][i][j];
    					myLooker.check(myLocations, z, i, j, t);
    					if(myLooker.winCounter == 4)
    					{
    						place(myLocations, z, i,j, t);
    						return true;
    					}
    				}
    			}
    		}
    		z++;
    	}
    	printAIBoard(myLocations);
    	return false;
    }
    public void printAIBoard(int[][][]myBoard)
    {
    	for(int z = 0; z < myBoard.length; z++)
    	{
    		for(int x = 0; x < myBoard.length; x++)
    		{
    			for(int y = 0; y < myBoard.length; y++)
    			{
    				System.out.print(myBoard[z][x][y]);
    			}
    			System.out.println();
    		}
    		System.out.println();
    	}
    }
}
