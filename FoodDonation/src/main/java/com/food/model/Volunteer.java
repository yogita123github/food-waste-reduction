package com.food.model;

public class Volunteer {
	private long v_id;
	private String d_uname;
	private String contact;
	private String d_pass;
	private String d_email;

	public Volunteer() {
		super();
	}
	
	public Volunteer(long v_id, String d_uname, String contact, String d_pass, String d_email) {
		super();
		this.v_id = v_id;
		this.d_uname = d_uname;
		this.contact = contact;
		this.d_pass = d_pass;
		this.d_email = d_email;
	}

	public long getV_id() {
		return v_id;
	}

	public void setV_id(long v_id) {
		this.v_id = v_id;
	}

	public String getD_uname() {
		return d_uname;
	}

	public void setD_uname(String d_uname) {
		this.d_uname = d_uname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getD_pass() {
		return d_pass;
	}

	public void setD_pass(String d_pass) {
		this.d_pass = d_pass;
	}

	public String getD_email() {
		return d_email;
	}

	public void setD_email(String d_email) {
		this.d_email = d_email;
	}

	@Override
	public String toString() {
		return "Volunteer [v_id=" + v_id + ", d_uname=" + d_uname + ", contact=" + contact + ", d_pass=" + d_pass
				+ ", d_email=" + d_email + "]";
	}

	
}
