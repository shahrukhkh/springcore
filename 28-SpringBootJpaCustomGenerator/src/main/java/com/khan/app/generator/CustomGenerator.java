package com.khan.app.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomGenerator implements IdentifierGenerator {

	
	private static Integer count=1; 
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		return "AIT"+count++;
	}

}
