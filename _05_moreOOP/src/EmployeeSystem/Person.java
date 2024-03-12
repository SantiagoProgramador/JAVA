package EmployeeSystem;

public abstract class Person {
    //Attributes
    private String name;
    private int age;
    

    //Constructors
    public Person(){}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //Methods

    //Setters and getters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //ToString
}

