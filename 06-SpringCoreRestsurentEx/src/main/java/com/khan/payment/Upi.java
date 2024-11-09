package com.khan.payment;

import org.springframework.stereotype.Component;

@Component("uobj")
public class Upi implements IPayment {

	public Upi() {
		System.out.println("Upi.Upi()");
	}

	@Override
	public int pay() {
		System.out.println("Upi.pay()");
		return 0;
	}

}
