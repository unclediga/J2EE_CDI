package ru.unclediga.cdi.all;

import javax.enterprise.inject.Alternative;

@Alternative
@Loggable
@ThirteenDigits
public class MockGenerator implements NumberGenerator{
	public String generateNumber(){
		return "MOCK-1123456789";
	}
}