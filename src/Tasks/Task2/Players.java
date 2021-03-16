package Tasks.Task2;

public class Players {
	
	protected int playerID;
	protected int experience;
	protected int taskPerformed;
	protected int anger;
	
	public Players (int nPlayerID, int LvlExperience, int nTaskPerformed, int LvlAnger) {
		this.experience = LvlExperience;
		this.taskPerformed= nTaskPerformed;
		this.anger = LvlAnger;
		this.playerID=nPlayerID;
	}

	public int getExperienceLvl () {
		return experience;
	}
	
	public int getTaskPerformed () {
		return taskPerformed;
	}
	
	public int getLvlAnger () {
		return anger;
	}
	
	public void setLvlAnger(int anger) {
		this.anger=anger;
	}
	
	public void setExperienceLevel (int experience) {
		this.experience = experience;
	}
	
	public void setTaskPerformed (int taskPerformed) {
		this.taskPerformed=taskPerformed;
	}
	
	public String toString () {
		return "ID: ["+playerID+"] | Level of experience: "+experience+" | Task Performed: "+taskPerformed+" | Level of Anger: "+anger;
	}
	
	public int getPlayerID() {
		return playerID;
	}
	
	public void setPlayerID (int playerID) {
		this.playerID=playerID;
	}
	
	
}
