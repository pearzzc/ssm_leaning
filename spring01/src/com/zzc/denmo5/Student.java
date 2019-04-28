package com.zzc.denmo5;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 使用set方法进行属性的注入
 */
public class Student {
    private String name;
    private Integer age;
    //加入属性
    private Dog dog;
    //数组
    private String[] arr;
    //list
    private List myList;
    //set
    private Set mySet;
    //map
    private Map myMap;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                ", arr=" + Arrays.toString(arr) +
                ", myList=" + myList +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                '}';
    }

    public void setMySet(Set mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map myMap) {
        this.myMap = myMap;
    }

    public void setMyList(List myList) {
        this.myList = myList;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
