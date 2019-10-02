package org.bouche.training.bank.pricing.exceptions;

public abstract class PricingException extends RuntimeException {

	public PricingException(String message) {
		super(message);
	}

}
