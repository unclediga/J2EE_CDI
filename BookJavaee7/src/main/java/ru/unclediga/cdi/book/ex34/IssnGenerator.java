package ru.unclediga.cdi.book.ex34;


import java.util.Random;

import ru.unclediga.cdi.book.NumberGenerator;

public class IssnGenerator implements NumberGenerator {

  public String generateNumber() {
    return "8-" + Math.abs(new Random().nextInt());
  }
}