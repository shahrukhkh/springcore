package com.khan.payment;

import org.springframework.stereotype.Component;

@Component("cobj")
public class CreditCard implements IPayment{
	
	
	public CreditCard()
	{
		System.out.println("CreditCard.CreditCard()");
	}
	
	@Override
	public int pay() {
		System.out.println("CreditCard.pay()");
		return 0;
	}

}
