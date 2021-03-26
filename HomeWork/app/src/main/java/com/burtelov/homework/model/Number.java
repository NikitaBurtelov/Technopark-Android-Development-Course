package com.burtelov.homework.model;

public class Number {
    private final String text;
    private final int color;

    Number(String text, int color) {
        this.text = text;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

}
