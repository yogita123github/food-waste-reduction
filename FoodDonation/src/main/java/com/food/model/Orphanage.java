package com.food.model;

public class Orphanage {

	private long o_id;
	private String o_name;
	private String o_address;
	private String o_contact;
	private String o_desc;
	private String o_email;
	

	public Orphanage() {
		super();
	}

	public Orphanage(long o_id, String o_name, String o_address, String o_contact, String o_desc, String o_email) {
		super();
		this.o_id = o_id;
		this.o_name = o_name;
		this.o_address = o_address;
		this.o_contact = o_contact;
		this.o_desc = o_desc;
		this.o_email = o_email;
	}

	public long getO_id() {
		return o_id;
	}

	public void setO_id(long o_id) {
		this.o_id = o_id;
	}

	public String getO_name() {
		return o_name;
	}

	public void setO_name(String o_name) {
		this.o_name = o_name;
	}

	public String getO_address() {
		return o_address;
	}

	public void setO_address(String o_address) {
		this.o_address = o_address;
	}

	public String getO_contact() {
		return o_contact;
	}

	public void setO_contact(String o_contact) {
		this.o_contact = o_contact;
	}

	public String getO_desc() {
		return o_desc;
	}

	public void setO_desc(String o_desc) {
		this.o_desc = o_desc;
	}

	public String getO_email() {
		return o_email;
	}

	public void setO_email(String o_email) {
		this.o_email = o_email;
	}



	@Override
	public String toString() {
		return "Orphanage [o_id=" + o_id + ", o_name=" + o_name + ", o_address=" + o_address + ", o_contact="
				+ o_contact + ", o_desc=" + o_desc + ", o_email=" + o_email + ", o_pass=" + "]";
	}

}
