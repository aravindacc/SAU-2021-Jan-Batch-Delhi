package com.au2021.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	public boolean isInputValid(String a, String b ) {

		for(int i = 0 ; i < a.length() ; i++){
			if((a.charAt(i) >= '0' && a.charAt(i) <= '9')==false){
				// Invalid Input
				return false;
			}
		}

		for(int i = 0 ; i < b.length() ; i++){
			if((b.charAt(i) >= '0' && b.charAt(i) <= '9')==false){
				// Invalid Input
				return false;
			}
		}

		if(a.length() >= 9 || b.length() >= 9){
			// Invalid Input
			return false;
		}

		return true ;
	}

}