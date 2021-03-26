package com.burtelov.homework.model;

import android.graphics.Color;

import java.util.LinkedList;
import java.util.List;

public class NumberFactory {
    public static List<Number> numberList = new LinkedList<>();
    private static int countNumber = 0;

    public static int createNumber() {
        int color = countNumber % 2 == 0 ? Color.BLUE : Color.RED;
        numberList.add(factoryNumber(String.valueOf(countNumber + 1), color));

        return countNumber++;
    }

    private static Number factoryNumber(String text, int color) {
        return new Number(text, color);
    }
}
