package org.bouche.training.bank.pricing.dao;

import java.math.BigDecimal;
import java.util.List;

import org.bouche.training.bank.pricing.model.Pricing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingRepository extends CrudRepository<Pricing, Integer> {

	List<Pricing> findByMinAmountLessThanEqualAndMaxAmountGreaterThanEqualAndMinDurationLessThanEqualAndMaxDurationLessThanEqual(BigDecimal amountA, BigDecimal amountB, int durationA, int durationB);
	
	default List<Pricing> findByAmountAndDuration(BigDecimal amount, int duration) {
		return findByMinAmountLessThanEqualAndMaxAmountGreaterThanEqualAndMinDurationLessThanEqualAndMaxDurationLessThanEqual(amount, amount, duration, duration);
	}
}
