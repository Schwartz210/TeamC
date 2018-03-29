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
        mCourseList = new ArrayList<>();
    }

    public void put(Course course){
        // TODO this method adds a Grade object to your collection
        mCourseList.add(course);
    }

    public boolean tookThisCourse(String courseName){
        // TODO returns bool representing if this student took this Course
        for (Course course:mCourseList){
            if (course.getCourseName().equals(courseName)){
                return true;
            }
        }
        return false;
    }

    public double getGPA(){
        // TODO returns student GPA based on collection of Grade objects
        double score = 0.0;
        double credits = 0.0;
        for (Course course:mCourseList){
            score += course.getWeightedValue();
            credits += course.getNumberOfCredits();
        }
        return score / credits;
    }

    public Course getCourse(String courseName){
        // TODO returns the appropriate Grade node
        for (Course course:mCourseList){
            if (course.getCourseName().equals(courseName)){
                return course;
            }
        }
        String message = courseName + " is not found.";
        throw new IllegalArgumentException(message);
    }

    public boolean eligibleToGraduate(){
        /** TODO returns bool representing if student has met requirements to graduate(we will define based on some
         * quantity of credits, some quantity of upper level credits, and quantity of credits in the three areaOfStudy*/
        // Must have 36 credits in major
        if (!hasCompletedMajorRequirement()){
            return false;
        }
        // Must have 120 credits total
        if (getCreditCount() < 120){
            return false;
        }
        // Must have 60 upper level credits
        if (!hasCompletedUpperLevelRequirement()){
            return false;
        }
        return true;
    }

    public int getCountMajorCredits(){
        // Returns int count of credits completed in student's major
        int credits = 0;
        for (Course course:mCourseList){
            if (course.getAreaOfStudy().equals(mMajor)){
                credits += course.getNumberOfCredits();
            }
        }
        return credits;
    }

    public boolean hasCompletedMajorRequirement(){
        // Returns bool representing if student has >= 36 credits in their major
        int credits = getCountMajorCredits();
        if (credits >= 36){
            return true;
        } else {
            return false;
        }
    }

    public int getCreditCount(){
        // TODO returns total number of credits the student has
        int credits = 0;
        for (Course course:mCourseList){
            credits += course.getNumberOfCredits();
        }
        return credits;
    }

    public int getCountUpperLevelCredits(){
        // Returns int count of upper-level credits
        int credits = 0;
        for (Course course:mCourseList){
            if (course.isUpperLevel()){
                credits += course.getNumberOfCredits();
            }
        }
        return credits;
    }

    public boolean hasCompletedUpperLevelRequirement(){
        // Returns bool if student has completed >= 60 credits of upper-level study
        int credits = getCountUpperLevelCredits();
        if (credits >= 60){
            return true;
        } else {
            return false;
        }
    }

    public String getName(){
        // Getter method for private String mName
        return mName;
    }
}
