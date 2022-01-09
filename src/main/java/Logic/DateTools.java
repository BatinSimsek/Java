package Logic;

public class DateTools {
    /**
     * @desc Validates if mailAddress is valid. It should be in the form of:
     *       <at least 1 character>@<at least 1 character>.<at least 1 character>
     *
     * @subcontract no mailbox part {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[0].length < 1;
     *   @ensures \result = false;
     * }
     *
     * @subcontract subdomain-tld delimiter {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[1].split(".").length > 2;
     *   @ensures \result = false;
     * }
     *
     * @subcontract no subdomain part {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[1].split(".")[0].length < 1;
     *   @ensures \result = false;
     * }
     *
     * @subcontract no tld part {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[1].split(".")[1].length < 1;
     *   @ensures \result = false;
     * }
     *
     * @subcontract valid email {
     *   @requires no other precondition
     *   @ensures \result = true;
     * }
     *
     */
    public static boolean validateDate(int day, int month, int year)  {
        //test of de maanden 31 dagen hebben (jan, maart, mei, july, aug, oktober,dec)
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day<=31 && day>=1)){
            return true;
        }
        //test of de maanden 30 dagen hebben (April, juni, september, november)
        if ((month == 4 || month == 6 || month == 9 || month == 11) && (day<=31 && day>=1)){
            return true;
        }
        if ((month == 2 && (day>=1 && day<= 29) && (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)))){
            return true;
        }
        if ((month == 2 && (day>=1 && day<= 29)) && (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0))){
            return true;
        }
        return false;

    }



}

