package Tasks.Task2;
import java.util.*;

public class main_Task2 {
	
	public static Scanner sc = new Scanner (System.in);
    public static void main(String[]args){

    	
    	int numberOfPlayers;
    	do {
    		System.out.println("Introduce the number of players. Remember that must be more than 3");
    		numberOfPlayers=sc.nextInt();
    	} while (numberOfPlayers <3);
    	
    	Players [] players = createPlayers (numberOfPlayers);
    	int min = 0;
    	int max = players.length-1;
    	
    	listOfPlayers(players);
    	
    	
    	int impostor1 = objective1(players,min, max);
    	System.out.println("The impostor is: "+impostor1);
    	
    	//min=1; max=players.length;
    	//quickSort (players, min, max);
    	
    	
    }
    
    public static void quickSort (Players [] players, int min, int max) {
    	if (min<max) {
    		int pos = Partition (players, min, max);
    		quickSort (players, min, pos);
    		quickSort (players, pos+1, max);
    	}
    }
    
    public static int Partition (Players [] players, int min, int max) {
    	int piv = players[min-1].getTaskPerformed();
    	int i = min-1;
    	int j=max+1;
    	do {
    		do {
    			j=j-1;
    		} while (players[j-1].getTaskPerformed()>piv && players[j].getExperienceLvl()!=players[j-1].getExperienceLvl());
    		 
    		do {
    			i=i+1;
    		} while (players[i-1].getTaskPerformed()<piv);
    		if (i<j) {
    			
    			int local1=players[i-1].getTaskPerformed();
    			int local2=players[i-1].getExperienceLvl();
    			int local3=players[i-1].getLvlAnger();
    			
    			players[i-1].setTaskPerformed(players[j-1].getTaskPerformed());
    			players[i-1].setExperienceLevel(players[j-1].getExperienceLvl());
    			players[i-1].setLvlAnger(players[j-1].getLvlAnger());
    			players[j-1].setTaskPerformed(local1);
    			players[j-1].setExperienceLevel(local2);
    			players[j-1].setLvlAnger(local3);
    			
    			listOfPlayers(players);
    		}
    	} while (i<j);

    	return j;
    }
    
    public static void listOfPlayers (Players [] players) {
    	for (int i=0; i<players.length;i++) {
    		System.out.println(i+" || "+players[i].toString());
    	}
    	System.out.println();
    }
    
    public static Players [] createPlayers (int nPlayers) {
    	Players [] Players = new Players [nPlayers];
    	
    	for (int i=0; i<Players.length;i++) {
    		int experience = (int)(Math.random()*(5-0+1)+0);
    		int taskPerformed = (int)(Math.random()*(8-0+1)+0);
    		int anger = 1; 
    		Players [i] = new Players (experience, taskPerformed, anger);
    	}
    	int impostor = (int)(Math.random()*((nPlayers-1)-0+1)+0);
    	Players[impostor].setLvlAnger(2);
    	Players[impostor].setTaskPerformed(0);
    	Players[impostor].setExperienceLevel(0);
    	return Players;
    }
    
    public static int objective1 (Players [] players, int min, int max) {
    	int impostor = -1;
    	//int rightWeight, leftWeight;
    	int middle = (max+min)/2;
    	
    	if (min==max) {
    		impostor = max;
    	}
    	else {
    		
    		if ((max-min)%2==0) { // EVEN VECTOR
    			int leftWeight = toSize(players,min,middle-1);
    			int rightWeight = toSize (players,middle+1,max);
    			if (leftWeight<rightWeight) {
    				impostor = objective1(players,middle+1,max);
    			} else if (rightWeight<leftWeight) {
    				impostor = objective1 (players,min,middle-1);	
    			} else {
    				impostor = middle;
    			}
    			
    		
    		} else { // ODD VECTOR			
    			int leftWeight = toSize(players,min,middle);
    			int rightWeight = toSize (players,middle+1,max);
    			if (leftWeight<rightWeight) {
    				impostor = objective1(players,middle+1,max);
    			} else {
    				impostor = objective1 (players,min,middle);		
    			}
    			
    		}
    	}
    	return impostor;
    }
    
    public static int toSize (Players [] players, int min, int max) {
    	int size=0;
    	
    	
    	/*if (max == players.length) {
    		for (int i=min; i<max; i++) {
        		size += players[i].getLvlAnger();
        	}
    	} else {*/
    	for (int i=min; i<=max; i++) {
    		size += players[i].getLvlAnger();
    	}
    	//}
    	return size;
    }
    
}
