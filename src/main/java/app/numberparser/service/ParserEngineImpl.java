package app.numberparser.service;

import app.numberparser.service.processor.NumberProcessor;

public class ParserEngineImpl implements ParserEngine {
  NumberProcessor numberProcessor = new NumberProcessor();

  public String numberToWord(Integer number) {
    return numberProcessor.process(number);

  }

}
