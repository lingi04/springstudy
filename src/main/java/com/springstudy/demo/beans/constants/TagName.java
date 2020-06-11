package com.springstudy.beans.step6.constants;

public enum TagName {
    Bean("bean"),
    Property("property");

    private String value;

    TagName(String value){
        this.value = value;
    }
}
