package ru.unclediga.cdi.all;

import javax.inject.Inject;

import java.util.logging.Logger;

@EightDigits
@Loggable
public class IssnGenerator implements NumberGenerator{
	@Inject
	Logger logger;

	@Inject
	@EightDigits
	String prefix;

	@Inject
	@EightDigits
	int postfix;

	public String generateNumber(){
		String number = prefix + "-" + 12345678 + "-" + postfix;
		logger.info("Generated ISSN "+ number);
		return number;
	}
}