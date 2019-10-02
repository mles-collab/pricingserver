package org.bouche.training.bank.pricing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PricingNotFoundException
	extends PricingException {

	public PricingNotFoundException(String message) {
		super(message);
	}

}

