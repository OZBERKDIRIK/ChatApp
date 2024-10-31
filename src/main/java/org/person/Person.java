package org.person;

public class Person {
    //Person özelliklerini tutuan bir POJO sınıfıdır.

    //Bir Personın adı , soyadı olur.
    //Adı ve soyadı String özellikte olur.

    //Ad ve soyad constructor içerisinde initilaze edilmeli
    //Daha sonra get ile geri dönülebilir. Set metodu olmamalıdır

    private String name;
    private String surname;

    public Person (String name , String surname){
        this.name=name;
        this.surname=surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
