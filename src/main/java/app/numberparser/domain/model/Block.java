package app.numberparser.domain.model;

import java.util.HashMap;
import java.util.Map;

public enum Block {
    ZERO(0, "Zero"),
    ONE(1, "One"),
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    SIX(6, "Six"),
    SEVEN(7, "Seven"),
    EIGHT(8, "Eight"),
    NINE(9, "Nine"),
    TEN(10, "Ten"),

    ELEVEN(11, "Eleven"),
    TWELVE(12, "Twelve"),
    THIRTEEN(13, "Thirteen"),
    FOURTEEN(14, "Fourteen"),
    FIFTEEN(15, "Fifteen"),
    SIXTEEN(16, "Sixteen"),
    SEVENTEEN(17, "Seventeen"),
    EIGHTEEN(18, "Eighteen"),
    NINETEEN(19, "Nineteen");

    private final int value;
    private final String text;

    private static Map<Integer, Block> blockMap = new HashMap<Integer, Block>();

    static {
        for (Block block : values()) {
            blockMap.put(block.getValue(), block);
        }
    }

    Block(int value, String text) {
        this.value = value;
        this.text = text;
    }


    public int getValue() {
        return value;
    }


    public String getText() {
        return text;
    }

    public static Block getBlockForValue(int value) {
        return blockMap.get(value);
    }
}
