package app.numberparser.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserEngineImplTest {

  ParserEngineImpl testObj = new ParserEngineImpl();

  @ParameterizedTest(name = "converting {0} should display {1}")
  @MethodSource("testInputs")
  public void testcases(int number, String text) {
    assertThat(testObj.numberToWord(number), is(text));
  }

  public static Stream<Arguments> testInputs() {
    return Stream.of(
            Arguments.of(0, "Zero"),
            Arguments.of(10, "Ten"),
            Arguments.of(20, "Twenty"),
            Arguments.of(90, "Ninety"),
            Arguments.of(100, "One Hundred"),
            Arguments.of(500, "Five Hundred"),
            Arguments.of(1000, "One Thousand"),
            Arguments.of(3000, "Three Thousand"),
            Arguments.of(12000, "Twelve Thousand"),
            Arguments.of(45000, "Forty Five Thousand"),
            Arguments.of(1000000, "One Million"),
            Arguments.of(15000000, "Fifteen Million"),
            Arguments.of(564000000, "Five Hundred and Sixty Four Million"),
            Arguments.of(13433, "Thirteen Thousand Four Hundred and Thirty Three"),
            Arguments.of(12000100, "Twelve Million and One Hundred"),
            Arguments.of(101001001, "One Hundred and One Million One Thousand and One"),
            Arguments.of(124, "One Hundred and Twenty Four"),
            Arguments.of(72604, "Seventy Two Thousand Six Hundred and Four")
    );
  }

  @Test
  public void testVeryLargeNumber() {
    assertThrows(NumberFormatException.class, () -> testObj.numberToWord(2111111111));
  }
}
