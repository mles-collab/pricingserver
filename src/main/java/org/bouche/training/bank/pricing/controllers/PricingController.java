package org.bouche.training.bank.pricing.controllers;

import org.bouche.training.bank.pricing.exceptions.InvalidPricingDefinitionException;
import org.bouche.training.bank.pricing.exceptions.PricingIdDuplicationException;
import org.bouche.training.bank.pricing.exceptions.PricingNotFoundException;
import org.bouche.training.bank.pricing.model.Pricing;
import org.bouche.training.bank.pricing.service.PricingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingController {

	Logger LOG = LoggerFactory.getLogger(PricingController.class);
	
	@Autowired
	PricingService pricingService;
	
	@GetMapping("/pricing/{pricingId}")
	public Pricing getPricingById(@PathVariable int pricingId)
			throws PricingNotFoundException {
		
		return pricingService.getPricingById(pricingId);
		
	}
	
	@PostMapping("/pricing")
	public void addPricing(@RequestBody Pricing pricing)
			throws InvalidPricingDefinitionException, PricingIdDuplicationException {
		
		LOG.info("Added new pricing with ID " + pricing.getId());
		pricingService.addPricing(pricing);
		
	}
	
}


