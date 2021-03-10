package Tasks.Task2;

public class Players {
	
	protected int experience;
	protected int taskPerformed;
	protected int anger;
	
	public Players (int LvlExperience, int nTaskPerformed, int LvlAnger) {
		this.experience = LvlExperience;
		this.taskPerformed= nTaskPerformed;
		this.anger = LvlAnger;
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
		return "Level of experience: "+experience+" | Task Performed: "+taskPerformed+" | Level of Anger: "+anger;
	}
	
	
}
