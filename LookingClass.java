public class LookingClass
{
    boolean win;
    int i;
    int t;
    int w;
    int x;
    int y;
    int z;
    int winCounter;
    public LookingClass(int i)
    {
        this.i = i;
    }
    
    //Use this to check if a location next to you is yours// 
    public boolean look(int[][][] myBoard, int z, int x, int y, int t)
    {
        if (z < 0 || x < 0 || y < 0 || z >= myBoard.length || x >= myBoard[z].length 
              || y >= myBoard[z][x].length || myBoard[z][x][y] == 0 || myBoard[z][x][y] != t)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public boolean wrap(int[][][] myBoard, int z, int x, int y, int t)
    {
        if ((y == myBoard.length-1 && myBoard[z][x][0] == t) || (y == 0 && myBoard[z][x][myBoard.length-1] == t)) //Horizontal
        {
            return true;
        }
        else if ((x == myBoard.length-1 && myBoard[z][0][y] == t) || (x == 0 && myBoard[z][myBoard.length-1][y] == t)) //Vertical Rows
        {
            return true;
        }
        else if ((z == myBoard.length-1 && myBoard[0][x][y] == t) || (z == 0 && myBoard[myBoard.length-1][x][y] == t)) //Vertical Floors
        {
            return true;
        }
        else if ((x == myBoard.length-1 && myBoard[z][0][y] == t) || (x == 0 && myBoard[z][myBoard.length-1][y] == t)) //Diagonal One Floor FIXME
        {
            return true;
        }
        else if ((x == myBoard.length-1 && myBoard[z][0][y] == t) || (x == 0 && myBoard[z][myBoard.length-1][y] == t)) //Other Diagonal One Floor FIXME
        {
            return true;
        }
        else if ((x == myBoard.length-1 && myBoard[z][0][y] == t) || (x == 0 && myBoard[z][myBoard.length-1][y] == t)) //Diagonal multiple floor FIXME
        {
            return true;
        }
        else if ((x == myBoard.length-1 && myBoard[z][0][y] == t) || (x == 0 && myBoard[z][myBoard.length-1][y] == t)) // Other Diagonal multiple floor FIXME
        {
            return true;
        }
        else if ((x == myBoard.length-1 && myBoard[z][0][y] == t) || (x == 0 && myBoard[z][myBoard.length-1][y] == t)) // Other Diagonal multiple floor FIXME
        {
            return true;
        }
        else if ((x == myBoard.length-1 && myBoard[z][0][y] == t) || (x == 0 && myBoard[z][myBoard.length-1][y] == t)) // Other Diagonal multiple floor FIXME
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //Use this method to check for win conditions//  
    public void check(int[][][]myBoard, int z, int x, int y, int t)
	{
    	boolean found = false;
    	while (!found)
    	{
    		int tempX = x;
    		int tempY = y;
    		int tempZ = z;
    		if (look(myBoard, z, x, y+1, t) == true || look(myBoard, z, x, y-1, t) == true || wrap(myBoard, z, x, y, t) == true)  // Looks left and right
    		{
    			winCounter = 1;
    			if (look(myBoard, z, x, 0, t) == true && y == myBoard.length-1)
    				{
    				    y = 0;
    				    winCounter++;
    				}
    			while (look(myBoard, z, x, y+1, t) == true)
    			{
    				winCounter++;
    				y++;
    				if (look(myBoard, z, x, 0, t) == true && y == myBoard.length-1)
    				{
    				    y = 0;
    				    winCounter++;
    				}
    			}
    			x = tempX;
    			y = tempY;
    			z = tempZ;
    			if (look(myBoard, z, x, myBoard.length-1, t) == true && y == 0)
    				{
    				    y = myBoard.length-1;
    				    winCounter++;
    				}
    			while (look(myBoard, z, x, y - 1, t) == true || (look(myBoard, z, x, myBoard.length-1, t) == true && y == 0)) 
    			{
    				winCounter++;
    				y--;
    				if (look(myBoard, z, x, myBoard.length-1, t) == true && y == 0)
    				{
    				    y = myBoard.length-1;
    				    winCounter++;
    				}
	            }  
    			System.out.println("Win counter: " + winCounter);
    			if (winCounter >= 5)
    			{
    				win = true;
    				found = true;
    				break;
    			} 
    			else
    			{
    				winCounter = 0;
    			}
    		}
    		
    		x = tempX;
			y = tempY;
			z = tempZ;
    		if (look(myBoard, z, x+1, y, t) == true || look(myBoard, z, x-1, y, t) == true)  // Looks up and down rows
    		{
    			winCounter = 1;
    			while (look(myBoard, z, x+1, y, t) == true)
    			{
    				winCounter++;
    				x++;
    				if (x+1 == myBoard.length)
    				{
    				    x = 0;
    				    if (look(myBoard, z, x, y, t) == true)
    				    {
    				        winCounter++;
    				    }
    				}
    			}
    			x = tempX;
    			y = tempY;
    			z = tempZ;
    			while (look(myBoard, z, x-1, y, t) == true)
    			{
    				winCounter++;
    				x--;
    				if (x == 0)
    				{
    				    x = myBoard.length-1;
    				    if (look(myBoard, z, x, y, t) == true)
    				    {
    				        winCounter++;
    				    }
    				}
    			}  
    			System.out.println("Win counter: " + winCounter);
    			if (winCounter >= 5)
    			{
    				win = true;
    				found = true;
    				break;
    			} 
    			else
    			{
    				winCounter = 0;
    			}
    		}
    		
    		x = tempX;
			y = tempY;
			z = tempZ;
    		if (look(myBoard, z, x+1, y+1, t) == true || look(myBoard, z, x-1, y-1, t) == true)  // Looks Diagonally on one row
    		{
    			winCounter = 1;
    			while (look(myBoard, z, x+1, y+1, t) == true)
    			{
    				winCounter++;
    				x++;
    				y++;
    			}
    			x = tempX;
    			y = tempY;
    			z = tempZ;
    			while (look(myBoard, z, x-1, y-1, t) == true) 
    			{
    				winCounter++;
    				x--;
    				y--;
    			}  
    			System.out.println("Win counter: " + winCounter);
    			if (winCounter >= 5)
    			{
    				win = true;
    				found = true;
    				break;
    			} 
    			else
    			{
    				winCounter = 0;
    			}
    		}
    		
    		x = tempX;
			y = tempY;
			z = tempZ;
    		if (look(myBoard, z, x+1, y-1, t) == true || look(myBoard, z, x-1, y+1, t) == true)  // Looks other diagonal on one row
    		{
    			winCounter = 1;
    			while (look(myBoard, z, x+1, y-1, t) == true)
    			{
    				winCounter++;
    				x++;
    				y--;
    			}
    			x = tempX;
    			y = tempY;
    			z = tempZ;
    			while (look(myBoard, z, x-1, y+1, t) == true) 
    			{
    				winCounter++;
    				x--;
    				y++;
    			}  
    			System.out.println("Win counter: " + winCounter);
    			if (winCounter >= 5)
    			{
    				win = true;
    				found = true;
    				break;
    			} 
    			else
    			{
    				winCounter = 0;
    			}
    		}
    		
    		x = tempX;
			y = tempY;
			z = tempZ;
    		if (look(myBoard, z+1, x, y, t) == true || look(myBoard, z-1, x, y, t) == true)  // Looks vertical over floors, checking up floors might be unnecessary
    		{
    			winCounter = 1;
    			while (look(myBoard, z+1, x, y, t) == true)
    			{
    				winCounter++;
    				z++;
    			}
    			x = tempX;
    			y = tempY;
    			z = tempZ;
    			while (look(myBoard, z-1, x, y, t) == true) 
    			{
    				winCounter++;
    				z--;
    			}  
    			System.out.println("Win counter: " + winCounter);
    			if (winCounter >= 5)
    			{
    				win = true;
    				found = true;
    				break;
    			} 
    			else
    			{
    				winCounter = 0;
    			}
	        }
	    	
    		x = tempX;
			y = tempY;
			z = tempZ;
    		if (look(myBoard, z+1, x+1, y+1, t) == true || look(myBoard, z-1, x-1, y-1, t) == true)  // Looks multiple floor diagonal for up floor, down row, right
    		{																						 // or down floor, up row, left	
    			winCounter = 1;
    			while (look(myBoard, z+1, x+1, y+1, t) == true)
    			{
    				winCounter++;
    				z++;
    				x++;
    				y++;
    			}
    			x = tempX;
    			y = tempY;
    			z = tempZ;
    			while (look(myBoard, z-1, x-1, y-1, t) == true)
    			{
    				winCounter++;
    				z--;
    				x--;
    				y--;
    			}  
    			System.out.println("Win counter: " + winCounter);
    			if (winCounter >= 5)
    			{
    				win = true;
    				found = true;
    				break;
    			} 
    			else
    			{
    				winCounter = 0;
    			}
    		}
    		
    		x = tempX;
			y = tempY;
			z = tempZ;
    		if (look(myBoard, z+1, x-1, y-1, t) == true || look(myBoard, z-1, x+1, y+1, t) == true)  // Looks multiple floor diagonal for up floor, up row, left
    		{																						 // or down floor, down row, right
    			winCounter = 1;
    			while (look(myBoard, z+1, x-1, y-1, t) == true)
    			{
    				winCounter++;
    				z++;
    				x--;
    				y--;
    			}
    			x = tempX;
    			y = tempY;
    			z = tempZ;
    			while (look(myBoard, z-1, x+1, y+1, t) == true)
    			{
    				winCounter++;
    				z--;
    				x++;
    				y++;
    			}  
    			System.out.println("Win counter: " + winCounter);
    			if (winCounter >= 5)
    			{
    				win = true;
    				found = true;
    				break;
    			} 
    			else
    			{
    				winCounter = 0;
    			}
    		}
    		
    		x = tempX;
			y = tempY;
			z = tempZ;
    		if (look(myBoard, z+1, x-1, y+1, t) == true || look(myBoard, z-1, x+1, y-1, t) == true)  // Looks multiple floor diagonal for up floor, up row, right
    		{																						 // or down floor, down row, left
    			winCounter = 1;
    			while (look(myBoard, z+1, x-1, y+1, t) == true)
    			{
    				winCounter++;
    				z++;
    				x--;
    				y++;
    			}
    			x = tempX;
    			y = tempY;
    			z = tempZ;
    			while (look(myBoard, z-1, x+1, y-1, t) == true)
    			{
    				winCounter++;
    				z--;
    				x++;
    				y--;
    			}  
    			System.out.println("Win counter: " + winCounter);
    			if (winCounter >= 5)
    			{
    				win = true;
    				found = true;
    				break;
    			} 
    			else
    			{
    				winCounter = 0;
    			}                 
    		}
    		
    		x = tempX;
			y = tempY;
			z = tempZ;
    		if (look(myBoard, z+1, x+1, y-1, t) == true || look(myBoard, z-1, x-1, y+1, t) == true)  // Looks multiple floor diagonal for up floor, down row, left
    		{																						 // or down floor, up row, right
    			winCounter = 1;
    			while (look(myBoard, z+1, x+1, y-1, t) == true)
    			{
    				winCounter++;
    				z++;
    				x++;
    				y--;
    			}
    			x = tempX;
    			y = tempY;
    			z = tempZ;
    			while (look(myBoard, z-1, x-1, y+1, t) == true)
    			{
    				winCounter++;
    				z--;
    				x--;
    				y++;
    			}  
    			System.out.println("Win counter: " + winCounter);
    			if (winCounter >= 5)
    			{
    				win = true;
    				found = true;
    				break;
    			} 
    			else
    			{
    				winCounter = 0;
    			}
    		}
    		
    		if (winCounter <5)
    		{
    			System.out.println("Win counter: " + winCounter);
    			found = true;
    		}
    	}
	}
}