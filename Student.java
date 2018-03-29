package com.company;

public class Student {
    private String mName;
    private String mMajor;
    public Student(String name, String major){
        mName = name;
        Course.isValidAreaOfStudy(major);
        mMajor = major;
    }

    public void put(Course course){
        // TODO this method adds a Grade object to your collection
    }

    public boolean tookThisCourse(String courseName){
        // TODO returns bool representing if this student took this Course
        return true;
    }

    public double getGPA(){
        // TODO returns student GPA based on collection of Course objects
        return 0;
    }

    public Course getCourse(String courseName){
        // TODO returns the appropriate Course node
        return new Course("Default", 100, 3, "A", "CS");
    }

    public boolean eligibleToGraduate(){
        /** TODO returns bool representing if student has met requirements to graduate(we will define based on some
         * quantity of credits, some quantity of upper level credits, and quantity of credits in the three areaOfStudy*/
        // Must have 36 credits in major
        // Must have 120 credits total
        // Must have 60 upper level credits
        return true;
    }

    public int getCreditCount(){
        // TODO returns total number of credits the student has
        return 0;
    }

    public String getName(){
        // Getter method for private String mName
        return mName;
    }
}