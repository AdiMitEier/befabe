package at.ac.tuwien.big.we14.lab2.api.impl;

import at.ac.tuwien.big.we14.lab2.api.Player;

public class SimplePlayer implements Player {
	
	
	private String name;
	private int wonRounds=0;
	private int rightQuestions=0;
	
	private RoundState round1 = RoundState.UNKNOWN;
	private RoundState round2 = RoundState.UNKNOWN;
	private RoundState round3 = RoundState.UNKNOWN;
	
	private int answerTime = 0;
	
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
		round1 = RoundState.UNKNOWN;
		round2 = RoundState.UNKNOWN;
		round3 = RoundState.UNKNOWN;	
	}

	public void setAnswerTime(int answerTime){
		this.answerTime = answerTime;
	}
	
	public int getAnswerTime(){
		return answerTime;
	}
	
	public void setRound1(RoundState round1){
		this.round1 = round1;
	}
	
	public RoundState getRound1State(){
		return round1;
	}
	
	public void setRound2(RoundState round2){
		this.round2 = round2;
	}
	
	public RoundState getRound2State(){
		return round2;
	}
	
	public void setRound3(RoundState round3){
		this.round3 = round3;
	}
	
	public RoundState getRound3State(){
		return round3;
	}
	
	public void setState(int round, RoundState state){
		if(round == 1)
			this.round1 = state;
		if(round == 2)
			this.round2 = state;
		if(round == 3)
			this.round3 = state;
		
	}
	
	public RoundState getState(int round){
		if(round == 1)
			return this.round1;
		if(round == 2)
			return this.round2;
		if(round == 3)
			return this.round3;
		return RoundState.UNKNOWN;
	}
	
	public String roundStates(){
		String s =  "Round 1: " + round1.toString();
		s += "\nRound 2: " + round2.toString();
		s += "\nRound 3: " + round3.toString();
		
		return s;
	}
	
}
