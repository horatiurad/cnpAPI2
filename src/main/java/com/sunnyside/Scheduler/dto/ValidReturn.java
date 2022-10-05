package com.sunnyside.Scheduler.dto;

import com.sunnyside.Scheduler.model.Cnp;
import com.sunnyside.Scheduler.operations.ValGen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidReturn {
    private String sex;
    private char[] birthdate;
    private String county;
    public ValidReturn(String cnp) {

    }

    public ValidReturn(Cnp cnp) {
        char[] arr= new char[13];
        arr= cnp.getCnpString();
        if(arr[0]=='1'||arr[0]=='3'||arr[0]=='5'||arr[0]=='7'){
            sex="male";
        }
        if(arr[0]=='2'||arr[0]=='4'||arr[0]=='6'||arr[0]=='8'){
            sex="female";
        }
        int x=Character.getNumericValue(arr[7])*10+Character.getNumericValue(arr[8]);
        county= ValGen.getCounty(x);
        int year=Character.getNumericValue(arr[1])*10+Character.getNumericValue(arr[2]);
        int month=Character.getNumericValue(arr[3])*10+Character.getNumericValue(arr[4]);
        int day=Character.getNumericValue(arr[5])*10+Character.getNumericValue(arr[6]);
        birthdate=new char[8];
        birthdate[0]=arr[5];
        birthdate[1]=arr[6];
        birthdate[2]='/';
        birthdate[3]=arr[3];
        birthdate[4]=arr[4];
        birthdate[5]='/';
        birthdate[6]=arr[1];
        birthdate[7]=arr[2];
    }
}