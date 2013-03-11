package app.numberparser.domain.model;

import java.util.HashMap;
import java.util.Map;

public enum Step {
    TEN(10, "Ten"),
    TWENTY(20, "Twenty"),
    THIRTY(30, "Thirty"),
    FORTY(40, "Forty"),
    FIFTY(50, "Fifty"),
    SIXTY(60, "Sixty"),
    SEVENTY(70, "Seventy"),
    EIGHTY(80, "Eighty"),
    NINETY(90, "Ninety"),

    HUNDRED(TEN.getValue() * TEN.getValue(), "Hundred"),
    THOUSAND(TEN.getValue() * HUNDRED.getValue(), "Thousand"),

    MILLION(THOUSAND.getValue() * THOUSAND.getValue(), "Million"),
    BILLION(THOUSAND.getValue() * MILLION.getValue(), "Billion"),
    TRILLION(THOUSAND.getValue() * BILLION.getValue(), "Trillion");

    private static Map<Integer, Step> stepMap = new HashMap<Integer, Step>();

    static {
        for (Step step : values()) {
            stepMap.put(step.getValue(), step);
        }
    }

    private final int value;
    private final String text;

    Step(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static Step getStepForValue(int value) {
          return stepMap.get(value);
      }
}
