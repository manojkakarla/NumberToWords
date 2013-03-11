package app.numberparser.service.processor;

import app.numberparser.domain.model.Block;
import app.numberparser.domain.model.Step;
import app.numberparser.domain.util.ProcessorHelper;

import static app.numberparser.domain.model.Block.getBlockForValue;


public class HundredProcessor implements ChunkProcessor {
    private static final Step STEP = Step.HUNDRED;
    private TenProcessor tenProcessor = new TenProcessor();

    public String process(int chunk) {
        if (chunk == 0)
            return "";
        String text = ProcessorHelper.getSimpleBlockText(chunk);
        if (text != null) {
            return text;
        }

        return processLocally(chunk, STEP.getValue());
    }

    protected String processLocally(int chunk, int stepValue) {
        StringBuilder text = new StringBuilder();
        text.append(processQuotient(chunk / stepValue));
        text.append(processRemainder(chunk % stepValue));

        return text.toString();
    }

    protected String processQuotient(int hundreds) {
        return hundreds == 0 ? "" : getBlockForValue(hundreds).getText() + " " + STEP.getText();
    }

    protected String processRemainder(int tens) {
        return tens == 0 ? "" : tenProcessor.process(tens);
    }
}
