package com.sunnyside.Scheduler.operations;

import com.sunnyside.Scheduler.dto.InputData;
import com.sunnyside.Scheduler.dto.PersonDTO;
import com.sunnyside.Scheduler.model.Cnp;

public class ValGen {
    public static String[] counties={"0position0","Alba","Arad","Arges","Bacau","Bihor","Bistrita-Nasaud","Botosani","Brasov","Braila","Buzau","Caras-Severin","Cluj","Constanta","Covasna","Dambovita","Dolj","Galati","Gorj","Harghita","Hunedoara","Ialomita","Iasi","Ilfov","Maramures","Mehedinti","Mures","Neamt","Olt","Prahova","Satu Mare","Salaj","Sibiu","Suceava","Teleorman","Timis","Tulcea","Vaslui","Valcea","Vrancea","Bucuresti","Bucuresti S1","Bucuresti S2","Bucuresti S3","Bucuresti S4","Bucuresti S5","Bucuresti S6","Calarasi","Giurgiu"};
    // public ArrayList<String> judetz=new ArrayList<>();

    public static String getCounty(int x){
        return counties[x];

    }
    public static boolean validate(Cnp cnp){
        char[] arr= new char[13];
        arr= cnp.getCnpString();

        int comp=2*Character.getNumericValue(arr[0])+7*Character.getNumericValue(arr[1])+9*Character.getNumericValue(arr[2])+1*Character.getNumericValue(arr[3])+4*Character.getNumericValue(arr[4])+6*Character.getNumericValue(arr[5])+3*Character.getNumericValue(arr[6])+5*Character.getNumericValue(arr[7])+8*Character.getNumericValue(arr[8])+2*Character.getNumericValue(arr[9])+7*Character.getNumericValue(arr[10])+9*Character.getNumericValue(arr[11]);
        int rest=comp%11;

        if(rest<10){
            return rest == Character.getNumericValue(arr[12]);
        }else{
            return Character.getNumericValue(arr[12]) == 1;
        }
    }
    public static Cnp generateCNP(InputData input){
        Cnp cnp=new Cnp();
        if(input.getCounty()!=null){
            for(int i=1;i<counties.length;i++){
                String ci=input.getCounty();
                String cl=counties[i];
                if(ci.equals(cl)){
                    char[] arr= new char[2];
                    for (int j = arr.length - 1; j >= 0; j--) {
                        arr[j] = (char) ('0' + (i % 10));
                        i /= 10;
                    }
                    cnp.setCounty(arr);
                    break;
                }
            }
            //errormsg
        }else{
            cnp.setRandomCounty();
        }

        cnp.setRandomNNN();

        if (input.getYear() != 0) {
            int year=input.getYear();
            char[] arr= new char[4];
            for (int j = arr.length - 1; j >= 0; j--) {
                arr[j] = (char) ('0' + (year % 10));
                year /= 10;
            }
            char[] arr2= new char[2];
            arr2[0]=arr[2];
            arr2[1]=arr[3];
            cnp.setYear(arr2);
        }else{
            cnp.setRandomYear();
        }

        if(input.getMonth()!=0){
            if(input.getMonth()>12){
                //errmesage
            }else{
                int month=input.getMonth();
                char[] arr= new char[2];
                for (int j = arr.length - 1; j >= 0; j--) {
                    arr[j] = (char) ('0' + (month % 10));
                    month /= 10;
                }
                cnp.setMonth(arr);
            }
        }else{
            cnp.setRandomMonth();
        }

        if(input.getDay()!=0){
            if(input.getDay()>31){
                //errmesage
            }else{
                int day=input.getDay();
                char[] arr= new char[2];
                for (int j = arr.length - 1; j >= 0; j--) {
                    arr[j] = (char) ('0' + (day % 10));
                    day /= 10;
                }
                cnp.setDay(arr);
            }
        }else{
            cnp.setRandomDay();
        }

        if(input.getSex()!=null){
            String sex=input.getSex();
            if(sex.equals("male")&&input.getYear()>=1900&&input.getYear()<=1999){
                cnp.setSex(1);
            }
            if(sex.equals("male")&&input.getYear()>=1800&&input.getYear()<=1899){
                cnp.setSex(3);
            }
            if(sex.equals("male")&&input.getYear()>=2000&&input.getYear()<=2099){
                cnp.setSex(5);
            }
            if(sex.equals("female")&&input.getYear()>=1900&&input.getYear()<=1999){
                cnp.setSex(2);
            }
            if(sex.equals("female")&&input.getYear()>=1800&&input.getYear()<=1899){
                cnp.setSex(4);
            }
            if(sex.equals("female")&&input.getYear()>=2000&&input.getYear()<=2099){
                cnp.setSex(6);
            }
        }else{
            cnp.setRandomSex(input.getYear());
        }
        cnp.fillCNPString();
        cnp.calculateControl();
        return cnp;
    }

    public static PersonDTO generateNames() {
        PersonDTO personDTO=new PersonDTO();
        personDTO.setName("Anita");
        personDTO.setSurname("Popescu");
        return personDTO;
    }
}