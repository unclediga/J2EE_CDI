package ru.unclediga.cdi.all;

import javax.inject.Inject;

import java.util.logging.Logger;

@EightDigits
@Loggable
public class IssnGenerator implements NumberGenerator{
	@Inject
	Logger logger;

	public String generateNumber(){
		String number = "8-12345678";
		logger.info("Generated ISSN " + number);
		return number;
	}
}