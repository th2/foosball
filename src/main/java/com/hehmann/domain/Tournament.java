package com.hehmann.domain;

public class Tournament {
	private int id;
	private String name;
	private TournamentStatus status;

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TournamentStatus getStatus() {
		return status;
	}
	public void setStatus(TournamentStatus status) {
		this.status = status;
	}

	public Tournament(int id, String name){
		this.id = id;
		this.name = name;
		this.status = TournamentStatus.PREPARATION;
	}
	
	@Override
	public boolean equals(Object other) {
		if(!other.getClass().equals(this.getClass()))
			return false;
		return this.getName().equals(((Tournament)other).getName());
	}
}
