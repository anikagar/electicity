package com.electricity.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.electricity.entity.BillingDetail;
import com.electricity.entity.BillingRateDetail;
import com.electricity.entity.Complaint;
import com.electricity.entity.Payment;
import com.electricity.entity.User;
import com.electricity.exception.ElectricityException;
import com.electricity.service.ElectricityService;

@Controller
@RequestMapping("/electricity")
public class ElectricityController {
	
	@Autowired
	ElectricityService service;
	
	@Autowired
	HttpSession session;
		
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/newuser")
	public String newUser() {
		return "newuser";
	}
	
	@PostMapping("/registration")
	public ModelAndView registration(@Valid  @ModelAttribute("newUser") User newUser) throws ElectricityException {
		ModelAndView mv = new ModelAndView();		
		System.out.println("in controller");
		
		if(service.existsUsername(newUser.getUsername()) != null) {
			throw new ElectricityException("Username already exist");
		} else {
			LocalDate localDate = LocalDate.now();
			newUser.setCreatedBy(newUser.getUsername());
			newUser.setModifiedBy(newUser.getUsername());
			newUser.setCreatedOn(localDate);
			newUser.setModifiedOn(localDate);
		    service.saveUser(newUser);
		    mv.setViewName("home");
		}	
		
		return mv;
	}
	
	@RequestMapping("/forgotpassword")
	public String forgotPassword() {
		return "forgotpassword";
	}
	
	@PostMapping("/changepassword")
	public ModelAndView changePassword(@RequestParam("username") String username, @RequestParam("password") String password) {
	    ModelAndView mv = new ModelAndView();
		String userid =null;
		
		userid = service.existsUsername(username);
	    if(userid != null) {
	    	LocalDate localDate = LocalDate.now();
	    	service.updatePassword(userid, password, username, localDate);
	    	mv.setViewName("home");
	    } else {
	    	throw new ElectricityException("Username not exist");
	    }
	    
	    return mv;
	}
	
	@RequestMapping("/login")
	public String loginCheck(@RequestParam("username") String username, @RequestParam("password") String password1) {
		String userid =null;
		String password2=null;
		String viewname = null;
				
		userid= service.existsUsername(username);
		if(userid != null) {
			password2 = service.getPassword(userid);
			if(password1.equals(password2)) {
				session.setAttribute("username", username);
				if(username.equals("ebsadmin")) {
					viewname = "adminhomepage";
				} else {
					viewname = "userhomepage";
				}
			} else {
				throw new ElectricityException("You have entered wrong password");
			}
		} else {
			throw new ElectricityException("You have enter wrong username");
		}
		
		return viewname;
	}
	
	@GetMapping("/electricityadminoption")
	public ModelAndView electricityAdminOption(@RequestParam String electricityadmin) {
		ModelAndView mv = new ModelAndView();
		
		if(electricityadmin.equals("billingrate")) {
		    mv.addObject("billingratelist", service.fetchBillingRateDetails());
			mv.setViewName("billingrate");
		} else if(electricityadmin.equals("generatebill")) {
			mv.addObject("usernameList", service.fetchAllUsername());
			mv.setViewName("generatebill");
		} else if(electricityadmin.equals("viewcomplaint")) {
			mv.addObject("complaintList", service.fetchAllRecord());
			mv.setViewName("viewcomplaint");
		} else if (electricityadmin.equals("report")) {
			mv.setViewName("report");
		}
		
		return mv;
	}
	
	
	@RequestMapping("/addbillingratedetailform")
	public String addBillingRateDetailForm() {
		return "billingratedetailform";
	}
	
	@PostMapping("/addbillingratedetail")
	public String addBillingRateDetail(@ModelAttribute("billingrate") BillingRateDetail billingrate) {
		System.out.println("in Add Billing Rate Detail");
		System.out.println(billingrate.getBillingRateDetailId());
		LocalDate localDate = LocalDate.now();
		billingrate.setModifiedOn(localDate);
		billingrate.setCreatedOn(localDate);
		billingrate.setCurrentInd("Y");
		billingrate.setCreatedBy(session.getAttribute("username").toString());
		billingrate.setModifiedBy(session.getAttribute("username").toString());
		service.saveBillingRateDetails(billingrate);
		
		return "adminhomepage";
	}
	
	@PostMapping("/generatebill")
	public String generateBilling(@ModelAttribute("billingdetail") BillingDetail billingDetail) {
		String username =session.getAttribute("username").toString();        
        service.generateBilling(billingDetail, username);
        
		return "adminhomepage";
	}
	
	@RequestMapping("/return")
    public String returnOption() {
		String viewName = null;
		if(session.getAttribute("username").toString().equals("ebsadmin")) {
			viewName = "adminhomepage";
		} else {
			viewName = "userhomepage";
		}
		
		return viewName;
	}
	
	@GetMapping("/electricityuseroption")
	public ModelAndView electricityUserOption(@RequestParam("electricityuser") String option) {
		ModelAndView mv = new ModelAndView();
		String username = session.getAttribute("username").toString();
		if(option.equals("fetchbill")) {			
			mv.addObject("billList", service.fetchElectricityBill(username));
			mv.addObject("username", username);
			mv.setViewName("userbilldetail");
		} else if(option.equals("registercomplaint")) {
			mv.setViewName("registercomplaint");
		} else if(option.equals("complaintresult")) {
			mv.addObject("resultList", service.fetchResolvedRecord(username));
			mv.setViewName("complaintresult");
		} else if(option.equals("payment")) {
			mv.addObject("billMonthList", service.fetchBillMonthPaymentPending(username));
			mv.setViewName("payment");
		}
		return mv;
	}
	
	@RequestMapping("/registercomplaint")
	public String registerComplaint(@ModelAttribute("complaint") Complaint complaint) {
		System.out.println(complaint.getComplaintDesc());
		String username = session.getAttribute("username").toString();
		LocalDate localDate = LocalDate.now();
		
		complaint.setComplaintStatus("NEW");
		complaint.setUsername(username);
		complaint.setCreatedBy(username);	
		complaint.setModifiedBy(username);
		complaint.setCreatedOn(localDate);
		complaint.setModifiedOn(localDate);
		
		Complaint comp = service.registerComplaint(complaint);
		if(comp == null) {
			throw new ElectricityException("Due to some error complaint is not registered. Please try again");
		}
		
		return "userhomepage";
	}
	
	@PostMapping("/complaintresolution")
	public String complaintResolution(@ModelAttribute("complaint") Complaint complaint) {
		String user = session.getAttribute("username").toString();
		LocalDate date = LocalDate.now();
		int result = service.updateComplaintReply(complaint.getComplaintId(), complaint.getComplaintReply(), complaint.getComplaintStatus(), user, date);
		if(result != 1) {
			throw new ElectricityException("Issue in updating complaint. Please try again");
		}
		return "adminhomepage";
	}
	
	@PostMapping("/updatecomplaintfromuser")
	public String updateComplaintFromUser(@ModelAttribute("complaint") Complaint complaint) {
	    String user = session.getAttribute("username").toString();
	    int result = service.updateComplaintReplyFromUser(complaint.getComplaintId(), complaint.getComplaintDesc(), 
	    		                                          complaint.getComplaintStatus(), user, LocalDate.now());
	    if(result != 1) {
	    	throw new ElectricityException("Issue in; updating complaint. Please try again");
	    }
		return "userhomepage";
	}
	
	@PostMapping("/payment")
	public ModelAndView applyPayment(@ModelAttribute("payment") Payment payment) {
		ModelAndView mv = new ModelAndView();
		String user = session.getAttribute("username").toString();
		LocalDate date = LocalDate.now();
		
		payment.setUsername(user);
		payment.setCreatedBy(user);
		payment.setModifiedBy(user);
		payment.setCreatedOn(date);
		payment.setModifiedOn(date);
		payment.setPaymentDate(date);
		
		Payment pay = service.applyPayment(payment);
		if(pay==null) {
			throw new ElectricityException("Error while applying Payment");
		}
		mv.addObject("paydetail", pay);
		mv.setViewName("paymentsuccess");
		
		return mv;
	}
	
	@RequestMapping("/paymentdetail")
	public ModelAndView fetchPaymentDetail(@RequestParam("billMonth") String billMonth) {
		ModelAndView mv = new ModelAndView();
		String user = session.getAttribute("username").toString();
		mv.addObject("billDetail", service.fetchBillingDetailForPayment(billMonth, user));
		mv.addObject("billMonthList", service.fetchBillMonthPaymentPending(user));
		mv.setViewName("payment");
		return mv;
	}
	
	@RequestMapping("/reportrequest")
	public ModelAndView fetchReport(@RequestParam("reportType") String reportType, @RequestParam("billMonth") String date) {
		ModelAndView mv = new ModelAndView();
		String billMonth = null;
		String month = date.substring(5, 7);
		switch (month) {
		case "01": billMonth = "Jan";
			       break;
		case "02": billMonth = "Feb";
	               break;
		case "03": billMonth = "Mar";
	               break;
		case "04": billMonth = "Apr";
	               break;
		case "05": billMonth = "May";
	               break;
		case "06": billMonth = "Jun";
	               break;
		case "07": billMonth = "Jul";
	               break;
		case "08": billMonth = "Aug";
	               break;
		case "09": billMonth = "Sep";
	               break;
		case "10": billMonth = "Oct";
	               break;
		case "11": billMonth = "Nov";
	               break;
		case "12": billMonth = "Dec";
	               break;
        default:   
			       break;
		}
		billMonth = billMonth + "-" + date.substring(0,4); 
		
		mv.addObject("reportList", service.fetchReport(reportType, billMonth));
		mv.setViewName("report");
		
		return mv;	
	}
}

