package app.numberparser.service.processor;

import app.numberparser.domain.model.Block;
import app.numberparser.domain.util.Formatter;

import java.util.*;

import static app.numberparser.domain.model.Step.BILLION;
import static app.numberparser.domain.model.Step.MILLION;
import static app.numberparser.domain.model.Step.THOUSAND;

public class NumberProcessor {

  private static final Queue<ChunkProcessor> processors = new LinkedList<>();

  static {
    processors.add(new HigherOrderProcessor(MILLION));
    processors.add(new HigherOrderProcessor(THOUSAND));
    processors.add(new HundredProcessor());
  }

  public String process(Integer input) {
    String number = Formatter.format(input);
    if (input >= BILLION.getValue()) {
      throw new NumberFormatException(String.format("Input [%s] is too large, enter a value less than: %s ",
              number, Formatter.format(BILLION.getValue())));
    }
    if (input == 0) return Block.ZERO.getText();

    String[] chunks = number.split(",");
    Iterator<ChunkProcessor> processorIterator = processors.iterator();
    List<String> results = new ArrayList<>();
    for (String chunk : chunks) {
      ChunkProcessor processor = processorIterator.next();
      String result = processor.process(Integer.parseInt(chunk));
      if (!result.isEmpty()) {
        results.add(result);
      }
    }
    return formatResult(results);
  }

  private String formatResult(List<String> results) {
    int index = results.size() - 1;
    String lastBlock = results.get(index);
    if (!lastBlock.contains(" and ")) {
      results.add(index, " and ");
    }
    String str = results.toString();
    String processedResult = replaceBrackets(str);
    processedResult = replaceCommasAndExtraSpaces(processedResult);

    return processedResult.replaceFirst("^\\s*and\\s*", "").trim();
  }

  private String replaceCommasAndExtraSpaces(String processedResult) {
    return processedResult.replaceAll(",", "").replaceAll("\\s+", " ");
  }

  private String replaceBrackets(String str) {
    return str.replace("[", "").replace("]", "");
  }
}
