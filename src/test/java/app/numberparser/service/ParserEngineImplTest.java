package app.numberparser.service;

import app.numberparser.domain.model.Step;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParserEngineImplTest {

    ParserEngineImpl testObj = new ParserEngineImpl();

    @Test
    public void numberToWord() throws Exception {
        String result = testObj.numberToWord(13433);
        assertThat(result, is("Thirteen Thousand Four Hundred and Thirty Three"));
    }

    @Test
    public void testCuriousNumbers() throws Exception {
        assertThat(testObj.numberToWord(12000100), is("Twelve Million and One Hundred"));
        assertThat(testObj.numberToWord(101001001), is("One Hundred and One Million One Thousand and One"));
    }

 @Test
    public void testMoreNumbers() throws Exception {
        assertThat(testObj.numberToWord(124), is("One Hundred and Twenty Four"));
        assertThat(testObj.numberToWord(72604), is("Seventy Two Thousand Six Hundred and Four"));
    }

    @Test
    public void zero() throws Exception {
        String result = testObj.numberToWord(0);
        assertThat(result, is("Zero"));
    }

    @Test
    public void testRandom() throws Exception {
        Random randomGenerator = new Random();
        for(int i=0; i< 10; i++) {
            Integer random = randomGenerator.nextInt(Step.BILLION.getValue());
            System.out.println(random + " => " + testObj.numberToWord(random));
        }
    }

    @Test
    public void testSteps() throws Exception {
        assertThat(testObj.numberToWord(10), is("Ten"));
        assertThat(testObj.numberToWord(20), is("Twenty"));
        assertThat(testObj.numberToWord(90), is("Ninety"));
        assertThat(testObj.numberToWord(100), is("One Hundred"));
        assertThat(testObj.numberToWord(500), is("Five Hundred"));
        assertThat(testObj.numberToWord(1000), is("One Thousand"));
        assertThat(testObj.numberToWord(3000), is("Three Thousand"));
        assertThat(testObj.numberToWord(12000), is("Twelve Thousand"));
        assertThat(testObj.numberToWord(45000), is("Forty Five Thousand"));
        assertThat(testObj.numberToWord(1000000), is("One Million"));
        assertThat(testObj.numberToWord(15000000), is("Fifteen Million"));
        assertThat(testObj.numberToWord(564000000), is("Five Hundred and Sixty Four Million"));
    }

    @Test(expected = NumberFormatException.class)
    public void testVeryLargeNumber() throws Exception {
        testObj.numberToWord(2111111111);
    }
}
