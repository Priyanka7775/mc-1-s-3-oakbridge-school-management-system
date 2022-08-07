package com.jap.marksevaluation;
public class OakBridgeSchool {

    public int[] calculateTotalMarks(int [] math,int science[],int[] social)
    {
        int i = 0;
        if(i < math.length && i < science.length && i < social.length){
            int[] totalMarks = new int[math.length];
            for (i = 0; i < math.length; i++) {
                totalMarks[i] = math[i] + science[i] + social[i];
            }
            return totalMarks;
        }
        else
            return null;
    }

    public int[] calculateTotalAverageMarksForEachStudent(int [] totalMarks, int noOfSubjects){
        int i = 0;
        if(i < totalMarks.length && noOfSubjects == 3) {
            int[] average = new int[totalMarks.length];
            for (i = 0; i < totalMarks.length; i++) {
                average[i] = totalMarks[i] / noOfSubjects;
            }
            return average;
        }
        else
            return null;
    }

    // Write the logic inside the method to calculate the grade based on the math mark of the student
    public char findGradeInMath(int math){
        char mathGrade = '\u0000';
        if (math >= 90){
            mathGrade ='A';
        } else if (math <= 89 && math >= 80) {
            mathGrade = 'B';
        }else if (math <= 79 && math >= 70) {
            mathGrade = 'C';
        }else if (math <= 69 && math >= 60) {
            mathGrade = 'D';
        }else {
            if (math <= 59) {
                mathGrade = 'F';
            }
        }
        return mathGrade;
    }
    // Write the logic inside the method to calculate the grade based on the science mark of the student
    public char findGradeInScience(int science){
        char scienceGrade = '\u0000';
        if (science >= 90){
            scienceGrade ='A';
        } else if (science <= 89 && science >= 80) {
            scienceGrade = 'B';
        }else if (science <= 79 && science >= 70) {
            scienceGrade = 'C';
        }else if (science <= 69 && science >= 60) {
            scienceGrade = 'D';
        }else {
            if (science <= 59) {
                scienceGrade = 'F';
            }
        }
        return scienceGrade;
    }
    // Write the logic inside the method to calculate the grade based on the english mark of the student
    public char findGradeInEnglish(int english){
        char englishGrade = '\u0000';
        if (english >= 90){
            englishGrade ='A';
        } else if (english <= 89 && english >= 80) {
            englishGrade = 'B';
        }else if (english <= 79 && english >= 70) {
            englishGrade = 'C';
        }else if (english <= 69 && english >= 60) {
            englishGrade = 'D';
        }else {
            if (english <= 59) {
                englishGrade = 'F';
            }
        }
        return englishGrade;
    }

    // Write the logic to sort the total marks of the students of the class, use insertion-sort

    public int[] sortByTotalMarks(int[] totalMarks)
    {
        int temp = 0;
        for (int i = 0; i < totalMarks.length; i++) {
            for (int j = 0; j < totalMarks.length -i -1; j++) {
                if (totalMarks[j] > totalMarks[j+1]) {
                    temp = totalMarks[j];
                    totalMarks[j] = totalMarks[j+1];
                    totalMarks[j+1] = temp;
                }
            }
        }
        return totalMarks;

    }

    //Display the details of the student
    public void displayDetails(int totalMark, int averageMark, char mathGrade, char scienceGrade, char englishGrade,String studentName, int rollNo ){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Grading and Evaluation");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Student Name                 Roll Number");
        System.out.println("---------------------------------------------------------------------");
        System.out.println(studentName+"                          "+rollNo);

        System.out.println("Total Marks Scored         : "+ totalMark);
        System.out.println("Total Average Marks Scored : "+ averageMark);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Grade in Maths   : "+ mathGrade);
        System.out.println("Grade in Science : "+ scienceGrade);
        System.out.println("Grade in English : "+ englishGrade);
        System.out.println();
        System.out.println("---------------------------------------------------------------------");


    }

    public static void main(String[] args) {

        // Declare and Initialize the object of OakBridgeSchool
        OakBridgeSchool oakBridgeSchool = new OakBridgeSchool();
        // Declare and Initialize values to the arrays to store marks of math, science, english
        int[] math = {88,89,100,70,60,80,35,3,25,56};
        int[] science = {80,83,99,67,56,84,38,9,32,65};
        int[] english = {90,98,100,65,54,82,40,13,45,67};
        // Declare and Initialize a string array for storing student names
        String[] studentName = {"Michal","Kate","Ann","Tina","Tom","Sam","Ria","Pam","Leena","Leo"};
        // Declare and Initialize an int array for storing roll numbers
        int[] rollNumber = {102,109,101,103,104,108,110,105,106,107};
        int noOfSubjects = 3;
        // Call the appropriate methods and display the results

        int [] totalMarks = oakBridgeSchool.calculateTotalMarks(math,science,english);
        int[] sorted = oakBridgeSchool.sortByTotalMarks(totalMarks);
        int [] averageMarks = oakBridgeSchool.calculateTotalAverageMarksForEachStudent(totalMarks,noOfSubjects);
        for (int i = 0; i < studentName.length ; i++) {
            char mathGrade = oakBridgeSchool.findGradeInMath(math[i]);

            char scienceGrade = oakBridgeSchool.findGradeInScience(science[i]);

            char englishGrade = oakBridgeSchool.findGradeInEnglish(english[i]);
            String studentNames = studentName[i];
            int roll = rollNumber[i];
            int totalMark = totalMarks[i];
            int average = averageMarks[i];
            oakBridgeSchool.displayDetails(totalMark,average,mathGrade,scienceGrade,englishGrade,studentNames,roll);

        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Report");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("The total marks of the class in sorted order");
        for (int i = sorted.length - 1; i >= 0; i--) {
            System.out.println(sorted[i]);
        }


    }
}
