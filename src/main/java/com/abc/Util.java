/**
 * 
 */
package com.abc;

import static java.lang.Math.abs;

import java.math.BigDecimal;

/**
 * @author Jahnavi Koppisetty
 *
 */
public class Util {

	public static String toDollars(BigDecimal amount){
        return String.format("$%,.2f", abs(amount.doubleValue()));
    }
	
	public static String format(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }
}
