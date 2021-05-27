package com.example.helloworldspring.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataInAge {

    public static Integer dataInAge(Integer day, Integer month, Integer year) throws Exception {
        Calendar cal = GregorianCalendar.getInstance();
        int atualYear = cal.get(Calendar.YEAR);
        int atualMonth = cal.get(Calendar.MONTH)+1;
        int atualDay = cal.get(Calendar.DAY_OF_MONTH);
        if(year > atualYear || (month > 12 || month < 1) || (day > 31 || day < 1)){
            throw new Exception("Data incorreta");
        }
        int countYear = atualYear - year;
        if(countYear > 0){
            if(month > atualMonth || (month == atualMonth && day > atualDay)){
                return countYear - 1;
            }
            else{
                return countYear;
            }
        }
        else{
            return 0;
        }

    }
}
