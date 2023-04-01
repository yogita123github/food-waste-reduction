package com.food.service;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.food.model.Admin;
import com.food.model.Donator;
import com.food.model.FoodMeal;
import com.food.model.Orphanage;
import com.food.model.Volunteer;

@Service
public class ServiceClass {
	private Connection con;

	public ServiceClass() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/donation", "root", "");

			System.out.println("COnnection done");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Map<Long, String> getOrphanagesMenu() {

		Map<Long, String> map = new HashMap<Long, String>();
		String sql = "SELECT * FROM orphanage";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				map.put(rs.getLong(1), rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Map  = " + map);
		return map;

	}
	
	public boolean assignMeVolunteer(long fmid,long vid) {
		String sql = "UPDATE food_meal SET v_id=?,status=? where fm_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(3, fmid);
			pstmt.setString(2, "Waiting for Pickup");
			pstmt.setLong(1, vid);
			int rowAffected = pstmt.executeUpdate();
			if(rowAffected >0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean declineReq(long fmid) {
		String sql = "UPDATE food_meal SET status=?,v_id=0 where fm_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(2, fmid);
			pstmt.setString(1, "Rejected");
			int rowAffected = pstmt.executeUpdate();
			if(rowAffected >0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean pickUpVolunteer(long fmid,long vid) {
		String sql = "UPDATE food_meal SET v_id=?,status=? where fm_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(3, fmid);
			pstmt.setString(2, "Deliver In Progress");
			pstmt.setLong(1, vid);
			int rowAffected = pstmt.executeUpdate();
			if(rowAffected >0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean deliveredVolunteer(long fmid,long vid) {
		String sql = "UPDATE food_meal SET v_id=?,status=? where fm_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(3, fmid);
			pstmt.setString(2, "Delivered");
			pstmt.setLong(1, vid);
			int rowAffected = pstmt.executeUpdate();
			if(rowAffected >0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean submitFeedback(long fmid,String msg) {
		String sql = "UPDATE food_meal SET feedback=? where fm_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(2, fmid);
			pstmt.setString(1, msg);
			int rowAffected = pstmt.executeUpdate();
			if(rowAffected >0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	
	public List<Donator> getDonatorsInfo(long did){
		ArrayList<Donator> list = new ArrayList<>();
		String sql = "SELECT * FROM donator WHERE d_id=?";
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, did);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Donator(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<Donator> getDonatorsInfobyFMID(long fmid){
		ArrayList<Donator> list = new ArrayList<>();
		String sql = "SELECT * FROM donator WHERE d_id IN (select d_id from food_meal WHERE fm_id = ?)";
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, fmid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Donator(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<Donator> getAllDonators(){
		ArrayList<Donator> list = new ArrayList<>();
		String sql = "SELECT * FROM donator";
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Donator(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<Volunteer> getVolunteerInfo(long vid){
		ArrayList<Volunteer> list = new ArrayList<>();
		String sql = "SELECT * FROM volunteer Where v_id=?";
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, vid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Volunteer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<Volunteer> getVolunteerInfobyFMID(long fmid){
		ArrayList<Volunteer> list = new ArrayList<>();
		String sql = "SELECT * FROM volunteer Where v_id IN (select v_id from food_meal where fm_id=?)";
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, fmid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Volunteer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<Volunteer> getAllVolunteers(){
		ArrayList<Volunteer> list = new ArrayList<>();
		String sql = "SELECT * FROM volunteer";
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Volunteer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	public List<Orphanage> getAllOrphanages(){
		ArrayList<Orphanage> list = new ArrayList<>();
		String sql = "SELECT * FROM orphanage";
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Orphanage(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<Orphanage> getOrphanagesInfo(long oid){
		ArrayList<Orphanage> list = new ArrayList<>();
		String sql = "SELECT * FROM orphanage where o_id=?";
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, oid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Orphanage(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<Orphanage> getOrphanagesInfobyFMID(long fmid){
		ArrayList<Orphanage> list = new ArrayList<>();
		String sql = "SELECT * FROM orphanage where o_id IN (select o_id from food_meal WHERE fm_id = ?)";
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, fmid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Orphanage(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<FoodMeal> getAllPendingRequests(){
		ArrayList<FoodMeal> list = new ArrayList<>();
		String sql = "SELECT fm.fm_id,fm.fm_type,fm.fm_desc,fm.fm_quantity,fm.v_id,d.d_uname,o.o_name,fm.fm_date,fm.p_address,fm.status,fm.contactNumber,fm.feedback FROM food_meal fm INNER JOIN donator d ON fm.d_id = d.d_id INNER JOIN orphanage o ON fm.o_id = o.o_id  WHERE fm.v_id IS NULL ORDER BY fm.fm_id DESC"; 
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
					list.add(new FoodMeal(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<FoodMeal> getAllRequestsByOrph(long oid){
		ArrayList<FoodMeal> list = new ArrayList<>();
		String sql = "SELECT fm.fm_id,fm.fm_type,fm.fm_desc,fm.fm_quantity,v.d_uname,d.d_uname,o.o_name,fm.fm_date,fm.p_address,fm.status,fm.contactNumber,fm.feedback FROM food_meal fm INNER JOIN donator d ON fm.d_id = d.d_id INNER JOIN orphanage o ON fm.o_id = o.o_id LEFT JOIN volunteer v ON fm.v_id= v.v_id WHERE fm.o_id=? ORDER BY fm.fm_id DESC;";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, oid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new FoodMeal(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<FoodMeal> getAllRequests(){
		ArrayList<FoodMeal> list = new ArrayList<>();
		String sql = "SELECT fm.fm_id,fm.fm_type,fm.fm_desc,fm.fm_quantity,v.d_uname,d.d_uname,o.o_name,fm.fm_date,fm.p_address,fm.status,fm.contactNumber,fm.feedback FROM food_meal fm INNER JOIN donator d ON fm.d_id = d.d_id INNER JOIN orphanage o ON fm.o_id = o.o_id LEFT JOIN volunteer v ON fm.v_id= v.v_id ORDER BY fm.fm_id DESC;";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new FoodMeal(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public List<FoodMeal> getMyRequestsVolunteer(long vid){
		
		ArrayList<FoodMeal> list = new ArrayList<>();
		String sql = "SELECT fm.fm_id,fm.fm_type,fm.fm_desc,fm.fm_quantity,v.v_id,d.d_uname,o.o_name,fm.fm_date,fm.p_address,fm.status,fm.contactNumber,fm.feedback FROM food_meal fm INNER JOIN donator d ON fm.d_id = d.d_id INNER JOIN orphanage o ON fm.o_id = o.o_id INNER JOIN volunteer v ON v.v_id=fm.v_id WHERE v.v_id=? ORDER BY fm.fm_id DESC";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, vid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new FoodMeal(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	public List<FoodMeal> getAllDonationsByMe(long did){
		ArrayList<FoodMeal> list = new ArrayList<>();
		String sql = "SELECT fm.fm_id,fm.fm_type,fm.fm_desc,fm.fm_quantity,v.d_uname,d.d_uname,o.o_name,fm.fm_date,fm.p_address,fm.status,fm.contactNumber,fm.feedback FROM food_meal fm INNER JOIN donator d ON fm.d_id = d.d_id INNER JOIN orphanage o ON fm.o_id = o.o_id LEFT JOIN volunteer v ON fm.v_id= v.v_id WHERE fm.d_id=? ORDER BY fm.fm_id DESC;";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, did);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new FoodMeal(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	public boolean addDonationRequest(FoodMeal fm) {

		String sql = "INSERT INTO food_meal (fm_id,fm_type,fm_desc,fm_quantity,d_id,o_id,fm_date,p_address,contactNumber,status) VALUES (null,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fm.getFm_type());
			pstmt.setString(2, fm.getFm_desc());
			pstmt.setString(3, fm.getFm_qty());
			pstmt.setString(4, fm.getD_id());
			pstmt.setString(5, fm.getO_id());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			pstmt.setString(6, dtf.format(now));
			pstmt.setString(7, fm.getP_address());
			pstmt.setString(8, fm.getContactNumber());
			pstmt.setString(9, "Waiting for Approval");
			if (pstmt.executeUpdate() > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean addVolunteer(Volunteer v) {

		String sql = "INSERT INTO volunteer VALUES (null,?,?,?,?)";

		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, v.getD_uname());
			pstmt.setString(2, v.getContact());
			pstmt.setString(3, v.getD_pass());
			pstmt.setString(4, v.getD_email());
			if (pstmt.executeUpdate() > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error" + e.getMessage());

			e.printStackTrace();
		}

		return false;
	}

	public boolean addDonator(Donator d) {
		String sql = "INSERT INTO donator VALUES (null,?,?,?,?,?)";
		// uname pass address contact email
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d.getD_uname());
			pstmt.setString(2, d.getD_pass());
			pstmt.setString(3, d.getAddress());
			pstmt.setString(4, d.getContact());
			pstmt.setString(5, d.getD_email());
			if (pstmt.executeUpdate() > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean addOrphanage(Orphanage o) {
		// o_id o_name address contact desc email pass
		String sql = "INSERT INTO Orphanage VALUES (null,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, o.getO_name());
			pstmt.setString(2, o.getO_address());
			pstmt.setString(3, o.getO_contact());
			pstmt.setString(4, o.getO_desc());
			pstmt.setString(5, o.getO_email());
			if (pstmt.executeUpdate() > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public Admin verifyLoginAdmin(Admin a) {

		String sql = "SELECT * FROM admin WHERE email=? and password=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, a.getEmail());
			pstmt.setString(2, a.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				a = new Admin(rs.getLong(1), rs.getString(2), rs.getString(3));
				return a;
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public Donator verifyLoginDonator(Donator d) {

		String sql = "SELECT * FROM donator WHERE email=? and d_pass=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d.getD_email());
			pstmt.setString(2, d.getD_pass());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				d = new Donator(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
				return d;
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public Volunteer verifyLoginVolunteer(Volunteer v) {
		String sql = "SELECT * FROM volunteer WHERE d_email=? and d_pass=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, v.getD_email());
			pstmt.setString(2, v.getD_pass());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				v = new Volunteer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return v;
			} else {
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
