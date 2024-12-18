package com.khan.app.generator;

import java.util.UUID;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductCustomIdGenerator implements IdentifierGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		
		
		
		return "ID-"+UUID.randomUUID().toString().replace("-", "").substring(0,15).toUpperCase();
	}
	
	
}
