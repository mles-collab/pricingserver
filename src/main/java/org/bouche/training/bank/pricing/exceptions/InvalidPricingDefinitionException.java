package org.bouche.training.bank.pricing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidPricingDefinitionException
	extends PricingException {

	public InvalidPricingDefinitionException(String message) {
		super(message);
	}

}

