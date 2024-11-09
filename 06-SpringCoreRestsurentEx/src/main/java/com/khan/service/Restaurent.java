package com.khan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.khan.payment.IPayment;
@Component
public class Restaurent {

	@Autowired
	@Qualifier("dobj")
	private IPayment dpayment;
	@Autowired
	@Qualifier("cobj")
	private IPayment cpayment;
	@Autowired
	@Qualifier("uobj")
	private IPayment upayment;

	public Restaurent() {
		System.out.println("Restaurent.Restaurent()");

	}

	public void payBill() {
		System.out.println("Restaurent.payBill()");
		dpayment.pay();
		cpayment.pay();
		upayment.pay();
		
	}

	@Override
	public String toString() {
		return "Restaurent [dpayment=" + dpayment + ", cpayment=" + cpayment + ", upayment=" + upayment + "]";
	}

}
