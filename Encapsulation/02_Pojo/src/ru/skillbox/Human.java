package ru.skillbox;
import java.util.Scanner;

public class Human {
    private String name;
    private int age;
    private int height = new Scanner(System.in).nextInt();
    private int iq = new Scanner(System.in).nextInt();

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Human human = new Human("Amirkhan", 16);
        System.out.println(human.getName());
        System.out.println(human.getAge());
        System.out.println(human.getHeight());
        System.out.println(human.getIq());
    }

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }




}

