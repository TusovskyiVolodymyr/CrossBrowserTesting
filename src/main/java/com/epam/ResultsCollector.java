package com.epam;

public class ResultsCollector {

    private String browserName;
    private String locatorType;
    private String time;

    public ResultsCollector(String bn, String lt, String t){
        this.browserName = bn;
        this.locatorType = lt;
        this.time = t;
    }

    public synchronized void printResult(){
        System.out.println("Browser Name: " + this.browserName);
        System.out.println("Locator Type: " + this.locatorType);
        System.out.println("Time: " + this.time);
    }

}
