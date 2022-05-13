package com.dsavisualizer;

public enum Color {
    DEFAULT("\033[0m"),
    RED("\033[31m"),
    BLUE("\033[34m"),
    GREEN("\033[32m"),
    YELLOW("\033[33m");


    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}