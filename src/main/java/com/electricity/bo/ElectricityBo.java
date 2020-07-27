package com.electricity.bo;

import java.util.List;

import org.hibernate.query.criteria.internal.expression.function.LengthFunction;
import org.springframework.stereotype.Component;

@Component
public class ElectricityBo {
	
	public String setUserId(String userId) {
		System.out.println(userId);
		if(userId == null) {
			userId = "AAEBS0000000001";
		} else {
			int subuserid = Integer.parseInt(userId.substring(5)) + 1;
			System.out.println(subuserid);
			String id = Integer.toString(subuserid);
			String zeroappend = "";
			for(int i=0; i<10-+id.length(); i++) {
				zeroappend += "0";
			}
			userId = "AAEBS"+zeroappend+subuserid;
			System.out.println(userId);
		}
		return userId;
		
	}

	public Long fetchIdFromList(List<Long> idList) {
		Long id = idList.get(0);
		for(int i=1; i<idList.size(); i++) {
			if(id < idList.get(i)) {
				id = idList.get(i);
			}
		}
		return id;
	}
	
	public String calculateBillMonth(String billMonth) {
		String actualMonth = null;
		String month = billMonth.substring(0, billMonth.indexOf("-"));
		String lastString = billMonth.substring(billMonth.indexOf("-")+1);
			
		System.out.println(month);
		System.out.println(lastString);
		
		if(month.equals("Dec")) {
			actualMonth = "Nov";
		} else if(month.equals("Nov")) {
			actualMonth = "Oct";
		} else if(month.equals("Oct")) {
			actualMonth = "Sep";
		} else if(month.equals("Sep")) {
			actualMonth = "Aug";
		} else if(month.equals("Aug")) {
			actualMonth = "Jul";
		} else if(month.equals("Jul")) {
			actualMonth = "Jun";
		} else if(month.equals("Jun")) {
			actualMonth = "May";
		} else if(month.equals("May")) {
			actualMonth = "Apr";
		} else if(month.equals("Apr")) {
			actualMonth = "Mar";
		} else if(month.equals("Mar")) {
			actualMonth = "Feb";
		} else if(month.equals("Feb")) {
			actualMonth = "Jan";
		} else if(month.equals("Jan")) {
			actualMonth = "Dec";
			int year = Integer.parseInt(lastString)-1;
			lastString = Integer.toString(year);
		}
		
		billMonth = actualMonth + "-" + lastString;
		
		System.out.println(billMonth);
		
		return billMonth;
	}

	public String calculateTransactionId() {
		final String alpha_numeric_string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<16;i++) {
			int index = (int)(Math.random()*alpha_numeric_string.length());
			sb.append(alpha_numeric_string.charAt(index));
		}
		return sb.toString();
	}

}
