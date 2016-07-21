/**
 * 
 */
package com.abc;

import java.math.BigDecimal;

/**
 * @author Jahnavi Koppisetty
 *
 */
public class CheckingAccount extends Account {

	private final BigDecimal interestRate;

	public CheckingAccount() {
		interestRate = BigDecimal.valueOf(0.001);
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}
	
	public AccountType getAccountType() {
		return AccountType.CHECKING;
	}

	@Override
	public BigDecimal calculateInterest(BigDecimal amount) {
		return amount.multiply(interestRate);
	}

}
