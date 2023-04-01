package com.food.model;

public class Donator {
	private long d_id;
	private String d_uname;
	private String d_pass;
	private String address;
	private String contact;
	private String d_email;

	
	public Donator() {
		super();
	}
	public Donator(long d_id, String d_uname, String d_pass, String address, String contact, String d_email) {
		super();
		this.d_id = d_id;
		this.d_uname = d_uname;
		this.d_pass = d_pass;
		this.address = address;
		this.contact = contact;
		this.d_email = d_email;
	}

	public long getD_id() {
		return d_id;
	}

	public void setD_id(long d_id) {
		this.d_id = d_id;
	}

	public String getD_uname() {
		return d_uname;
	}

	public void setD_uname(String d_uname) {
		this.d_uname = d_uname;
	}

	public String getD_pass() {
		return d_pass;
	}

	public void setD_pass(String d_pass) {
		this.d_pass = d_pass;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getD_email() {
		return d_email;
	}

	public void setD_email(String d_email) {
		this.d_email = d_email;
	}

	@Override
	public String toString() {
		return "Donator [d_id=" + d_id + ", d_uname=" + d_uname + ", d_pass=" + d_pass + ", address=" + address
				+ ", contact=" + contact + ", d_email=" + d_email + "]";
	}

}
