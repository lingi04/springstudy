package com.springstudy.demo.beans;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 한개 이상의 PropertyValue 객체를 가지고 있는 홀더이다.
 * 일반적으로 특정 대상 빈에 대한 하나의 업데이트로 구성된다.
 */
public class PropertyValues implements Iterable<PropertyValue> {
    private final List<PropertyValue> propertyValueList;

    public PropertyValues(){
        propertyValueList = new ArrayList<>();
    }

    public PropertyValues(List<PropertyValue> propertyValueList) {
        this.propertyValueList = propertyValueList;
    }

    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }
    @Override
    public Spliterator<PropertyValue> spliterator() {
        return Spliterators.spliterator(getPropertyValues(), 0);
    }

    Stream<PropertyValue> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    PropertyValue[] getPropertyValues() {
        return null;
    }

    PropertyValue getPropertyValue(String propertyName){
        return null;
    }

    PropertyValues changesSince(PropertyValues old){
        return null;
    }

    boolean contains(String propertyName) {
        return false;
    }
    boolean isEmpty() {
        return false;
    }
}
