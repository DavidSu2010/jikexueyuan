package com.jike.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Poetries implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5707791397304566473L;
	private int id;
	private Poets poet_id;
	private String content;
	private String title;
	private Timestamp created_at;
	private Timestamp updated_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Poets getPoet_id() {
		return poet_id;
	}

	public void setPoet_id(Poets poet_id) {
		this.poet_id = poet_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}





}
