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
        return mCourseName;
    }

    public int getCourseNumber(){
        return mCourseNumber;
    }

    public int getNumberOfCredits(){
        if (hasPassedCourse()){
            return mNumberOfCredits;
        }
        return 0;
    }

    public String getLetterGrade(){
        return mLetterGrade;
    }

    public String getAreaOfStudy(){
        return mAreaOfStudy;
    }

    public void setGPAMultiplier(){
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
        Double score = mGPAMultiplier.get(mLetterGrade);
        return score * getNumberOfCredits();
    }

    public void validateLetterGradeInput(String letterGrade){
        if (!mGPAMultiplier.containsKey(letterGrade)){
            throw new IllegalArgumentException("The only acceptable letterGrade inputs are A, A-, B+, B, B-, C+, C, C-, D+, D, D-, F");
        }
    }

    public boolean hasPassedCourse(){
        if (!mLetterGrade.equals("F")){
            return true;
        }
        return false;
    }

    public static void isValidAreaOfStudy(String areaOfStudy){
        String[] areasOfStudy = {"Math", "CS", "Liberal"};
        for (String element:areasOfStudy){
            if (element.equals(areaOfStudy)){
                return;
            }
        }
        throw new IllegalArgumentException("The only acceptable areaOfStudy inputs Math, CS, and Liberal");
    }

    public boolean isUpperLevel(){
        if (mCourseNumber >= 300){
            return true;
        } else {
            return false;
        }
    }
}


