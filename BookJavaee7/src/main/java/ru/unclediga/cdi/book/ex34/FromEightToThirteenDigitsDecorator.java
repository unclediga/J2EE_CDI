package ru.unclediga.cdi.book.ex34;

import ru.unclediga.cdi.book.NumberGenerator;

import javax.inject.Inject;

import javax.decorator.Decorator;
import javax.decorator.Delegate;

@Decorator
public class FromEightToThirteenDigitsDecorator implements NumberGenerator{
	@Inject
	@Delegate
	private NumberGenerator numberGenerator;

	public String generateNumber(){
		String issn = numberGenerator.generateNumber();
		String isbn = "13-84356" + issn.substring(1);
		return isbn;
	}
}