package app.numberparser.service.processor;

import app.numberparser.domain.model.Block;
import app.numberparser.domain.model.Step;

public class HigherOrderProcessor implements ChunkProcessor {

    private final HundredProcessor hundredProcessor = new HundredProcessor();
    private final Step step;

    public HigherOrderProcessor(Step step) {
        this.step = step;
    }

    @Override
    public String process(int chunk) {
        if (chunk == 0)
            return "";
        Block block = Block.getBlockForValue(chunk);
        if (block != null) {
            return formatText(block.getText());
        }
        return formatText(hundredProcessor.process(chunk));

    }

    private String formatText(String text) {
        return text + " " + step.getText();
    }
}
