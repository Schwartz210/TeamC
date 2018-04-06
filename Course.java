package com.company;

import java.util.HashMap;

public class Course {
    private HashMap<String, Double> mGPAMultiplier = new HashMap<>();
    private String mCourseName;
    private int mCourseNumber;
    private int mNumberOfCredits;
    private String mLetterGrade;
    private String mAreaOfStudy;
    public Course(String courseName, int courseNumber, int numberOfCredits, String letterGrade, String areaOfStudy){
        setGPAMultiplier();
        mCourseName = courseName;
        mCourseNumber = courseNumber;
        mNumberOfCredits = numberOfCredits;
        validateLetterGradeInput(letterGrade);
        mLetterGrade = letterGrade;
        isValidAreaOfStudy(areaOfStudy);
        mAreaOfStudy = areaOfStudy;
        validateLetterGradeInput(mLetterGrade);
    }

    public String getCourseName(){
        // Returns mCourseName
        return mCourseName;
    }

    public int getCourseNumber(){
        // Returns mCourseNumber
        return mCourseNumber;
    }

    public int getNumberOfCredits(){
        // Returns mNumberOfCredits or 0 if the student did not get a passing grade
        if (hasPassedCourse()){
            return mNumberOfCredits;
        }
        return 0;
    }

    public String getLetterGrade(){
        // Returns mLetterGrade
        return mLetterGrade;
    }

    public String getAreaOfStudy(){
        // Returns mAreaOfStudy
        return mAreaOfStudy;
    }

    public void setGPAMultiplier(){
        // Sets HashMap<String, Double> mGPAMultiplier which says how much each letter grade is worth
        mGPAMultiplier.put("A", 4.0);
        mGPAMultiplier.put("A-", 3.7);
        mGPAMultiplier.put("B+", 3.33);
        mGPAMultiplier.put("B", 3.0);
        mGPAMultiplier.put("B-", 2.7);
        mGPAMultiplier.put("C+", 2.3);
        mGPAMultiplier.put("C", 2.0);
        mGPAMultiplier.put("C-", 1.7);
        mGPAMultiplier.put("D+", 1.3);
        mGPAMultiplier.put("D", 1.0);
        mGPAMultiplier.put("D-", 0.7);
        mGPAMultiplier.put("F", 0.0);
    }

    public double getWeightedValue(){
        // Returns the score * getNumberOfCredits() to get the weightedValue
        Double score = mGPAMultiplier.get(mLetterGrade);
        return score * getNumberOfCredits();
    }

    public void validateLetterGradeInput(String letterGrade){
        // For validating letterGrade
        if (!mGPAMultiplier.containsKey(letterGrade)){
            throw new IllegalArgumentException("The only acceptable letterGrade inputs are A, A-, B+, B, B-, C+, C, C-, D+, D, D-, F");
        }
    }

    public boolean hasPassedCourse(){
        // Returns boolean representing if course was passed
        if (!mLetterGrade.equals("F")){
            return true;
        }
        return false;
    }

    public static void isValidAreaOfStudy(String areaOfStudy){
        // Validates areaOfStudy
        String[] areasOfStudy = {"Math", "CS", "Liberal"};
        for (String element:areasOfStudy){
            if (element.equals(areaOfStudy)){
                return;
            }
        }
        throw new IllegalArgumentException("The only acceptable areaOfStudy inputs Math, CS, and Liberal");
    }

    public boolean isUpperLevel(){
        // Returns boolean representing if course was upper level or not
        if (mCourseNumber >= 300){
            return true;
        } else {
            return false;
        }
    }
}


