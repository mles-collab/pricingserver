package org.bouche.training.bank.pricing.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.bouche.training.bank.pricing.dao.PricingRepository;
import org.bouche.training.bank.pricing.exceptions.InvalidPricingDefinitionException;
import org.bouche.training.bank.pricing.exceptions.PricingIdDuplicationException;
import org.bouche.training.bank.pricing.exceptions.PricingNotFoundException;
import org.bouche.training.bank.pricing.model.Pricing;
import org.bouche.training.bank.pricing.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingServiceImpl implements PricingService {

	@Autowired
	PricingRepository pricingRepository;

	@Override
	public void addPricing(Pricing pricing)
			throws PricingIdDuplicationException, InvalidPricingDefinitionException {
		
		if (pricing.getMinDuration() > pricing.getMaxDuration()) {
			throw new InvalidPricingDefinitionException("Max duration should be greater than min duration");
		}
		if (pricing.getMaxAmount().compareTo(pricing.getMinAmount()) < 0) {
			throw new InvalidPricingDefinitionException("Max amount should be greater than min amount");
		}
		if (pricing.getRate() == null || pricing.getRate().compareTo(BigDecimal.ZERO) < 0) {
			throw new InvalidPricingDefinitionException("Rate should be positive");
		}
		if (pricingRepository.findById(pricing.getId()).isPresent()) {
			throw new PricingIdDuplicationException("Duplicate Pricing Id");
		}
		pricingRepository.save(pricing);		
		
	}

	@Override
	public Pricing getPricingById(int pricingId)
			throws PricingNotFoundException {
		
		Optional<Pricing> pricing = pricingRepository.findById(pricingId);
		if (pricing.isPresent()) {
			return pricing.get();
		}
		throw new PricingNotFoundException("Pricing not found with Id " + pricingId);
		
	}

}

