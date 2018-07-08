package com.learncamel.bean;

public class CamelFileModifyBean {

    //it can be any method name with single parameter/argument which going take the input from previous component

    public String mapValue(String inputValueFromPreviousComponent){

        System.out.println("Ran mapValue");
        return inputValueFromPreviousComponent.replaceAll(","," & ");
    }

    public String mapValueSecondMethod(String inputValueFromPreviousComponent){

        System.out.println("Ran mapValueSecondMethod");
        return inputValueFromPreviousComponent.replaceAll("&","-");
    }
}
