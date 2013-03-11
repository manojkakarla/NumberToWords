package app.numberparser;

import app.numberparser.domain.model.Step;
import app.numberparser.service.ParserEngineImpl;

import java.util.Random;

public class MainTest {
    private static ParserEngineImpl testObj = new ParserEngineImpl();

    public static void main(String[] args) {

        executeFor(13433);
        executeFor(12000100);
        executeFor(101001001);
        executeFor(456);
        executeFor(340867);
        executeFor(400640);

        executeFor(2);
        executeFor(0);

        executeFor(8);
        executeFor(17);
        executeFor(20);
        executeFor(10);
        executeFor(90);
        executeFor(100);
        executeFor(500);
        executeFor(1000);
        executeFor(3000);
        executeFor(12000);
        executeFor(45000);
        executeFor(1000000);
        executeFor(15000000);
        executeFor(564000000);

        Random randomGenerator = new Random();
        for (int i = 0; i < 10; i++) {
            Integer random = randomGenerator.nextInt(Step.BILLION.getValue());
            executeFor(random);
        }
    }

    private static void executeFor(int number) {
        System.out.println(number + " => " + testObj.numberToWord(number));
    }
}
