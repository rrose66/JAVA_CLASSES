//****************************************************************
//* Copyright (c) 2015 Ford Motor Company. All Rights Reserved.
//****************************************************************
package com.ford.auto.business_utilitis;

import com.ford.auto.utilities.PasswordEncoder;

/**
 *
 * @author Saravanan Joghee (jsarav12)
 */
public class GenerateEncodedPassword {

	public static void main(String args[]){
		
		PasswordEncoder passwordEncode = new PasswordEncoder();
		passwordEncode.passwardEncoderMain();		
	}
}
