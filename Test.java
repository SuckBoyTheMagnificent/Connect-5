import java.util.*;
import java.io.*;
/**
 * Created by claire on 9/30/16.
 */
public class Test
{
    public static void main(String args[]) throws IOException
    {
    	int x = 0;
    	int y = 0;
   		int z = 0;  		
        int numHumans;
        int numAI;
        int boardSize;
        int turns = 0;
        int AIturns = 0; 
        Human myHumans;
   		AI myAI;
        LookingClass myLooker = new LookingClass(0);
        int[][][] board;
        boolean done = false;
        Scanner myScanner = new Scanner(System.in);
        	
            //Board Creation, human and AI player creation
        	do
        	{
	            System.out.println("Enter a number between 5 and 10 (inclusive): ");
	            boardSize = Integer.parseInt(myScanner.nextLine());
	            board = new int[boardSize][boardSize][boardSize];
	            System.out.println("Maximum total number of players is 5.");
	            System.out.println("Enter number of human players: ");
	            numHumans = Integer.parseInt(myScanner.nextLine());
	            myHumans = new Human(numHumans);
	            System.out.println("Enter number of AI: ");
	            numAI = Integer.parseInt(myScanner.nextLine());
	            myAI = new AI(numAI);
	            if (boardSize<5 || boardSize>10 || numHumans + numAI > 5)
	            {
	            	System.out.println("At least one of your entries was invalid, please check the rules and try again.\n");
	            }
        	}while (boardSize<5 || boardSize>10 || numHumans + numAI > 5);
        	
            //Print initial board
            for (int floors = 0; floors < board.length; floors++)
            {
                for (int rows = 0; rows < board[floors].length; rows++)
                {
                    for (int columns = 0; columns < board[floors][rows].length; columns++)
                    {
                        System.out.print(board[floors][rows][columns]);
                        if (columns + 1 == board[floors][rows].length)
                        {
                            System.out.println(" ");
                        }
                    }
                    if (rows + 1 == board[floors].length)
                    {
                        System.out.println(" ");
                    }
                }
            }
            
            //Player Naming
            for (int i = 0; i < numHumans; i++)
            {
                System.out.println("Enter player " + (i + 1) + " name: ");
                myHumans.addHuman(myScanner.nextLine(), (i + 1));
                System.out.println(myHumans.getHumanName(i));
            }
            for (int i = 0; i < numAI; i++)
            {
            	int j = (i + 1 + numHumans);
                myAI.addAI("AI: " + j, j);
                System.out.println(myAI.getAIName(i));
            }
            //Make moves and check for wins
	        while (!done)
	        {
            	if (numHumans > 0) //Human turns
            	{
	            	do
	            	{
	            		try
	            		{
	            			boolean inBounds = false;
	            			while(!inBounds)
	            			{
				                System.out.println(myHumans.getHumanName(turns) + "'s turn.");
				                System.out.println("Select your desired move location: (X, Y)");
				                System.out.println("Enter your X coordinate: ");
				                x = Integer.parseInt(myScanner.nextLine()) -1;
				                System.out.println("Enter your Y coordinate: ");
				                y = Integer.parseInt(myScanner.nextLine()) -1;				                
				                if(x > boardSize || x < 0 || y > boardSize || y <0)
				                {
				                	System.out.println("At least one of your inputs was out of bounds.");
				                	inBounds = false;
				                }
				                else 
				                {
				                	inBounds = true;
				                }
	            			}
			                z = 0;
			                if (board[z][x][y] != 0)
			                {
			                	boolean finished = false;
			                	while (!finished && z < board.length && board[z][x][y] != 0)
			                	{
			                		z++;
			                		if (z < board.length && board[z][x][y] == 0)
			                		{
			                			board[z][x][y] = myHumans.getHumanNum(turns);
			                            finished = true;
			                		}
			                		else if (z == board.length)
			                		{
			                			System.out.println("Full");
			                		}      			
			                	} 
			                }
			                else
			                {
			                	board[z][x][y] = myHumans.getHumanNum(turns);
			                }
			            	
			                myLooker.check(board, z, x, y, myHumans.getHumanNum(turns)); //Check for win
			                
			                if (myLooker.win == true)
			                {
			                    done = true;
			                    System.out.println(myHumans.getHumanName(turns) + " won!");
			                    myScanner.close();
			                    
			                    //Print final board
			                    for (int floors = 0; floors < board.length; floors++)
			                    {
			                        for (int rows = 0; rows < board[floors].length; rows++)
			                        {
			                            for (int columns = 0; columns < board[floors][rows].length; columns++)
			                            {
			                                System.out.print(board[floors][rows][columns]);
			                                if (columns + 1 == board[floors][rows].length)
			                                {
			                                    System.out.println(" ");
			                                }
			                            }
			                            if (rows + 1 == board[floors].length)
			                            {
			                                System.out.println(" ");
			                            }
			                        }
			                    }
			                }
			                else //End of human turns
			                {
			                	turns++;
			                }
	            		}
	            		catch (NumberFormatException e)
	            		{
	            			System.out.println("Invalid Option.");
	            		}
	            	} while(turns != numHumans && !done);
            	}
            	
                if (numAI > 0 && !done) //AI turns
                {
                	boolean went = false;
                	while(AIturns < numAI && !went)
                	{
                		//myAI.place(board, z, x, y, AIturns); //Used to be place// FIXME
                		if (myAI.alphaBeta(board, z, x, y, AIturns) == false)
                		{
                			myAI.place(board, z, x, y, AIturns);
                		}
                		myLooker.check(board, z, x, y, myAI.getAINum(AIturns));
                		if(myLooker.win == true)
                		{
                			done = true;
                			went = true;
                			System.out.println(myAI.getAIName(AIturns) + " won!");
                			myScanner.close();
                			
                			//Print final board
                			for (int floors = 0; floors < board.length; floors++)
                            {
                                for (int rows = 0; rows < board[floors].length; rows++)
                                {
                                    for (int columns = 0; columns < board[floors][rows].length; columns++)
                                    {
                                        System.out.print(board[floors][rows][columns]);
                                        if (columns + 1 == board[floors][rows].length)
                                        {
                                            System.out.println(" ");
                                        }
                                    }
                                    if (rows + 1 == board[floors].length)
                                    {
                                        System.out.println(" ");
                                    }
                                }
                            } 
                		}
                		else //End of AI turns
                		{
                			AIturns++;
                		}
                	}
                }
                //System.out.println("AI prune Board begins!!!");
                //myAI.alphaBeta(board, z, x, y, myAI.getAINum(AIturns-1)); //FIXME
                //System.out.println("AI prune Board ends!!!");
                if ((turns + AIturns) == (numHumans + numAI)) //Reset turn counters for next full turn
                {
                    turns = 0;
                    AIturns = 0;
                }
                
                //Print Board After each full turn if there were no winners
                if (!done)
                {
	                for (int floors = 0; floors < board.length; floors++)
	                {
	                    for (int rows = 0; rows < board[floors].length; rows++)
	                    {
	                        for (int columns = 0; columns < board[floors][rows].length; columns++)
	                        {
	                            System.out.print(board[floors][rows][columns]);
	                            if (columns + 1 == board[floors][rows].length)
	                            {
	                                System.out.println(" ");
	                            }
	                        }
	                        if (rows + 1 == board[floors].length)
	                        {
	                            System.out.println(" ");
	                        }
	                    }
	                }
                }
	        }   
    }
}

