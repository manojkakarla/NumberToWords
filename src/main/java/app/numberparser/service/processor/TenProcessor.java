package app.numberparser.service.processor;

import app.numberparser.domain.model.Block;
import app.numberparser.domain.model.Step;
import app.numberparser.domain.util.ProcessorHelper;

import static app.numberparser.domain.model.Step.getStepForValue;

public class TenProcessor implements ChunkProcessor {
    private static final Step STEP = Step.TEN;

    @Override
    public String process(int chunk) {
        String text = ProcessorHelper.getSimpleBlockText(chunk);
        return " and " + (text != null ? text : processLocally(chunk, STEP.getValue()));
    }

    protected String processLocally(int chunk, int stepValue) {
        StringBuilder text = new StringBuilder();
        text.append(processQuotient(chunk / stepValue));
        text.append(processRemainder(chunk % stepValue));

        return text.toString();
    }

    protected String processQuotient(int tens) {
        return tens > 0 ? getStepForValue(tens * STEP.getValue()).getText() + " " : "";
    }

    protected String processRemainder(int ones) {
        return ones > 0 ? ProcessorHelper.getSimpleBlockText(ones) : "";
    }

}

