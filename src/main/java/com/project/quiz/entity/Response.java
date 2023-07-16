package com.project.quiz.entity;

public class Response {
	private int id;
	private String res;
	public Response(int id, String res) {
		super();
		this.id = id;
		this.res = res;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}

}
