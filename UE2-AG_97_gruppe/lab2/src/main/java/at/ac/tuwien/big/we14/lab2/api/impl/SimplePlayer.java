package at.ac.tuwien.big.we14.lab2.api.impl;

import at.ac.tuwien.big.we14.lab2.api.Player;

public class SimplePlayer implements Player {
	
	private String name;
	private int wonRounds=0;
	private int rightQuestions=0;
	
	public SimplePlayer(){
		this.name="";
	}
	
	public SimplePlayer(String name){
		this.name = name;

	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWonRounds(){
		return wonRounds;
	}
	
	public void setWonRounds(int wonRounds){
		this.wonRounds=wonRounds;
	}

	@Override
	public int getRightQuestions() {
		return rightQuestions;
	}

	@Override
	public void incrementRightQuestions() {
		rightQuestions++;
		
	}

	@Override
	public void resetRightQuestions() {
		rightQuestions=0;		
	}

}
