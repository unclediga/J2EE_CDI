package ru.unclediga.cdi.all;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.enterprise.inject.Produces;

public class PostfixGenerator {
	@Inject
	Logger logger;

	@Produces
	@ThirteenDigits
	public int generatePostfix13(){
		int number = 12;
		logger.info("Generated POSTfix ISBN "+ number);
		return number;
	}

    @Produces
    @EightDigits
	public int generatePostfix8(){
		int number = 8;
		logger.info("Generated POSTfix ISSN " + number);
		return number;
	}
	
}