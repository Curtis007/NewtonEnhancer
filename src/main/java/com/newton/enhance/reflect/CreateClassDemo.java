package com.newton.enhance.reflect;

/**
 * Java反射
 * 类的实例对象创建
 * 
 *（1）Person.getClass
 * (2) 已知对象person.class
 *（3）Class.forName
 */
public class CreateClassDemo {

    public static void main(String[] args){
        Person person = new Person();

        //第一种表示方式--》实际在告诉我们任何一个类都有一个隐含的静态成员变量class
        Class class1 = Person.class;


        //第二种表示方式--》 已经知道该类的对象，可以通过getClass方法
        Class class2 = person.getClass();

        //第三种表示方式 --》 Class.forName 通过类全名找到
        //第三种表达方式
        Class class3 = null;
        try {
            class3 = Class.forName("com.newton.enhance.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(class1==class2);
        System.out.println(class2==class3);


        Person instance = null;
        try {
            instance = (Person) class3.newInstance();

            instance.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }



    }
}
