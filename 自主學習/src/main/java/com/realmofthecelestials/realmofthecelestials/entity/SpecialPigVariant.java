package com.realmofthecelestials.realmofthecelestials.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum SpecialPigVariant {
    //既然都叫特別的豬了，當然無論如何都不能有粉紅色的:)
    BLACK(0),
    RED(1),
    ORANGE(2),
    YELLOW(3),
    GREEN(4),
    BLUE(5),
    PURPLE(6),
    WHITE(7);


    private static final SpecialPigVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SpecialPigVariant::getId)).toArray(SpecialPigVariant[]::new);
    private final int id;

    SpecialPigVariant(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public static SpecialPigVariant byId(int id){
        return BY_ID[id % BY_ID.length];

    }
}
