package at.ac.tuwien.big.we14.lab2.api;

public interface Player {
	
	public String getName();
	public void setName(String name);
	public int getWonRounds();
	public void setWonRounds(int wonRounds);
	public int getRightQuestions();
	public void incrementRightQuestions();
	public void resetRightQuestions();
}
