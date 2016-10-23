public class LookingClass
{
    boolean win;
    int i;
    int t;
    int w;
    int x;
    int y;
    int z;
    int winCounter = 0;
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
    
    //Check for wrapping possibilities//
    public boolean wrap(int[][][] myBoard, int z, int x, int y, int t)
    {
    	//Horizontal
        if ((y == myBoard.length-1 && myBoard[z][x][0] == t) || (y == 0 && myBoard[z][x][myBoard.length-1] == t))
        {
            return true;
        }
        
        //Vertical Rows
        else if ((x == myBoard.length-1 && myBoard[z][0][y] == t) || (x == 0 && myBoard[z][myBoard.length-1][y] == t)) 
        {
            return true;
        }
        
        //Vertical Floors
        else if ((z == myBoard.length-1 && myBoard[0][x][y] == t) || (z == 0 && myBoard[myBoard.length-1][x][y] == t)) 
        {
            return true;
        }
        
        //One floor diagonals
        else if ((y == myBoard.length-1 && x == myBoard.length-1 && myBoard[z][0][0] == t) || (y == 0 && x == 0 && myBoard[z][myBoard.length-1][myBoard.length-1] == t)) 
        {
            return true;
        }
        else if ((y == 0 && x == myBoard.length-1 && myBoard[z][0][myBoard.length-1] == t) || (y == myBoard.length-1 && x == 0 && myBoard[z][myBoard.length-1][0] == t)) 
        {
            return true;
        }
        
        //Middle of floor diagonals
        else if (x == myBoard.length-1 && y < myBoard.length-1 && myBoard[z][0][y+1] == t || x == myBoard.length-1 && y > 0 && myBoard[z][0][y-1] == t || 
        		x == 0 && y < myBoard.length-1 && myBoard[z][myBoard.length-1][y+1] == t || x == 0 && y > 0 && myBoard[z][myBoard.length-1][y-1] == t )	
        {
        	return true;
        }
        else if (y == myBoard.length-1 && x < myBoard.length-1 && myBoard[z][x+1][0] == t || y == myBoard.length-1 && x >0 && myBoard[z][x-1][0] == t || 
        		y == 0 && x < myBoard.length-1 && myBoard[z][x+1][myBoard.length-1] == t || y == 0 && x > 0 && myBoard[z][x-1][myBoard.length-1] == t)
        {
        	return true;
        }
        
        //Diagonal Multiple Floor wraps
        else if ((z == myBoard.length-1 && y == myBoard.length-1 && x == myBoard.length-1 && myBoard[0][0][0] == t) || 
        		(z == 0 && y == 0 && x == 0 && myBoard[myBoard.length-1][myBoard.length-1][myBoard.length-1] == t))  
        {
            return true;
        }
        else if ((z == myBoard.length-1 && y == 0 && x == myBoard.length-1 && myBoard[0][0][myBoard.length-1] == t) || 
        		( z == 0 && y == myBoard.length-1 && x == 0 && myBoard[myBoard.length-1][myBoard.length-1][0] == t))  
        {
            return true;
        }
        else if ((z == 0 && y == myBoard.length-1 && x == myBoard.length-1 && myBoard[myBoard.length-1][0][0] == t) || 
        		(z == myBoard.length-1 && y == 0 && x == 0 && myBoard[0][myBoard.length-1][myBoard.length-1] == t)) 
        {
            return true;
        }
        else if ((z == 0 && y == 0 && x == myBoard.length-1 && myBoard[myBoard.length-1][0][myBoard.length-1] == t) || 
        		( z == myBoard.length-1 && y == myBoard.length-1 && x == 0 && myBoard[0][myBoard.length-1][0] == t)) 
        {
            return true;
        }
        
        //Middle of floor multiple floor wraps//
        else if (
	        		(z < myBoard.length-1 && x < myBoard.length-1 && y == 0 && myBoard[z+1][x+1][myBoard.length-1] == t) || 
	        		(z < myBoard.length-1 && x < myBoard.length-1 && y == myBoard.length-1 && myBoard[z+1][x+1][0] == t) || 
	        		(z < myBoard.length-1 && x > 0 && y == 0 && myBoard[z+1][x-1][myBoard.length-1] == t) || 
	        		(z < myBoard.length-1 && x > 0 && y == myBoard.length-1 && myBoard[z+1][x-1][0] == t) || 
	        		(z < myBoard.length-1 && x == myBoard.length-1 && y < myBoard.length-1 && myBoard[z+1][0][y+1] == t) || 
	        		(z < myBoard.length-1 && x == myBoard.length-1 && y > 0 && myBoard[z+1][0][y-1] == t) || 
	        		(z < myBoard.length-1 && x == myBoard.length-1 && y == myBoard.length-1 && myBoard[z+1][0][0] == t) ||
	        		(z < myBoard.length-1 && x == myBoard.length-1 && y == 0 && myBoard[z+1][0][myBoard.length-1] == t) || 
	        		(z < myBoard.length-1 && x == 0 && y < myBoard.length-1 && myBoard[z+1][myBoard.length-1][y+1] == t) || 
	        		(z < myBoard.length-1 && x == 0 && y > 0 && myBoard[z+1][myBoard.length-1][y-1] == t) ||
	        		(z < myBoard.length-1 && x == 0 && y == myBoard.length-1 && myBoard[z+1][myBoard.length-1][0] == t) || 
	        		(z < myBoard.length-1 && x == 0 && y == 0 && myBoard[z+1][myBoard.length-1][myBoard.length-1] == t)
        		)
        {
        	return true;
        }
        
        else if (
	        		(z > 0 && x < myBoard.length-1 && y == myBoard.length-1 && myBoard[z-1][x+1][0] == t) || 
	        		(z > 0 && x < myBoard.length-1 && y == 0 && myBoard[z-1][x+1][myBoard.length-1] == t) || 
	        		(z > 0 && x > 0 && y == myBoard.length-1 && myBoard[z-1][x-1][0] == t) || 
	        		(z > 0 && x > 0 && y == 0 && myBoard[z-1][x-1][myBoard.length-1] == t) || 
	        		(z > 0 && x == myBoard.length-1 && y < myBoard.length-1 && myBoard[z-1][0][y+1] == t) || 
	        		(z > 0 && x == myBoard.length-1 && y > 0 && myBoard[z-1][0][y-1] == t) || 
	        		(z > 0 && x == myBoard.length-1 && y == myBoard.length-1 && myBoard[z-1][0][0] == t) || 
	        		(z > 0 && x == myBoard.length-1 && y == 0 && myBoard[z-1][0][myBoard.length-1] == t) || 
	        		(z > 0 && x == 0 && y < myBoard.length-1 && myBoard[z-1][myBoard.length-1][y+1] == t) || 
	        		(z > 0 && x == 0 && y > 0 && myBoard[z-1][myBoard.length-1][y-1] == t) || 
	        		(z > 0 && x == 0 && y == myBoard.length-1 && myBoard[z-1][myBoard.length-1][0] == t) || 
	        		(z > 0 && x == 0 && y == 0 && myBoard[z-1][myBoard.length-1][myBoard.length-1] == t)
        		)
        {
        	return true;
        }
        else if (
	        		(z == 0 && x < myBoard.length-1 && y < myBoard.length-1 && myBoard[myBoard.length-1][x+1][y+1] == t) ||
	        		(z == 0 && x < myBoard.length-1 && y > 0 && myBoard[myBoard.length-1][x+1][y-1] == t) ||
	        		(z == 0 && x < myBoard.length-1 && y == myBoard.length-1 && myBoard[myBoard.length-1][x+1][0] == t) ||
	        		(z == 0 && x < myBoard.length-1 && y == 0 && myBoard[myBoard.length-1][x+1][myBoard.length-1] == t) ||
	        		(z == 0 && x > 0 && y < myBoard.length-1 && myBoard[myBoard.length-1][x-1][y+1] == t) ||
	        		(z == 0 && x > 0 && y > 0 && myBoard[myBoard.length-1][x-1][y-1] == t) ||
	        		(z == 0 && x > 0 && y == myBoard.length-1 && myBoard[myBoard.length-1][x-1][0] == t) ||
	        		(z == 0 && x > 0 && y == 0 && myBoard[myBoard.length-1][x-1][myBoard.length-1] == t) ||
	        		(z == 0 && x == myBoard.length-1 && y < myBoard.length-1 && myBoard[myBoard.length-1][0][y+1] == t) ||
	        		(z == 0 && x == myBoard.length-1 && y > 0 && myBoard[myBoard.length-1][0][y-1] == t) ||
	        		(z == 0 && x == 0 && y < myBoard.length-1 && myBoard[myBoard.length-1][myBoard.length-1][y+1] == t) ||
	        		(z == 0 && x == 0 && y > 0 && myBoard[myBoard.length-1][myBoard.length-1][y-1] == t)
        		)
        {
        	return true;
        }
        else if (
	        		(z == myBoard.length-1 && x < myBoard.length-1 && y < myBoard.length-1 && myBoard[0][x+1][y+1] == t) ||
	        		(z == myBoard.length-1 && x < myBoard.length-1 && y > 0 && myBoard[0][x+1][y-1] == t) ||
	        		(z == myBoard.length-1 && x < myBoard.length-1 && y == myBoard.length-1 && myBoard[0][x+1][0] == t) ||
	        		(z == myBoard.length-1 && x < myBoard.length-1 && y == 0 && myBoard[0][x+1][myBoard.length-1] == t) ||
	        		(z == myBoard.length-1 && x > 0 && y < myBoard.length-1 && myBoard[0][x-1][y+1] == t) ||
	        		(z == myBoard.length-1 && x > 0 && y > 0 && myBoard[0][x-1][y-1] == t) ||
	        		(z == myBoard.length-1 && x > 0 && y == myBoard.length-1 && myBoard[0][x-1][0] == t) ||
	        		(z == myBoard.length-1 && x > 0 && y == 0 && myBoard[0][x-1][myBoard.length-1] == t) ||
	        		(z == myBoard.length-1 && x == myBoard.length-1 && y < myBoard.length-1 && myBoard[0][0][y+1] == t) ||
	        		(z == myBoard.length-1 && x == myBoard.length-1 && y > 0 && myBoard[0][0][y-1] == t) ||
	        		(z == myBoard.length-1 && x == 0 && y < myBoard.length-1 && myBoard[0][myBoard.length-1][y+1] == t) ||
	        		(z == myBoard.length-1 && x == 0 && y > 0 && myBoard[0][myBoard.length-1][y-1] == t)
        		)
        {
        	return true;
        }
        else
        {
            return false;
        }
    }
    
    //Use to check for win conditions//
	public void check(int[][][]myBoard, int z, int x, int y, int t)
	{
		boolean found = false;
		while (!found)
		{
			int tempX = x;
			int tempY = y;
			int tempZ = z;
	
			// Looks left and right
			if (look(myBoard, z, x, y+1, t) == true || look(myBoard, z, x, y-1, t) == true || wrap(myBoard, z, x, y, t) == true) 
			{
				winCounter = 1;
				if (look(myBoard, z, x, 0, t) == true && y == myBoard.length-1 && winCounter < 5)
				{
				    y = 0;
				    winCounter++;
				}
				while (look(myBoard, z, x, y+1, t) == true && winCounter < 5)
				{
					winCounter++;
					y++;
					if (look(myBoard, z, x, 0, t) == true && y == myBoard.length-1 && winCounter < 5)
					{
					    y = 0;
					    winCounter++;
					}
				}
				
				x = tempX;
				y = tempY;
				z = tempZ;
				
				if (look(myBoard, z, x, myBoard.length-1, t) == true && y == 0 && winCounter < 5)
				{
				    y = myBoard.length-1;
				    winCounter++;
				}
				while (look(myBoard, z, x, y - 1, t) == true && winCounter < 5) 
				{
					winCounter++;
					y--;
					if (look(myBoard, z, x, myBoard.length-1, t) == true && y == 0 && winCounter < 5)
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
	    		
			// Looks up and down rows
			if (look(myBoard, z, x+1, y, t) == true || look(myBoard, z, x-1, y, t) == true || wrap(myBoard, z, x, y, t) == true) 
			{
				winCounter = 1;
				if (look(myBoard, z, 0, y, t) == true && x == myBoard.length-1 && winCounter < 5)
				{
				    x = 0;
				    winCounter++;
				}
				while (look(myBoard, z, x+1, y, t) == true && winCounter < 5)
				{
					winCounter++;
					x++;
					if (look(myBoard, z, 0, y, t) == true && x == myBoard.length-1 && winCounter < 5)
					{
					    x = 0;
					    winCounter++;
					}
				}
				
				x = tempX;
				y = tempY;
				z = tempZ;
				
				if (look(myBoard, z, myBoard.length-1, y, t) == true && x == 0 && winCounter < 5)
				{
				    x = myBoard.length-1;
				    winCounter++;
				}
				while (look(myBoard, z, x-1, y, t) == true && winCounter < 5)
				{
					winCounter++;
					x--;
					if (look(myBoard, z, myBoard.length-1, y, t) == true && x == 0 && winCounter < 5)
					{
					    x = myBoard.length-1;
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
			
			// Looks vertical over floors
			if (look(myBoard, z+1, x, y, t) == true || look(myBoard, z-1, x, y, t) == true || wrap(myBoard, z, x, y, t) == true) 
			{
				winCounter = 1;
				if (look(myBoard, 0, x, y, t) == true && z == myBoard.length-1 && winCounter < 5)
				{
					z = 0;
					winCounter++;
				}
				while (look(myBoard, z+1, x, y, t) == true && winCounter < 5)
				{
					winCounter++;
					z++;
					if (look(myBoard, 0, x, y, t) == true && z == myBoard.length-1 && winCounter < 5)
	    			{
	    				z = 0;
	    				winCounter++;
	    			}
				}
				
				x = tempX;
				y = tempY;
				z = tempZ;
				
				if (look(myBoard,myBoard.length-1, x, y ,t) == true && z == 0 && winCounter < 5)
				{
					z = myBoard.length-1;
					winCounter++;
				}
				while (look(myBoard, z-1, x, y, t) == true && winCounter < 5) 
				{
					winCounter++;
					z--;
					if (look(myBoard,myBoard.length-1, x, y ,t) == true && z == 0 && winCounter < 5)
	    			{
	    				z = myBoard.length-1;
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
	
			//Looks diagonal over one floor
			if (look(myBoard, z, x+1, y+1, t) == true || look(myBoard, z, x-1, y-1, t) == true || wrap(myBoard, z, x, y, t) == true) 
	    	{
				winCounter = 1;
				while ((look(myBoard, z, x+1, y+1, t) == true || wrap(myBoard, z, x, y, t) == true) && winCounter < 5)
				{
					if (look(myBoard, z, x+1, y+1, t) == true)
					{
						winCounter++;
						x++;
						y++;
					}
					else if (x == myBoard.length-1 && y == myBoard.length-1)
					{
						x = 0;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (x == myBoard.length-1)
					{
					    x = 0;
					    y++;
					    if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (y == myBoard.length-1)
					{
						x++;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else 
					{
						break;
					}
				}
				
				x = tempX;
				y = tempY;
				z = tempZ;
				
				while ((look(myBoard, z, x-1, y-1, t) == true || wrap(myBoard, z, x, y, t) == true) && winCounter < 5) 
				{
					if(look(myBoard, z, x-1, y-1, t) == true)
					{
						winCounter++;
						x--;
						y--;
					}
					else if (x == 0 && y == 0)
					{
						x = myBoard.length-1;
	    				y = myBoard.length-1;
					    if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (x == 0)
					{
						x = myBoard.length-1;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (y == 0)
					{
						x--;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else 
					{
						break;
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
			
			//Looks other diagonal one floor
			if (look(myBoard, z, x+1, y-1, t) == true || look(myBoard, z, x-1, y+1, t) == true || wrap(myBoard, z, x, y, t) == true) 
			{
				winCounter = 1;
				while((look(myBoard, z, x+1, y-1, t) == true || wrap(myBoard, z, x, y, t) == true) && winCounter < 5)
				{
					if (look(myBoard, z, x+1, y-1, t) == true)
					{
						x++;
						y--;
						winCounter++;
					}
					else if (x == myBoard.length-1 && y == 0)
					{
						x = 0;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (x == myBoard.length-1)
					{
						x = 0;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (y == 0)
					{
						x--;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else 
					{
						break;
					}
				}
	        
		        x = tempX;
				y = tempY;
				z = tempZ;
				
		        while ((look(myBoard, z, x-1, y+1, t) == true || wrap(myBoard, z, x, y, t) == true) && winCounter < 5) 
				{
	    			if(look(myBoard, z, x-1, y+1, t) == true)
	    			{
	    				winCounter++;
	    				x--;
	    				y++;
	    			}
					else if (x == 0 &&  y == myBoard.length-1)
					{
	    				x = myBoard.length-1; 
	    				y = 0;
					    if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if ( x == 0)
					{
						x = 0;
						y++;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if ( y == myBoard.length-1)
					{
						x--;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else 
					{
						break;
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
			
			//Looks multiple floor diagonal
			if (look(myBoard, z+1, x+1, y+1, t) == true || look(myBoard, z-1, x-1, y-1, t) == true || wrap(myBoard, z, x, y, t) == true) 
			{
				winCounter = 1;
				while ((look(myBoard, z+1, x+1, y+1, t) == true || wrap(myBoard, z, x, y, t) == true) && winCounter < 5)
				{
					if(look(myBoard, z+1, x+1, y+1, t) == true)
					{
						winCounter++;
						z++;
						x++;
						y++;
					}
					else if (z == myBoard.length-1 && x == myBoard.length-1 && y == myBoard.length-1)
	    			{
	    				z = 0;
	    				x = 0;
	    				y = 0;
	    				if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
	    			}
	    			else if (z == myBoard.length-1 && x == myBoard.length-1)
	    			{
	    				z = 0;
	    				x = 0;
	    				y++;
	    				if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
	    			}
	    			
	    			else if (z == myBoard.length-1 && y == myBoard.length-1)
	    			{
	    				z = 0;
	    				x++;
	    				y = 0;
	    				if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
	    			}
	    			else if (x == myBoard.length-1 && y == myBoard.length-1)
	    			{
	    				z++;
	    				x = 0;
	    				y = 0;
	    				if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
	    			}
	    			else if (z == myBoard.length-1)
	    			{
	    				z = 0;
	    				x++;
	    				y++;
	    				if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
	    			}
	    			else if (x == myBoard.length-1)
	    			{
	    				z++;
	    				x = 0;
	    				y++;
	    				if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
	    			}
	    			else if (y == myBoard.length-1)
					{
						z++;
						x++;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else
					{
						break;
					}
				}
				
	    		x = tempX;
				y = tempY;
				z = tempZ;
				
				while ((look(myBoard, z-1, x-1, y-1, t) == true || wrap(myBoard, z, x, y, t)) && winCounter < 5)
				{
	    			if (look(myBoard, z-1, x-1, y-1, t) == true)
	    			{
	    				winCounter++;
	    				z--;
	    				x--;
	    				y--;
	    			}
					else if (z == 0 && x == 0 && y == 0)
	    			{
	    				z = myBoard.length-1;
	    				x = myBoard.length-1;
	    				y = myBoard.length-1;
	    				if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (z == 0 && x == 0)
					{
						z = myBoard.length-1;
						x = myBoard.length-1;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (z == 0 && y == 0)
					{
						z = myBoard.length-1;
						x--;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (x == 0 && y == 0)
					{
						z--;
						x = myBoard.length-1;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (z == 0)
					{
						z = myBoard.length-1;
						x--;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (x == 0)
					{
						z--;
						x = myBoard.length-1;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (y == 0)
					{
						z--;
						x--;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else
					{
						break;
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
			
			//Looks other multiple floor diagonal
			if (look(myBoard, z+1, x-1, y-1, t) == true || look(myBoard, z-1, x+1, y+1, t) == true || wrap(myBoard, z, x, y, t) == true)  
			{ 
				winCounter = 1;
				while((look(myBoard, z+1, x-1, y-1, t) == true || wrap(myBoard, z, x, y, t) == true) && winCounter < 5)
				{
					if(look(myBoard, z+1, x-1, y-1, t) == true)
					{
						winCounter++;
						z++;
						x--;
						y--;
					}
					else if(z == myBoard.length-1 && x == 0 && y == 0)
					{
						z = 0;
						x = myBoard.length-1;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == myBoard.length-1 && x == 0)
					{
						z = 0;
						x = myBoard.length-1;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == myBoard.length-1 && y == 0)
					{
						z = 0;
						x--;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (x == 0 && y == 0)
					{
						z++;
						x = myBoard.length-1;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == myBoard.length-1)
					{
						z = 0;
						x--;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(x == 0)
					{
						z++;
						x = myBoard.length-1;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(y == 0)
					{
						z++;
						x--;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else 
					{
						break;
					}
				}
			
			
				x = tempX;
				y = tempY;
				z = tempZ;
				
				while((look(myBoard, z-1, x+1, y+1, t) == true || wrap(myBoard, z, x, y, t) == true) && winCounter < 5)
				{
					if(look(myBoard, z-1, x+1, y+1, t) == true)
					{
						z--;
						x++;
						y++;
						winCounter++;
					}
					else if(z == 0 && x == myBoard.length-1 && y == myBoard.length-1)
					{
						z = myBoard.length-1;
						x = 0;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == 0 && x == myBoard.length-1)
					{
						z = myBoard.length-1;
						x = 0;
						y++;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == 0 && y == myBoard.length-1)
					{
						z = myBoard.length-1;
						x++;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(x == myBoard.length-1 && y == myBoard.length-1)
					{
						z--;
						x = 0;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == 0)
					{
						z = myBoard.length-1;
						x++;
						y++;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(x == myBoard.length-1)
					{
						z--;
						x = 0;
						y++;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
						
					}
					else if(y == myBoard.length-1)
					{
						z--;
						x++;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
						
					}
					else 
					{
						break;
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
			
			//Looks other multiple floor diagonal
			if (look(myBoard, z+1, x-1, y+1, t) == true || look(myBoard, z-1, x+1, y-1, t) == true || wrap(myBoard, z, x, y, t) == true) 
			{
				winCounter = 1;
				while ((look(myBoard, z+1, x-1, y+1, t) == true || wrap(myBoard, z, x, y, t) == true) && winCounter < 5)
				{
					if(look(myBoard, z+1, x-1, y+1, t) == true)
					{
						z++;
						x--;
						y++;
						winCounter++;
					}
					else if(z == myBoard.length-1 && x == 0 && y == myBoard.length-1)
					{
						z = 0;
						x = myBoard.length-1;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == myBoard.length-1 && x == 0)
					{
						z = 0;
						x = myBoard.length-1;
						y++;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == myBoard.length-1 && y == myBoard.length-1)
					{
						z = 0;
						x--;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(x == 0 && y == myBoard.length-1)
					{
						z++;
						x--;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == myBoard.length-1)
					{
						z = 0;
						x--;
						y++;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(x == 0)
					{
						z++;
						x = myBoard.length-1;
						y++;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(y == myBoard.length-1)
					{
						z++;
						x--;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else
					{
						break;
					}
				}
				
				
				x = tempX;
				y = tempY;
				z = tempZ;
				
				while((look(myBoard, z-1, x+1, y-1, t) == true || wrap(myBoard, z, x, y, t) == true) && winCounter < 5)
				{
					if(look(myBoard, z-1, x+1, y-1, t) == true)
					{
						z--;
						x++;
						y--;
						winCounter++;
					}
					else if(z == 0 && x == myBoard.length-1 && y == 0)
					{
						z = myBoard.length-1;
						x = 0;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == 0 && x == myBoard.length-1)
					{
						z = myBoard.length-1;
						x = 0;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == 0 && y == 0)
					{
						z = myBoard.length-1;
						x++;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(x == myBoard.length-1 && y == 0)
					{
						z--;
						x = 0;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == 0)
					{
						z = myBoard.length-1;
						x++;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(x == myBoard.length-1)
					{
						z--;
						x = 0;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(y == 0)
					{
						z--;
						x++;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else
					{
						break;
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
			
			//Looks other multiple floor diagonal
			if (look(myBoard, z+1, x+1, y-1, t) == true || look(myBoard, z-1, x-1, y+1, t) == true || wrap(myBoard, z, x, y, t) == true) 
			{ 
				winCounter = 1;
				while ((look(myBoard, z+1, x+1, y-1, t) == true || wrap(myBoard, z, x, y, t) == true) && winCounter < 5)
				{
					if(look(myBoard, z+1, x+1, y-1, t) == true)
					{
	    				winCounter++;
	    				z++;
	    				x++;
	    				y--;
					}
					else if(z == myBoard.length-1 && x == myBoard.length-1 && y == 0)
	    			{
	    				z = 0;
	    				x = 0;
	    				y = myBoard.length-1;
	    				if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
	    			}
					else if (z == myBoard.length-1 && x == myBoard.length-1)
					{
						z = 0;
						x = 0;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (z == myBoard.length-1 && y == 0)
					{
						z = 0;
						x++;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (x == myBoard.length-1 && y == 0)
					{
						z++;
						x = 0;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (z == myBoard.length-1)
					{
						z = 0;
						x++;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (x == myBoard.length-1)
					{
						z++;
						x = 0;
						y--;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if (y == 0)
					{
						z++;
						x++;
						y = myBoard.length-1;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else 
					{
						break;
					}
				}
				
				x = tempX;
				y = tempY;
				z = tempZ;
				
				while ((look(myBoard, z-1, x-1, y+1, t) == true || wrap(myBoard, z, x, y, t) == true ) && winCounter < 5)
				{
					if(look(myBoard, z-1, x-1, y+1, t) == true)
					{
						winCounter++;
						z--;
						x--;
						y++;
					}
					else if(z == 0 && x == 0 && y == myBoard.length-1)
	    			{
	    				z = myBoard.length-1;
	    				x = myBoard.length-1;
	    				y = 0;
	    				if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
	    			}
					else if(z == 0 && x == 0)
					{
						z = myBoard.length-1;
						x = myBoard.length -1;
						y++;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == 0 && y == myBoard.length-1)
					{
						z = myBoard.length-1;
						x--;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(x == 0 && y == myBoard.length-1)
					{
						z--;
						x = myBoard.length-1;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(z == 0)
					{
						z = myBoard.length-1;
						x--;
						y++;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(x == 0)
					{
						z--;
						x = myBoard.length-1;
						y++;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else if(y == myBoard.length-1)
					{
						z--;
						x--;
						y = 0;
						if(look(myBoard, z, x, y, t) == true)
						{
							winCounter++;
						}
						else
						{
							break;
						}
					}
					else
					{
						break;
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
			
			if (winCounter < 5)
			{
				System.out.println("Win counter: " + winCounter);
				found = true;
			}
		}
	}
}