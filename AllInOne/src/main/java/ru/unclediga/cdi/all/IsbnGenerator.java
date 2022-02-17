package ru.unclediga.cdi.all;

import javax.inject.Inject;

import java.util.logging.Logger;

@ThirteenDigits
@Loggable
public class IsbnGenerator implements NumberGenerator{
	@Inject
	Logger logger;

	@Inject
	@ThirteenDigits
	String prefix;

	@Inject
	@ThirteenDigits
	int postfix;

	public String generateNumber(){
		String number = prefix + "-" + 123456789 + "-" + postfix;
		logger.info("Generated ISBN "+ number);
		return number;
	}
}