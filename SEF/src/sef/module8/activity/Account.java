package sef.module8.activity;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Thsi class represents a simple representation of an account encapsulating
 * a name 
 * 
 * @author Bernards Gulbis
 *
 */
public class Account {

	private String accountName;

	private boolean containsNumber(String s) {
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (temp >= '0' && temp <= '9'){
				return true;
			}
		}
		return false;
	}
	

	private boolean containsLetter(String s) {
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if ((temp >= 'A' && temp <= 'Z') || (temp >= 'a' && temp <= 'z')) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Creates an Account object with the specified name.  If the accout name
	 * given violates the minimum requirements, then an AccountException is thrown
	 * 
	 * @param accountName
	 * @throws AccountException
	 */
	public  Account(String accountName) throws AccountException{
		if (accountName.length() <= 4) {
			throw new AccountException(AccountException.NAME_TOO_SHORT, accountName);
		}

		if (!containsLetter(accountName)) {
			throw new AccountException(AccountException.NAME_TOO_SIMPLE, accountName);
		}
		
		if (!containsNumber(accountName)) {
			throw new AccountException(AccountException.NAME_TOO_SIMPLE, accountName);
		}
			
		this.accountName = accountName;
		
	}
	
	
	/**
	 * Returns the account name
	 * 
	 * @return the account name
	 */
	public String getName(){
		return this.accountName;
	}
}
