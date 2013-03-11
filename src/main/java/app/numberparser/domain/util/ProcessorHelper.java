package app.numberparser.domain.util;

import app.numberparser.domain.model.Block;

public class ProcessorHelper {
    public static String getSimpleBlockText(int chunk) {
        Block block = Block.getBlockForValue(chunk);
        return block != null ? block.getText() :  null;
    }
}
