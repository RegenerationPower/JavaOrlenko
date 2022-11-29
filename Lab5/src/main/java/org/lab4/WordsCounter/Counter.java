package org.lab4.WordsCounter;

public class Counter {

    private int maxWordsInLine = 0;
    private String maxLine = "";

    public static int getWordsInLine(String line){
        return line.split("[\\s.,:;]+").length;
    }

    public void setMaxLine(String maxLine){
        this.maxLine = maxLine;
    }

    public String getMaxLine(){
        return maxLine;
    }

    public void setMaxWordsInLine(int maxWordsInLine){
        this.maxWordsInLine = maxWordsInLine;
    }

    public int getMaxWordsInLine(){
        return maxWordsInLine;
    }

}