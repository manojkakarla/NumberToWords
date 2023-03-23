package app.numberparser;

import app.numberparser.service.ParserEngineImpl;

public class Main {
  private static final ParserEngineImpl converter = new ParserEngineImpl();

  public static void main(String[] args) {
    if (args.length < 1) {
      throw new IllegalArgumentException("Please enter a number under a billion to convert");
    }
    int number = extractNumber(args[0]);
    System.out.println(number + " => " + converter.numberToWord(number));
  }

  private static int extractNumber(String arg) {
    try {
      return Integer.parseInt(arg.trim().replaceAll("[,_]", ""));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid input: " + arg);
    }
  }
}
