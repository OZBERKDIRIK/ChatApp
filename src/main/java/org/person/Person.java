package org.person;

public class Person {
    //Person özelliklerini tutuan bir POJO sınıfıdır.

    //Bir Personın adı , soyadı olur.
    //Adı ve soyadı String özellikte olur.

    //Ad ve soyad constructor içerisinde initilaze edilmeli
    //Daha sonra get ile geri dönülebilir. Set metodu olmamalıdır

    private String name;
    private String surname;

    private  static int personID=0;
    public Person (String name , String surname){
        this.name=name;
        this.surname=surname;
        personID++;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public static int getPersonID(){
        return personID;
    }
}
