package xupt.se.ttms.service;

import java.util.Map;
/**
 * This interface offered to confirm the information of user.
 * @author Aligreat
 *
 */
public interface LoginDataAffirm {
	
	/**
	 * Implements this method to confirm the data of user's account and password,
	 * connect to database and affirm the validly of data, before that, data 
	 * should be checked, if data is illegal it will not connect to database and
	 * return the consequence directly.
	 * 
	 * Following is the legality of the account and password:
	 * 
	 * Legality of account:
	 * Account should consist of letters like 'A'~'Z' and 'a'~'z',and cannot use
	 * any numbers or signs.
	 * At most use 16 letters to consist account.
	 * 
	 * Legality of password:
	 * Password can use any characters in keyboard besides space sign like the
	 * blank character or the enter character.
	 * At least use 6 characters and at most use 16 characters to consist password.
	 * 
	 * 
	 * @param userData
	 * Contained two object which are "account" and "password", these two object
	 * should be checked.
	 * 
	 * @return
	 * If data is legal and correct, return true, whereas return false.
	 */
	abstract public boolean dataAffirm(Map<String, String> userData);
	
	
	
	/**
	 * This method is used to confirm the department of the login successful user.
	 * 
	 * @param userData
	 * Contained two object which are "account" and "password", these two object
	 * should be checked.
	 * 
	 * @return
	 * Return String type variables from database which is the department of user.
	 */
	abstract public String departmentAffirm(Map<String, String> userData);

}