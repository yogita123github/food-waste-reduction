package com.food.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.food.model.Admin;
import com.food.model.Donator;
import com.food.model.FoodMeal;
import com.food.model.Orphanage;
import com.food.model.Volunteer;
import com.food.service.ServiceClass;
import com.food.utility.ValidationU;

@Controller
public class ControllerClass {

	@Autowired
	private ServiceClass service;

	@Autowired
	private ValidationU validate;

	// Admin Start

	@RequestMapping("/")
	public String homePage(Model model) {
		return "views/index";
	}

	@RequestMapping("/dashboard")
	public String dashboardLoad(Model model) {
		// model.addAttribute("volunteer", new Volunteer());
		model.addAttribute("pending", "" + service.getAllPendingRequests().size());
		model.addAttribute("total", "" + service.getAllRequests().size());
		model.addAttribute("totalOrphanages", "" + service.getAllOrphanages().size());
		model.addAttribute("totalVolunteers", "" + service.getAllVolunteers().size());
		return "index";
	}

	@RequestMapping("/allRequests")
	public String allRequests(Model model) {
		List<FoodMeal> list = service.getAllRequests();
		model.addAttribute("list", list);
		return "ViewAllRequests";
	}

	@RequestMapping("/allVolunteers")
	public String allVolunteers(Model model) {
		List<Volunteer> list = service.getAllVolunteers();
		model.addAttribute("list", list);
		return "AllVolunteers";
	}

	@RequestMapping("/VolunteerInfo")
	public String allVolunteers(@RequestParam("vid") String vid, Model model) {
		List<Volunteer> list = service.getVolunteerInfo(Long.parseLong(vid));
		model.addAttribute("list", list);
		return "VolunteersInfo";
	}
	
	
	@RequestMapping("/VolunteerInfobyFMID")
	public String allVolunteersbyFMID(@RequestParam("fmid") String fmid, Model model) {
		List<Volunteer> list = service.getVolunteerInfobyFMID(Long.parseLong(fmid));
		model.addAttribute("list", list);
		return "VolunteersInfo";
	}

	@RequestMapping("/Feedback")
	public String feedbackForm(@RequestParam("fmid") String fmid, Model model) {
		// List<Volunteer> list = service.getVolunteerInfo(Long.parseLong(vid));
		model.addAttribute("foodmeal", new FoodMeal());
		model.addAttribute("fmid", fmid);
		return "Feedback";
	}

	@RequestMapping(value = "/feedbackFormSubmit", method = RequestMethod.POST)
	public String feedbackFormSubmit(@RequestParam("fmid") String fmid, @ModelAttribute FoodMeal foodmeal,
			Model model) {
		System.out.println("IN UPDATE");
		boolean res = service.submitFeedback(Long.parseLong(fmid), foodmeal.getFeedback());
		model.addAttribute("foodmeal", new FoodMeal());
		model.addAttribute("fmid", fmid);
		model.addAttribute("error", "Feedback submitted successfully!!");
		return "views/index";
	}

	@RequestMapping("/allDonators")
	public String allDonators(Model model) {
		List<Donator> list = service.getAllDonators();
		model.addAttribute("list", list);
		return "allDonators";
	}

	@RequestMapping("/donatorInfo")
	public String allDonators(@RequestParam("did") String did, Model model) {
		List<Donator> list = service.getDonatorsInfo(Long.parseLong(did));
		model.addAttribute("list", list);
		return "donatorsInfo";
	}  
	
	@RequestMapping("/donatorInfobyFM")
	public String allDonatorsbyFMID(@RequestParam("fmid") String fmid, Model model) {
		List<Donator> list = service.getDonatorsInfobyFMID(Long.parseLong(fmid));
		model.addAttribute("list", list);
		return "donatorsInfo";
	}

	@RequestMapping("/allOrphanages")
	public String allOrphanages(Model model) {
		List<Orphanage> list = service.getAllOrphanages();
		model.addAttribute("title", "All Orphanages");
		model.addAttribute("list", list);
		return "AllOrphanages";
	}

	@RequestMapping("/OrphanagesInfo")
	public String allOrphanages(@RequestParam("oid") String oid, Model model) {
		System.out.println("IDD = " + oid);
		List<Orphanage> list = service.getOrphanagesInfo(Long.parseLong(oid));
		model.addAttribute("title", "Orphanage Information");
		model.addAttribute("list", list);
		return "OrphanageInfo";
	}
	
	@RequestMapping("/OrphanagesInfobyFMID")
	public String allOrphanagesbyFMID(@RequestParam("fmid") String fmid, Model model) {
		
		List<Orphanage> list = service.getOrphanagesInfobyFMID(Long.parseLong(fmid));
		model.addAttribute("title", "Orphanage Information");
		model.addAttribute("list", list);
		return "OrphanageInfo";
	}

	// Admin End

	@RequestMapping("/MyRequestsToDeliver")
	public String myReqToDeliver(Model model, HttpSession sn) {
		List<FoodMeal> list = service.getMyRequestsVolunteer(Long.parseLong("" + sn.getAttribute("id")));
		System.out.println("List = " + list);
		model.addAttribute("list", list);
		return "MyReqVolunteer";
	}

	@RequestMapping("/AssignMe")
	public String assignMe(@RequestParam("fmid") String fmid, HttpSession sn, Model model) {

		long fm_id = Long.parseLong(fmid);
		long v_id = Long.parseLong(sn.getAttribute("id") + "");
		boolean result = service.assignMeVolunteer(fm_id, v_id);
		if (result) {

			List<FoodMeal> list = service.getMyRequestsVolunteer(v_id);
			System.out.println("List = " + list);
			model.addAttribute("list", list);
		}
		return "MyReqVolunteer";

	}

	@RequestMapping("/Reject")
	public String rejectRequest(@RequestParam("fmid") String fmid,HttpSession sn, Model model) {

		long fm_id = Long.parseLong(fmid);
		long v_id = Long.parseLong(sn.getAttribute("id") + "");
		boolean result = service.declineReq(fm_id);
		if (result) {

			List<FoodMeal> list = service.getMyRequestsVolunteer(v_id);
			System.out.println("List = " + list);
			model.addAttribute("list", list);
		}
		return "MyReqVolunteer";

	}

	@RequestMapping("/pickUp")
	public String pickUpDone(@RequestParam("fmid") String fmid,HttpSession sn, Model model) {

		long fm_id = Long.parseLong(fmid);
		long v_id = Long.parseLong(sn.getAttribute("id") + "");
		boolean result = service.pickUpVolunteer(fm_id, v_id);
		if (result) {

			List<FoodMeal> list = service.getMyRequestsVolunteer(v_id);
			System.out.println("List = " + list);
			model.addAttribute("list", list);
		}
		return "MyReqVolunteer";

	}

	@RequestMapping("/delivered")
	public String deliverDone(@RequestParam("fmid") String fmid,HttpSession sn, Model model) {

		long fm_id = Long.parseLong(fmid);
		long v_id = Long.parseLong(sn.getAttribute("id") + "");
		boolean result = service.deliveredVolunteer(fm_id, v_id);
		if (result) {

			List<FoodMeal> list = service.getMyRequestsVolunteer(v_id);
			System.out.println("List = " + list);
			model.addAttribute("list", list);
		}
		return "MyReqVolunteer";

	}

	@RequestMapping("/donationstoOrph")
	public String donationsToOrph(@RequestParam("oid") String oid, Model model) {
		Long o_id = Long.parseLong(oid);
		List<FoodMeal> list = service.getAllRequestsByOrph(o_id);
		System.out.println("List = " + list);
		model.addAttribute("list", list);
		return "donationstoorph";
	}

	@RequestMapping("/donationsByMe")
	public String donationsByMe(Model model, HttpSession sn) {
		System.out.println("IN DON " + sn.getAttribute("id"));
		List<FoodMeal> list = service.getAllDonationsByMe(Long.parseLong("" + sn.getAttribute("id")));
		System.out.println("List = " + list);
		model.addAttribute("list", list);
		return "ViewAllDonationsDonator";
	}

	@RequestMapping("/pendingReq")
	public String pendingReq(Model model) {
		List<FoodMeal> list = service.getAllPendingRequests();
		System.out.println("List = " + list);
		model.addAttribute("list", list);
		return "PendingRequest";
	}

	@RequestMapping("/donationForm")
	public String donationForm(Model model) {
		
		model.addAttribute("foodmeal", new FoodMeal());
		model.addAttribute("o_list", service.getOrphanagesMenu());
		return "donationRequest";
	}

	@RequestMapping(value = "/donationFormSubmit", method = RequestMethod.POST)
	public String donationFormSubmit(@ModelAttribute FoodMeal foodmeal, HttpSession sn, Model model) {
		model.addAttribute("foodmeal", foodmeal);
		System.out.println("F = "+foodmeal);
		model.addAttribute("o_list", service.getOrphanagesMenu());
		if (validate.checkStringG3(foodmeal.getFm_type()) && validate.checkStringG3(foodmeal.getFm_desc())
				&& foodmeal.getFm_qty().length() >= 2 && validate.isContactValid(foodmeal.getContactNumber())) {
			foodmeal.setD_id(sn.getAttribute("id")+"");
			boolean result = service.addDonationRequest(foodmeal);
			if (result) {
				model.addAttribute("error", "Request Added !!");
				return "views/index";
			}
			else
				model.addAttribute("error", "Invalid Details !!");
			model.addAttribute("foodmeal", new FoodMeal());
			model.addAttribute("o_list", service.getOrphanagesMenu());
			return "donationRequest";

		}
		model.addAttribute("error", "Invalid Details!!");
		return "donationRequest";

	}

	@RequestMapping("/volunteerRegistration")
	public String volunteerReg(Model model) {
		model.addAttribute("volunteer", new Volunteer());
		return "volunteerRegistration";
	}

	@RequestMapping(value = "/volunteerRegistration", method = RequestMethod.POST)
	public String volunteerRegSubmit(@ModelAttribute Volunteer volunteer, Model model) {

		if (validate.checkEmail(volunteer.getD_email()) && validate.checkStringG3(volunteer.getD_uname())
				&& validate.isContactValid(volunteer.getContact())) {
			boolean result = service.addVolunteer(volunteer);
			if (result) {
				model.addAttribute("error", "Volunteer Registered Successfully! Please log in");
				return "views/index";
			}
			else
				model.addAttribute("error", "Invalid Details");
			
		} else {
			model.addAttribute("error", "Invalid Details");
		}

		return "volunteerRegistration";
	}

	@RequestMapping("/orphanageRegistration")
	public String orphanageReg(Model model) {
		model.addAttribute("orphanage", new Orphanage());
		return "orphanageRegistration";
	}

	@RequestMapping(value = "/orphanageRegistration", method = RequestMethod.POST)
	public String volunteerRegSubmit(@ModelAttribute Orphanage orphanage, Model model) {

		if (validate.checkEmail(orphanage.getO_email()) && validate.checkStringG3(orphanage.getO_name())
				&& validate.checkStringG3(orphanage.getO_address()) && validate.checkStringG3(orphanage.getO_desc())
				&& validate.isContactValid(orphanage.getO_contact())) {
			boolean result = service.addOrphanage(orphanage);
			if (result)
				model.addAttribute("error", "Orphanage Added Successfully!!");
			else
				model.addAttribute("error", "Invalid Details");
		} else {
			model.addAttribute("error", "Invalid Details");
		}

		return "orphanageRegistration";
	}

	@RequestMapping("/donatorRegistration")
	public String donatorReg(Model model) {
		model.addAttribute("donator", new Donator());

		return "donatorRegistration";
	}

	@RequestMapping(value = "/donatorRegistration", method = RequestMethod.POST)
	public String donatorRegSubmit(@ModelAttribute Donator donator, Model model) {

		if (validate.checkEmail(donator.getD_email()) && validate.checkStringG3(donator.getAddress())
				&& validate.checkStringG3(donator.getD_uname()) && validate.isContactValid(donator.getContact())) {
			boolean result = service.addDonator(donator);
			if (result) {
				model.addAttribute("error", "Registered Successfully!!  Go to Login Page");
				return "views/index";
				
			}
			else
				model.addAttribute("error", "Invalid Details");
		} else {
			model.addAttribute("error", "Invalid Details");
		}
		return "donatorRegistration";
		
	}

	@RequestMapping("/volunteerLogin")
	public String volunteerLogin(Model model) {
		model.addAttribute("volunteer", new Volunteer());
		return "volunteerLogin";
	}

	@RequestMapping(value = "/volunteerLogin", method = RequestMethod.POST)
	public String volunteerLoginSubmit(@ModelAttribute Volunteer volunteer, HttpSession sn, Model model) {
		System.out.println(volunteer);
		model.addAttribute("volunteer", new Volunteer());
		if (validate.checkEmail(volunteer.getD_email())) {
			Volunteer v = service.verifyLoginVolunteer(volunteer);
			System.out.println(v);
			if (v == null) {
				model.addAttribute("error", "Invalid Details");
				return "volunteerLogin";
			} else {
				sn.setAttribute("id", v.getV_id() + "");
				sn.setAttribute("role", "Volunteer");
				return "views/index";
			}
		} else {
			model.addAttribute("error", "Invalid Details");
		}

		return "volunteerLogin";

	}

	// @RequestMapping("/orphanageLogin")
	// public String orphanageLogin(Model model) {
	// model.addAttribute("orphanage", new Orphanage());
	// return "orphanageLogin";
	// }
	//
	// @RequestMapping(value = "/orphanageLogin", method = RequestMethod.POST)
	// public String orphanageLoginSubmit(@ModelAttribute Orphanage orphanage, Model
	// model) {
	// System.out.println(orphanage);
	// Orphanage o = service.verifyLoginOrphaage(orphanage);
	// System.out.println(o);
	// if(o == null)
	// model.addAttribute("login","Fail");
	// else
	// model.addAttribute("status","Success");
	// return "orphanageLogin";
	// }

	@RequestMapping("/donatorLogin")
	public String donatorLogin(Model model) {
		model.addAttribute("donator", new Donator());

		return "donatorLogin";
	}

	@RequestMapping(value = "/donatorLogin", method = RequestMethod.POST)
	public String donatorLoginSubmit(@ModelAttribute Donator donator, HttpSession sn, Model model) {

		if (validate.checkEmail(donator.getD_email())) {
			Donator d = service.verifyLoginDonator(donator);
			if (d == null) {
				model.addAttribute("error", "Invalid Details");
				return "donatorLogin";
			} else {
				sn.setAttribute("id", d.getD_id() + "");
				sn.setAttribute("role", "Donator");
				return "views/index";
			}
		} else {
			model.addAttribute("error", "Invalid Email Address");
			return "donatorLogin";
		}

	}

	@RequestMapping("/adminLogin")
	public String adminLogin(Model model) {
		model.addAttribute("admin", new Admin());

		return "adminLogin";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession sn, Model model) {
		sn.removeAttribute("role");
		sn.removeAttribute("id");
		System.out.println("Logout");
		return "views/index";
	}

	@RequestMapping(value = "/adminLoginSubmit", method = RequestMethod.POST)
	public String adminLoginSubmit(@ModelAttribute Admin admin, HttpSession sn, Model model) {
		System.out.println("SUB");

		if (validate.checkEmail(admin.getEmail())) {

		} else {
			model.addAttribute("error", "Invalid Email Address");
			return "adminLogin";
		}

		Admin a = service.verifyLoginAdmin(admin);
		if (a == null) {
			model.addAttribute("error", "Invalid Details");
			return "adminLogin";
		}
		sn.setAttribute("role", "Admin");
		System.out.println(a);
		return "views/index";
	}

}
