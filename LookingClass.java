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
    
    //Use this method to check for win conditions//  
    public void check(int[][][]myBoard, int z, int x, int y, int t)
	{
    	boolean found = false;
    	while (!found)
    	{
    		int tempX = x;
    		int tempY = y;
    		int tempZ = z;
    		if (look(myBoard, z, x, y+1, t) == true || look(myBoard, z, x, y-1, t) == true)  // Looks left and right
    		{
    			winCounter = 1;
    			while (look(myBoard, z, x, y+1, t) == true)
    			{
    				winCounter++;
    				y++;
    			}
    			x = tempX;
    			y = tempY;
    			z = tempZ;
    			while (look(myBoard, z, x, y - 1, t) == true) 
    			{
    				winCounter++;
    				y--;
	            }  
    			System.out.println("Win counter: " + winCounter);
    			if (winCounter >= 5)
    			{
    				win = true;
    				found = true;
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
    			}
    			x = tempX;
    			y = tempY;
    			z = tempZ;
    			while (look(myBoard, z, x-1, y, t) == true)
    			{
    				winCounter++;
    				x--;
    			}  
    			System.out.println("Win counter: " + winCounter);
    			if (winCounter >= 5)
    			{
    				win = true;
    				found = true;
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
    			} 
    			else
    			{
    				winCounter = 0;
    			}
	        }
	    	
    		x = tempX;
			y = tempY;
			z = tempZ;
    		if (look(myBoard, z+1, x+1, y+1, t) == true || look(myBoard, z-1, x-1, y-1, t) == true)  // Looks multifloor diagonal for up floor, down row, right 	udr
    		{																						 // or down floor, up row, left									dul
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
    			} 
    			else
    			{
    				winCounter = 0;
    			}
    		}
    		
    		x = tempX;
			y = tempY;
			z = tempZ;
    		if (look(myBoard, z+1, x-1, y-1, t) == true || look(myBoard, z-1, x+1, y+1, t) == true)  // Looks multifloor diagonal for up floor, up row, left	uul
    		{																						 // or down floor, down row, right							ddr
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
    			} 
    			else
    			{
    				winCounter = 0;
    			}
    		}
    		
    		x = tempX;
			y = tempY;
			z = tempZ;
    		if (look(myBoard, z+1, x-1, y+1, t) == true || look(myBoard, z-1, x+1, y-1, t) == true)  // Looks multifloor diagonal for up floor, up row, right 			uur
    		{																						 // or down floor, down row, left									ddl
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
    			} 
    			else
    			{
    				winCounter = 0;
    			}                 
    		}
    		
    		x = tempX;
			y = tempY;
			z = tempZ;
    		if (look(myBoard, z+1, x+1, y-1, t) == true || look(myBoard, z-1, x-1, y+1, t) == true)  // Looks multifloor diagonal for up floor, down row, left	udl
    		{																						 // or down floor, up row, right							dur
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