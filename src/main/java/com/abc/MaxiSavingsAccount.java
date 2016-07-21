/**
 * 
 */
package com.abc;

import java.math.BigDecimal;

/**
 * @author Jahnavi Koppisetty
 *
 */
public class MaxiSavingsAccount extends Account {
	
	public MaxiSavingsAccount() {
	}

	public AccountType getAccountType() {
		return AccountType.MAXI_SAVINGS;
	}


	@Override
	public BigDecimal calculateInterest(BigDecimal amount) {
		BigDecimal twoPercent = BigDecimal.valueOf(0.02);
		BigDecimal fivePercent = BigDecimal.valueOf(0.05);
		BigDecimal tenPercent = BigDecimal.valueOf(0.1);
		BigDecimal onethousand = BigDecimal.valueOf(1000);
		BigDecimal twothousand = BigDecimal.valueOf(2000);
		BigDecimal interest = BigDecimal.ZERO;
		
		if (amount.compareTo(onethousand) <= 0) {
			interest = interest.add(amount.multiply(twoPercent));
		} else if (amount.compareTo(twothousand) <= 0) {
			interest = interest.add(onethousand.multiply(twoPercent));
			interest = interest.add(amount.subtract(onethousand).multiply(fivePercent));
		} else {
			interest = interest.add(onethousand.multiply(twoPercent));
			interest = interest.add(onethousand.multiply(fivePercent));
			interest = interest.add(amount.subtract(twothousand).multiply(tenPercent));
		}
		return interest;
	}

}
