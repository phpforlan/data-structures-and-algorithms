package com.imooc.data.structure.array;

public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {

        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();

        arr.addLast(new Student("alice", 100));
        arr.addLast(new Student("bob",66));

        System.out.println(arr);

    }
}
