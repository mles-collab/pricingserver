package org.bouche.training.bank.pricing.service;

import org.bouche.training.bank.pricing.exceptions.InvalidPricingDefinitionException;
import org.bouche.training.bank.pricing.exceptions.PricingIdDuplicationException;
import org.bouche.training.bank.pricing.exceptions.PricingNotFoundException;
import org.bouche.training.bank.pricing.model.Pricing;

public interface PricingService {
	
	public void addPricing(Pricing pricing)
			throws InvalidPricingDefinitionException, PricingIdDuplicationException;
	
	public Pricing getPricingById(int pricingId)
			throws PricingNotFoundException;
	
}
