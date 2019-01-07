package com.jb.controller.text;

public  abstract  class Decorator  implements    Person {


    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void eat() {
        person.eat();
    }

}