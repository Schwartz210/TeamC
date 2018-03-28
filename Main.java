package com.company;

public class Main {

    public static void main(String[] args) {
        StudentVersionOne s1 = new StudentVersionOne("John","CS");
	    s1.put(new Course("Name", 100, 4, "A", "CS"));
        s1.put(new Course("Name", 100, 3, "B+", "CS"));
        s1.put(new Course("Name", 100, 2, "C", "CS"));
        s1.put(new Course("Name", 100, 1, "D+", "CS"));
        System.out.println(s1.getGPA());


    }


}
