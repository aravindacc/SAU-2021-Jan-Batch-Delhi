package com.assignment.service;

import com.assignment.resultgenrator.Acknowledgement;
import com.assignment.resultgenrator.StudentRequest;
import org.springframework.stereotype.Service;

@Service
public class ResultGeneratorService {

    public Acknowledgement getResult(StudentRequest request){
        Acknowledgement acknowledgement=new Acknowledgement();
        float tmarks=request.getTotalMarks();
        float marks=request.getTotalMarksObtained();
        float score=(marks/tmarks)*100;
        String grades="";
        String result="";
        if(score>=90){
            grades="A";
            result="Pass";
        }
        else if (score<90 && score>=60){
            grades="B";
            result="Pass";
        }
        else if (score<60 && score>=30){
            grades="C";
            result="Pass";
        }
        else{
            grades="F";
            result="Fail";
        }
        acknowledgement.setResult(result);
        acknowledgement.setGrade(grades);
        return acknowledgement;
    }
}
