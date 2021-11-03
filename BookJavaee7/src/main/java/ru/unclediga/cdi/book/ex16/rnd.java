import java.util.Random;

public class rnd{
  public static void main(String[] args){

     // Good result  1234508   32108
     double iss = Math.abs(new Random().nextInt());
     System.out.println(String.format("var =  %5.0f",iss));
     System.out.println(String.format("var * 100 + 8 = %5.0f",iss * 100 + 8)); 

     
     System.out.println(String.format("Math...%5.0f",Math.abs(new Random().nextInt())));
/*
var * 100 + 8 = 37545003508
Exception in thread "main" java.util.IllegalFormatConversionException: f != java.lang.Integer
*/
     System.out.println(String.format("Math...*100+8 %5.0f", Math.abs(new Random().nextInt()) * 100 + 8));


  }
}
