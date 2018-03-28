package com.company;

import java.util.ArrayList;

public class StudentVersionOne {
    private String mName;
    private String mMajor;
    private ArrayList<Course> mCourseList;
    public StudentVersionOne(String name, String major){
        mName = name;
        Course.isValidAreaOfStudy(major);
        mMajor = major;
        mCourseList = new ArrayList<Course>();
    }

    public void put(Course course){
        // TODO this method adds a Grade object to your collection
        mCourseList.add(course);
    }

    public boolean tookThisCourse(String courseName){
        // TODO returns bool representing if this student took this Course
        return true;
    }

    public double getGPA(){
        // TODO returns student GPA based on collection of Grade objects
        double score = 0.0;
        double credits = 0;
        for (Course course:mCourseList){
            score += course.getWeightedValue();
            credits += course.getNumberOfCredits();
        }
        return score / credits;
    }

    public Course getGrade(String courseName){
        // TODO returns the appropriate Grade node
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

    public boolean hasCompletedRequirement(String areaOfStudy){
        /** TODO returns bool representing if student has enough credits in a given area. This is a helper function for
         * method eligibleToGraduate(). Also prints how many credits student has in this area, and how many more is required*/
        return true;
    }

    public int getCreditCount(){
        // TODO returns total number of credits the student has
        return 0;
    }
}
