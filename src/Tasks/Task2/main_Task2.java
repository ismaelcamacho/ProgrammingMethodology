package Tasks.Task2;
import java.util.*;

public class main_Task2 {
	
	public static Scanner sc = new Scanner (System.in);
    public static void main(String[]args){

    	
    	int numberOfPlayers;
    	do {
    		System.out.println("Introduce the number of players. Remember that must be more than 3");
    		numberOfPlayers=sc.nextInt();
    	} while (numberOfPlayers <=3);
    	
    	Players [] players = createPlayers (numberOfPlayers);
    }
    
    public static Players [] createPlayers (int nPlayers) {
    	Players [] Players = new Players [nPlayers];
    	
    	for (int i=0; i<Players.length;i++) {
    		int experience = (int)(Math.random()*(5-0+1)+0);
    		int taskPerformed = (int)(Math.random()*(8-0+1)+0);
    		int anger = 1; 
    		Players [i] = new Players (experience, taskPerformed, anger);
    	}
    	
    	Players[(int)(Math.random()*(nPlayers-0+1)+0)].setLvlAnger(2);
    	return Players;
    }
}
