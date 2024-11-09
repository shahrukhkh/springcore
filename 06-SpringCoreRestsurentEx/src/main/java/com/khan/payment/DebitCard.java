package com.khan.payment;

import org.springframework.stereotype.Component;

@Component("dobj")
public class DebitCard implements IPayment{
	public DebitCard()
	{
		System.out.println("DebitCard.DebitCard()");
	}

	@Override
	public int pay() {
		System.out.println("DebitCard.pay()");
		return 0;
	}

}
