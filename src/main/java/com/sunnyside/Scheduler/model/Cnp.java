package com.sunnyside.Scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cnp {
    private char[] cnpString;
    private Long id;
    private int sex;
    private char[] year;
    private char[] month;
    private char[] day;
    private char[] county;
    private char[] nnn;
    private int control;

    public Cnp(String input) {
        cnpString=new char[13];
        year=new char[2];
        month=new char[2];
        day=new char[2];
        county=new char[2];
        nnn=new char[3];

        cnpString=input.toCharArray();

        sex=Character.getNumericValue(cnpString[0]);

        year[0]=cnpString[1];
        year[1]=cnpString[2];
        month[0]=cnpString[3];
        month[1]=cnpString[4];
        day[0]=cnpString[5];
        day[1]=cnpString[6];
        county[0]=cnpString[7];
        county[1]=cnpString[8];
        nnn[0]=cnpString[9];
        nnn[1]=cnpString[10];
        nnn[2]=cnpString[11];

        control=Character.getNumericValue(cnpString[12]);
    }
    public void setRandomDay(){
        int rday= (int) ((Math.random() * (31 - 1)) + 1);
        char[] arr= new char[2];
        for (int j = arr.length - 1; j >= 0; j--) {
            arr[j] = (char) ('0' + (rday % 10));
            rday /= 10;
        }
        day=arr;
    }
    public void setRandomMonth(){
        int rmonth= (int) ((Math.random() * (12 - 1)) + 1);
        char[] arr= new char[2];
        for (int j = arr.length - 1; j >= 0; j--) {
            arr[j] = (char) ('0' + (rmonth % 10));
            rmonth /= 10;
        }
        month=arr;
    }
    public void setRandomYear(){
        int ryear= (int) ((Math.random() * (99)) + 0);
        char[] arr= new char[2];
        for (int j = arr.length - 1; j >= 0; j--) {
            arr[j] = (char) ('0' + (ryear % 10));
            ryear /= 10;
        }
        year=arr;
    }
    public void setRandomSex(int y){

        if(y>=1900&&y<=1999){
            sex= (int) ((Math.random() * (2-1)) + 1);
        }
        if(y>=1800&&y<=1899){
            sex= (int) ((Math.random() * (4-3)) + 3);
        }
        if(y>=2000&&y<=2099){
            sex= (int) ((Math.random() * (6-5)) + 5);
        }
    }
    public void setRandomCounty(){
        int rcounty= (int) ((Math.random() * (52 - 1)) + 1);
        char[] arr= new char[2];
        for (int j = arr.length - 1; j >= 0; j--) {
            arr[j] = (char) ('0' + (rcounty % 10));
            rcounty /= 10;
        }
        county=arr;
    }
    public void setRandomNNN(){
        int rn=(int) ((Math.random() * (999 - 1)) + 1);
        char[] arr= new char[3];
        for (int j = arr.length - 1; j >= 0; j--) {
            arr[j] = (char) ('0' + (rn % 10));
            rn /= 10;
        }
        nnn=arr;
    }
    public void fillCNPString(){
        cnpString=new char[13];
        cnpString[0]=(char)('0'+sex);
        cnpString[1]=year[0];
        cnpString[2]=year[1];
        cnpString[3]=month[0];
        cnpString[4]=month[1];
        cnpString[5]=day[0];
        cnpString[6]=day[1];
        cnpString[7]=county[0];
        cnpString[8]=county[1];
        cnpString[9]=nnn[0];
        cnpString[10]=nnn[1];
        cnpString[11]=nnn[2];
        cnpString[12]='0';
    }
    public void calculateControl(){
        char[] arr= new char[13];
        arr= cnpString;

        int comp=2*Character.getNumericValue(arr[0])+7*Character.getNumericValue(arr[1])+9*Character.getNumericValue(arr[2])+1*Character.getNumericValue(arr[3])+4*Character.getNumericValue(arr[4])+6*Character.getNumericValue(arr[5])+3*Character.getNumericValue(arr[6])+5*Character.getNumericValue(arr[7])+8*Character.getNumericValue(arr[8])+2*Character.getNumericValue(arr[9])+7*Character.getNumericValue(arr[10])+9*Character.getNumericValue(arr[11]);
        int rest=comp%11;

        if(rest<10){
            cnpString[12]=(char)('0'+rest);
        }else{
            cnpString[12]='1';
        }
        control=Character.getNumericValue(cnpString[12]);
    }
}