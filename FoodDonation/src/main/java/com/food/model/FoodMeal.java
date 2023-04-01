package com.food.model;

public class FoodMeal {

	private long fm_id;
	private String fm_type;
	private String fm_desc;
	private String fm_qty;
	private String v_id;
	private String d_id;
	private String o_id;
	private String fm_date;
	private String p_address;
	private String status;
	private String contactNumber;
	private String feedback;

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public FoodMeal() {
		super();
	}

	public FoodMeal(long fm_id, String fm_type, String fm_desc, String fm_qty, String v_id, String d_id, String o_id,
			String fm_date, String p_address, String status, String contactNumber, String feedback) {
		super();
		this.fm_id = fm_id;
		this.fm_type = fm_type;
		this.fm_desc = fm_desc;
		this.fm_qty = fm_qty;
		this.v_id = v_id;
		this.d_id = d_id;
		this.o_id = o_id;
		this.fm_date = fm_date;
		this.p_address = p_address;
		this.status = status;
		this.contactNumber = contactNumber;
		this.feedback = feedback;
	}

	public long getFm_id() {
		return fm_id;
	}

	public void setFm_id(long fm_id) {
		this.fm_id = fm_id;
	}

	public String getFm_type() {
		return fm_type;
	}

	public void setFm_type(String fm_type) {
		this.fm_type = fm_type;
	}

	public String getFm_desc() {
		return fm_desc;
	}

	public void setFm_desc(String fm_desc) {
		this.fm_desc = fm_desc;
	}

	public String getFm_qty() {
		return fm_qty;
	}

	public void setFm_qty(String fm_qty) {
		this.fm_qty = fm_qty;
	}

	public String getV_id() {
		return v_id;
	}

	public void setV_id(String v_id) {
		this.v_id = v_id;
	}

	public String getD_id() {
		return d_id;
	}

	public void setD_id(String d_id) {
		this.d_id = d_id;
	}

	public String getO_id() {
		return o_id;
	}

	public void setO_id(String o_id) {
		this.o_id = o_id;
	}

	public String getFm_date() {
		return fm_date;
	}

	public void setFm_date(String fm_date) {
		this.fm_date = fm_date;
	}

	public String getP_address() {
		return p_address;
	}

	public void setP_address(String p_address) {
		this.p_address = p_address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "FoodMeal [fm_id=" + fm_id + ", fm_type=" + fm_type + ", fm_desc=" + fm_desc + ", fm_qty=" + fm_qty
				+ ", v_id=" + v_id + ", d_id=" + d_id + ", o_id=" + o_id + ", fm_date=" + fm_date + ", p_address="
				+ p_address + ", status=" + status + ", contactNumber=" + contactNumber + "]";
	}

}
