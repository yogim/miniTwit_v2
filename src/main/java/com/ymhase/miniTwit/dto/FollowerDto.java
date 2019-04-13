package com.ymhase.miniTwit.dto;

import javax.validation.constraints.NotNull;

public class FollowerDto {
	
	@NotNull
	private int who_id;
	
	@NotNull
	private int whom_id;

	public int getWho_id() {
		return who_id;
	}

	public void setWho_id(int who_id) {
		this.who_id = who_id;
	}

	public int getWhom_id() {
		return whom_id;
	}

	public void setWhom_id(int whom_id) {
		this.whom_id = whom_id;
	}
	
	

}
