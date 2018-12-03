package com.ibm.ph.amperca.todoapp.model;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {
	
	private int id;
	@Size(min=8, message="Please enter atleast 8 Characters")
	private String description;
	private Date createdDate;
	private Date finishDate;
	private boolean isActive;
	
	public Todo() {};
	
	public Todo(int id, String description, Date createdDate, Date finishDate, boolean isActive) {
		super();
		this.id = id;
		this.description = description;
		this.createdDate = createdDate;
		this.finishDate = finishDate;
		this.isActive = isActive;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean getIsActive() {
		return isActive;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", description=" + description + ", createdDate=" + createdDate + ", finishDate="
				+ finishDate + ", isActive=" + isActive + "]";
	}
	

}
