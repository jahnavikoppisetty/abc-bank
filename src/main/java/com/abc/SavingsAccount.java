/**
 * 
 */
package com.abc;

import java.math.BigDecimal;

/**
 * @author Jahnavi Koppisetty
 *
 */
public class SavingsAccount extends Account {

	public SavingsAccount() {
	}

	public AccountType getAccountType() {
		return AccountType.SAVINGS;
	}

	@Override
	public BigDecimal calculateInterest(BigDecimal amount) {
		BigDecimal pointOnePercent = BigDecimal.valueOf(0.001);
		BigDecimal pointTwoPercent = BigDecimal.valueOf(0.002);

		BigDecimal onethousand = BigDecimal.valueOf(1000);
		BigDecimal interest = BigDecimal.ZERO;

		if (amount.compareTo(onethousand) <= 0) {
			interest = interest.add(onethousand.multiply(pointOnePercent));
		} else {
			interest = interest.add(onethousand.multiply(pointOnePercent));
			interest = interest.add(amount.subtract(onethousand).multiply(pointTwoPercent));
		}
		return interest;
	}
}
