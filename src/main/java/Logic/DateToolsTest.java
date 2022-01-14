package Logic;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;


public class DateToolsTest {
    /**
     * @desc Validates is a given date in the form of day, month and year is valid.
     * @subcontract 31 days in month {
     * @requires (month = = 1 | | month = = 3 | | month = = 5 | | month = = 7 | |
     *month = = 8 | | month = = 10 | | month = = 12) && 1 <= day <= 31;
     * @ensures \result = true;
     * }
     */

    @Test
    public void testInputRequires31Days5Months2021YearsEnsuresTrue() {

        //Arrange
        int days = 31;
        int month = 5;
        int year = 2021;
        //Act
        Boolean result = Logic.DateTools.validateDate(days, month, year);
        //Assert
        Assert.assertEquals(true, result);

    }

    @Test
    public void testInputRequires1Days5Months2021YearsEnsuresTrue() {

        //Arrange
        int days = 1;
        int month = 5;
        int year = 2021;
        //Act
        Boolean result = Logic.DateTools.validateDate(days, month, year);
        //Assert
        Assert.assertEquals(true, result);

    }

    /**
     * @subcontract 30 days in month {
     * @requires (month = = 4 | | month = = 6 | | month = = 9 | | month = = 11) &&
     * 1 <= day <= 30;
     * @ensures \result = true;
     * }
     */

    @Test
    public void testInputRequires30Days4Months2022YearsEnsuresTrue() {

        //Arrange
        int days = 30;
        int month = 4;
        int year = 2022;
        //Act
        Boolean result = Logic.DateTools.validateDate(days, month, year);
        //Assert
        Assert.assertEquals(true, result);

    }

    @Test
    public void testInputRequires1Days4Months2022YearsEnsuresTrue() {

        //Arrange
        int days = 1;
        int month = 4;
        int year = 2022;
        //Act
        Boolean result = Logic.DateTools.validateDate(days, month, year);
        //Assert
        Assert.assertEquals(true, result);

    }


    /**
     * @subcontract 29 days in month {
     * @requires month == 2 && 1 <= day <= 29 &&
     * (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
     * @ensures \result = true;
     * }
     */

    @Test
    public void testInputRequires29Days4Months2020YearsEnsuresTrue() {

        //Arrange
        int days = 29;
        int month = 2;
        int year = 2020;
        //Act
        Boolean result = Logic.DateTools.validateDate(days, month, year);
        //Assert
        Assert.assertEquals(true, result);

    }

    @Test
    public void testInputRequires29Days4Months2000YearsEnsuresTrue() {

        //Arrange
        int days = 29;
        int month = 2;
        int year = 2000;
        //Act
        Boolean result = Logic.DateTools.validateDate(days, month, year);
        //Assert
        Assert.assertEquals(true, result);

    }

    /**
     * @subcontract 28 days in month {
     * @requires month == 2 && 1 <= day <= 28 &&
     * (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0));
     * @ensures \result = true;
     * }
     */

    @Test
    public void testInputRequires28Days2Months2001YearsEnsuresTrue() {

        //Arrange
        int days = 28;
        int month = 2;
        int year = 2001;
        //Act
        Boolean result = Logic.DateTools.validateDate(days, month, year);
        //Assert
        Assert.assertEquals(true, result);

    }

    @Test
    public void testInputRequires28Days2Months1900YearsEnsuresTrue() {

        //Arrange
        int days = 28;
        int month = 2;
        int year = 1900;
        //Act
        Boolean result = Logic.DateTools.validateDate(days, month, year);
        //Assert
        Assert.assertEquals(true, result);

    }


    /**
     * @subcontract all other cases {
     * @requires no other accepting precondition;
     * @ensures \result = false;
     * }
     */

    // test of 31-dag-maanden niet meer dan 31 dagen hebben.
    @Test
    public void testInputRequires32days1months2020YearEnsuresFalse() {
        //Arrange
        int day = 32;
        int month = 1;
        int year = 2020;

        //Act
        Boolean result = Logic.DateTools.validateDate(day, month, year);

        //Assert
        Assert.assertEquals(false, result);
    }

    //test of de 30-dag-maanden geen 31 dagen hebben.
    @Test
    public void testInputRequires31days4months2020YearEnsuresFalse() {
        //Arrange
        int day = 31;
        int month = 4;
        int year = 2020;

        //Act
        Boolean result = Logic.DateTools.validateDate(day, month, year);

        //Assert
        Assert.assertEquals(false, result);

    }

    //test of februari in een niet-schrikkeljaar geen 29dagen mag hebben
    @Test
    public void testInputRequires29days2months2019YearEnsuresFalse() {
        //Arrange
        int day = 29;
        int month = 2;
        int year = 2019;

        //Act
        Boolean result = Logic.DateTools.validateDate(day, month, year);

        //Assert
        Assert.assertEquals(false, result);

    }

    @Test
    public void testInputRequires29days2months1900YearEnsuresFalse() {
        //Arrange
        int day = 29;
        int month = 2;
        int year = 1900;

        //Act
        Boolean result = Logic.DateTools.validateDate(day, month, year);

        //Assert
        Assert.assertEquals(false, result);
    }

    // tests of opgegeven dag niet kleiner mag zijn dan 1
    @Test
    public void testInputRequires0days1months2020YearEnsuresFalse() {
        //Arrange
        int day = 0;
        int month = 1;
        int year = 2020;

        //Act
        Boolean result = Logic.DateTools.validateDate(day, month, year);

        //Assert
        Assert.assertEquals(false, result);
    }

    // tests of opgegeven maand niet kleiner mag zijn dan 1
    @Test
    public void testInputRequires1days0months2019YearEnsuresFalse() {
        //Arrange
        int day = 1;
        int month = 0;
        int year = 2019;

        //Act
        Boolean result = Logic.DateTools.validateDate(day, month, year);

        //Assert
        Assert.assertEquals(false, result);
    }

    // tests of opgegeven jaar  groter niet kleiner mag zijn dan 1900
    @Test
    public void testInputRequires1Days1Months1899YearEnsuresFalse() {
        //Arrange
        int day = 1;
        int month = 1;
        int year = 1899;

        //Act
        Boolean result = Logic.DateTools.validateDate(day, month, year);

        //Assert
        Assert.assertEquals(false, result);
    }

    //test of data niet in de toekomst ligt op basis van jaar.
    @Test
    public void testInputRequiresMonth5Day15NextYearEnsuresFalse() {
        //Arrange
        int day = 15;
        int month = 5;
        int year = LocalDate.now().getYear() + 1;

        //Act
        Boolean result = Logic.DateTools.validateDate(day, month, year);

        //Assert
        Assert.assertEquals(false, result);
    }








}


