package ru.unclediga.cdi.all;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.enterprise.inject.Produces;

public class PrefixGenerator {

	@Inject
	Logger logger;

	@Produces
	@ThirteenDigits
	public String generatePrefix13(){
		String number = "12";
		logger.info("Generated PREfix ISBN "+ number);
		return number;
	}

    @Produces
    @EightDigits
	public String generatePrefix8(){
		String number = "8";
		logger.info("Generated PREfix ISSN " + number);
		return number;
	}
	
}