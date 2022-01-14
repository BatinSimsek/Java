package Logic;

import java.time.LocalDate;

public class DateTools {

    // Deze methode valideerd de opgegeven datum. Het accepteert geen data die in het volgende jaar of later ligt.
    public static boolean validateDate(int day, int month, int year)  {
        if(year < 1900 || year > LocalDate.now().getYear() || month <1 || month > 12  || day<1 || day > 31){
            return false;
        }
        if ((month == 2 && (day>=1 && day<= 29) && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)))){
            return true;
        }
        if ((month == 2 && (day>=1 && day<= 28)) && (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))){
            return true;
        }
        //test of de maanden 31 dagen hebben (jan, maart, mei, july, aug, oktober,dec)
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day<=31 && day>=1)){
            return true;
        }
        //test of de maanden 30 dagen hebben (April, juni, september, november)
        if ((month == 4 || month == 6 || month == 9 || month == 11) && (day<=30 && day>=1)){
            return true;
        }

        return false;

    }



}

