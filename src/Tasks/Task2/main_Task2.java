package Tasks.Task2;
import java.util.*;
import java.io.*;

public class main_Task2 {
	
	/***************************************************************************************************************************
	*
	* Class Name: main Task 2
	* Author/s name: Ismael Camacho Talavera and Andrés Castellanos Cantos
	* Release/Creation date: 10/3/2021
	* Class version: 
	* Class description: this class is the main of the program, where is developed both objetives requested.
	*
	****************************************************************************************************************************
	*/
	
	public static Scanner sc = new Scanner (System.in);
    public static void main(String[]args) throws IOException {
   	
    	try {								
    		// THIS TRY-CATCH IS CHECKING THAT THE VALUE FOR KNOWING THE NUMBERS OF PLAYERS NOT BE DIFFERENT OF AN INTEGER
    		int numberOfPlayers;			// NUMBERS OF PLAYERS OF THIS GAME
    		
    		do {
    			System.out.println("Introduce the number of players. Remember that must be more than 3");
    			numberOfPlayers=sc.nextInt();
    		} while (numberOfPlayers <3);	
    		
    		Players [] players = createPlayers (numberOfPlayers);
        	int min = 0;						// VARIABLE THAT ESTABLISH THE MINIMUN LIMIT OF THE OBJECT PLAYERS (REFERING TO POSITIONS)
        	int max = players.length-1;			// VARIABLE THAT ESTABLISH THE MAXIMUM LIMIT OF THE OBJECT PLAYERS (REFERING TO POSITIONS)
        	
        	listOfPlayers(players);	
        	
        	long startTime = System.nanoTime();		// MEASURING THE TIME NEEDED FOR SEARCHING THE IMPOSTOR
        	   
        	/* HERE WE CALL TO THE PROCEDURE OF THE FIRST OBJECTIVE*/
        	int impostor = objective1(players,min, max);
        	System.out.println("The impostor is the user which ID is: "+impostor);
        	 
        	
        	/* HERE WE CALL TO THE PROCEDURE OF THE SECOND OBJECTIVE*/
        	
        	//objective2(players,impostor);
        	
        	quickSort (players, min, max);
        	comparision (players);
            
            System.out.print("Time in milliseconds to find the impostor is = ");
            System.out.println(System.nanoTime()-startTime + "ns");
        	
        	
    	} catch (Exception e) {
			System.out.println("Error. Introduce an Integer");
			sc.next();
			main(args);
		}
	
    }
    
    /*********************************************************************
    *
    * Method name: createPlayers
    *
    * Description of the Method: we create an array of object Players, 
    * asigning the attributes of the object. The number of objects created 
    * will depend on the numbers of players introduced by the user on the Keyboard.
    *
    * Calling arguments: 
	* 		- int nPlayers, that refers to the number of players.
    *
    * Return value: an array of objects
    *
    *********************************************************************/
    
    public static Players [] createPlayers (int nPlayers) {
    	Players [] Players = new Players [nPlayers];									// CREATE AN ARRAY OF OBJECTS WITH LENGTH nPlayers
    	
    	for (int i=0; i<Players.length;i++) {											// GOING THROUGH THE ARRAY
    		int playerID = i;															// ID FOR IDENTIFING THEN THE PLAYER
    		int experience = (int)(Math.random()*(5-0+1)+0);							// LEVEL OF EXPERIENCE GENERATED RANDOMLY
    		int taskPerformed = (int)(Math.random()*(8-0+1)+0);							// NUMBER OF TASKED PERFORMED GENERATED RANDOMLY
    		int anger = 1; 																// FIRST ALL PLAYERS WILL BE AN CREW MEMBER.
    		Players [i] = new Players (playerID, experience, taskPerformed, anger);		// CREATE AN OBJECT PLAYER IN THE POSITION INDICATED.

    	}
    	int impostor = (int)(Math.random()*((nPlayers-1)-0+1)+0);						// WE GET THE IMPOSTOR GENERATED RANDOMLY AN DEPENDING ON THE NUMBER OF PLAYERS
    	Players[impostor].setLvlAnger(2);												// ONCE WE HAVE THE IMPOSTOR, WE UPDATE HIS ANGER LEVEL, THAT MUST BE 2
    	return Players;
    }
    
    /*********************************************************************
    *
    * Method name: listOfPlayers
    *
    * Description of the Method: it shows the elements of the array of
    * objects Players.
    *
    * Calling arguments: 
	* 		- An array of objects Players []
    *
    * Return value: void
    *
    *********************************************************************/
    
    public static void listOfPlayers (Players [] players) {
    	for (int i=0; i<players.length;i++) {
    		System.out.println(players[i].toString());
    	}
    	System.out.println();
    }
    
    /*********************************************************************
     * ----------------------METHODS 1st OBJECTIVE------------------------
     *********************************************************************/
    
    /*********************************************************************
    *
    * Method name: objective1
    *
    * Description of the Method: for this objective we apply the Binary Search,
    * so we divide in two parts the array players and we get the size of each part,
    * and we do this procedure until both limits be the same.
    * 
    *
    * Calling arguments: 
	* 		- int nPlayers, that refers to the number of players.
	* 		- int min, the minimum limit of the array.
	* 		- int max, the maximum limit of the array.
    *
    * Return value: position of the impostor (int).
    *
    *********************************************************************/
    
    public static int objective1 (Players [] players, int min, int max) {
    	int impostor = -1;
    	int middle = (max+min)/2;												// GET THE MIDDLE OF THE ARRAY
    	
    	if (min==max) { 														// CHECKS IF BOTH LIMITS ARE THE SAME
    		impostor = max;
    	}
    	else {
    		
    		if ((max-min)%2==0) { // EVEN VECTOR								
    			int leftWeight = toSize(players,min,middle-1);					// CALCULATE THE WEIGHT OF THE LEFT SIDE 
    			int rightWeight = toSize (players,middle+1,max);				// CALCULATE THE WEIGHT OF THE RIGHT SIDE
    			if (leftWeight<rightWeight) {
    				impostor = objective1(players,middle+1,max);				// WITH THE NEW LIMITS, WE MAKE RECURSIVITY
    			} else if (rightWeight<leftWeight) {
    				impostor = objective1 (players,min,middle-1);				// WITH THE NEW LIMITS, WE MAKE RECURSIVITY
    			} else {
    				impostor = middle;
    			}
    		} else { // ODD VECTOR			
    			int leftWeight = toSize(players,min,middle);					// CALCULATE THE WEIGHT OF THE LEFT SIDE 
    			int rightWeight = toSize (players,middle+1,max);				// CALCULATE THE WEIGHT OF THE RIGHT SIDE 
    			if (leftWeight<rightWeight) {
    				impostor = objective1(players,middle+1,max);				// WITH THE NEW LIMITS, WE MAKE RECURSIVITY
    			} else {
    				impostor = objective1 (players,min,middle);					// WITH THE NEW LIMITS, WE MAKE RECURSIVITY
    			}	
    		}
    	}
    	return impostor;
    }
    
    /*********************************************************************
    *
    * Method name: toSize
    *
    * Description of the Method: simple method that calculate the size in a
    * range of positions given in the array. 
    * 
    *
    * Calling arguments: 
	* 		- int nPlayers, that refers to the number of players.
	* 		- int min, the minimum limit of the array.
	* 		- int max, the maximum limit of the array.
    *
    * Return value: size of the side.
    *
    *********************************************************************/
    
    public static int toSize (Players [] players, int min, int max) {
    	int size=0;
    	for (int i=min; i<=max; i++) {
    		size += players[i].getLvlAnger();				// WE GET THE ANGER LEVEL OF THE SELECTED OBJECT
    	}
    	return size;
    }
    
    /*********************************************************************
     * ----------------------METHODS 2nd OBJECTIVE------------------------*
     *********************************************************************/
    
    /*********************************************************************
    *
    * Method name: quicksort1
    *
    * Description of the Method: we apply the quicksort method, establishing
    * a pivot an ordering the array depending on the task performed. 
    * 
    * Calling arguments: 
	* 		- int nPlayers, that refers to the number of players.
	* 		- int min, the minimum limit of the array.
	* 		- int max, the maximum limit of the array.
    *
    * Return value: nothing, void method.
    *
    *********************************************************************/
    
    public static void quickSort (Players [] players, int min, int max) {
    	if (min<max) {									
    		int pos = Partition (players, min, max);
    		quickSort (players, min, pos);
    		quickSort (players, pos+1, max);
    	}
    }
    
    /*********************************************************************
    *
    * Method name: Partition
    *
    * Description of the Method: we apply the quicksort method, establishing
    * a pivot an ordering the array depending on the task performed. 
    * 
    * 	We use the partitioning method, choosing a pivot (in our case will
    * be the first element), and then we will be ordering the array depending
    * on the task performed, being at the left the users with  less task
    * performed and at the right the users with more task performed (always 
    * having the pivot as a reference)
    * 
    * Calling arguments: 
	* 		- int nPlayers, that refers to the number of players.
	* 		- int min, the minimum limit of the array.
	* 		- int max, the maximum limit of the array.
    *
    * Return value: nothing, void method.
    *
    *********************************************************************/
    
    public static int Partition (Players [] players, int min, int max) {
    	int piv = players[min].getTaskPerformed();								
    	int i = min-1;
    	int j=max+1;
    	do {
    		do {
    			j=j-1;
    		} while (players[j].getTaskPerformed()>piv);
    		 
    		do {
    			i=i+1;
    		} while (players[i].getTaskPerformed()<piv);
    		if (i<j) {
    			
    			replace(players,i,j);
    			
    		}
    	} while (i<j);

    	return j;
    }
    
    /*********************************************************************
    *
    * Method name: replace
    *
    * Description of the Method: simple method that interchange the attributes
    * of the object i with the object i+1 
    * 
    * Calling arguments: 
	* 		- Array of Objects, Players [] players.
	* 		- int i, object i
	* 		- int j, object i+1
    *
    * Return value: nothing, void method.
    *
    *********************************************************************/
    
    public static void replace (Players[] players, int i, int j) {
    	int local1 = players[i].getTaskPerformed();
		int local2 = players[i].getExperienceLvl();
		int local3 = players[i].getLvlAnger();
		int local4 = players[i].getPlayerID();
		
		players[i].setTaskPerformed(players[j].getTaskPerformed());
		players[i].setExperienceLevel(players[j].getExperienceLvl());
		players[i].setLvlAnger(players[j].getLvlAnger());
		players[i].setPlayerID(players[j].getPlayerID());
		players[j].setTaskPerformed(local1);
		players[j].setExperienceLevel(local2);
		players[j].setLvlAnger(local3);
		players[j].setPlayerID(local4);
    }
    
    /*********************************************************************
    *
    * Method name: comparision
    *
    * Description of the Method: this method is used once the array is ordered
    * depending on the task performed. Once its done, it go through the array
    * and checks if there are users with the same number of task performed, so
    * then it order depending on the experience level. 
    * 
    * Calling arguments: 
	* 		- Array of Objects, Players [] players.
    * Return value: nothing, void method.
    *
    *********************************************************************/
    
    public static void comparision (Players [] players) {
    	
    	for (int i=0; i<players.length-1; i++) {
    		if (players[i].getTaskPerformed()==players[i+1].getTaskPerformed()) {
        		if (players[i].getExperienceLvl()>players[i+1].getExperienceLvl()) {
    				replace (players, i, i+1);		
    			} else if (players[i].getExperienceLvl()==players[i+1].getExperienceLvl() && players[i+1].getLvlAnger()==2) {    					
    				replace (players, i, i+1);		
    			}
        	}
    	} 	
    	if (players[players.length-1].getLvlAnger()==1) {
    		System.out.println("The winner is the user:");
    		System.out.println(players[players.length-1].toString()); 		
    	} else {
    		System.out.println("The winner is the impostor");
    		System.out.println(players[players.length-1].toString());
    	}	
    }
    
    /*********************************************************************
    *
    * Method name: objective2
    *
    * Description of the Method: checks if the impostor is in the last
    * position of the vector or not.
    * 
    * Calling arguments: 
	* 		- Array of Objects, Players [] players.
	* 		- int i, refering to the position of the impostor
    *
    * Return value: nothing, void method.
    *
    *********************************************************************/
    
    public static void objective2(Players[] players, int i) {
    	if (i==players.length-1) {
    		compare (players,i,0);
    	} else {
    		compare(players,i,i+1);
    	}	
    }
    
    /*********************************************************************
    *
    * Method name: compare
    *
    * Description of the Method: checks if the impostor has more task performed
    * or not than the next user.
    * 
    * Calling arguments: 
	* 		- Array of Objects, Players [] players.
	* 		- int i, refering to the position of the impostor
    *
    * Return value: nothing, void method.
    *
    *********************************************************************/
    
    public static void compare (Players [] players, int i, int j) {
    	if (players[i].getTaskPerformed()>players[j].getTaskPerformed()) {
    		System.out.println("The impostor has won");
    	} else if (players[i].getTaskPerformed()<players[j].getTaskPerformed()) {
    		System.out.println("Crew have won");
    	} else {
    		if (players[i].getExperienceLvl()>players[j].getExperienceLvl()) {
    			System.out.println("The impostor has won");	
			} else if (players[i].getExperienceLvl()<players[j].getExperienceLvl()) {
				System.out.println("Crew have won");
			}
    		else {
    			System.out.println("Crew have won");
    	}
    	
    }
    }
   
    
    
  
    
    
    
    
 
    
}
