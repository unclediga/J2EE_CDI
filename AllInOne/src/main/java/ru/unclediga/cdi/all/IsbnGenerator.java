package ru.unclediga.cdi.all;

import javax.inject.Inject;

import java.util.logging.Logger;

@ThirteenDigits
@Loggable
public class IsbnGenerator implements NumberGenerator{
	@Inject
	Logger logger;

	public String generateNumber(){
		String number = "12-123456789-12";
		logger.info("Generated ISBN "+ number);
		return number;
	}
}