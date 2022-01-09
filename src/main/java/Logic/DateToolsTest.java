package Logic;

import org.junit.Assert;
import org.junit.Test;


public class DateToolsTest {
        /**
         * @desc Validates is a given date in the form of day, month and year is valid.
         *
         * @subcontract 31 days in month {
         *   @requires (month == 1 || month == 3 || month == 5 || month == 7 ||
         *month == 8 || month = = 10 || month == 12) && 1 <= day <= 31;
         *   @ensures \result = true;
         * }
         */

        @Test
          public void testInputRequires31Days5Months2022YearsEnsuresTrue(){

              //Arrange
                int days = 31;
                int month = 5;
                int year = 2022;
              //Act
                Boolean result = Logic.DateTools.validateDate(days, month, year);
              //Assert
            Assert.assertEquals(true, result);

          }

        @Test
        public void testInputRequires1Days5Months2022YearsEnsuresTrue(){

            //Arrange
            int days = 1;
            int month = 5;
            int year = 2022;
            //Act
            Boolean result = Logic.DateTools.validateDate(days, month, year);
            //Assert
            Assert.assertEquals(true, result);

        }

         /** @subcontract 30 days in month {
         *   @requires (month = = 4 | | month = = 6 | | month = = 9 | | month = = 11) &&
         *              1 <= day <= 30;
         *   @ensures \result = true;
         * }
         */

         @Test
         public void testInputRequires30Days4Months2022YearsEnsuresTrue(){

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
        public void testInputRequires1Days4Months2022YearsEnsuresTrue(){

            //Arrange
            int days = 1;
            int month = 4;
            int year = 2022;
            //Act
            Boolean result = Logic.DateTools.validateDate(days, month, year);
            //Assert
            Assert.assertEquals(true, result);

        }



         /** @subcontract 29 days in month {
         *   @requires month == 2 && 1 <= day <= 29 &&
         *             (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
         *   @ensures \result = true;
         * }
         */

         @Test
         public void testInputRequires29Days4Months2020YearsEnsuresTrue(){

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
        public void testInputRequires29Days4Months2000YearsEnsuresTrue(){

            //Arrange
            int days = 29;
            int month = 2;
            int year = 2000;
            //Act
            Boolean result = Logic.DateTools.validateDate(days, month, year);
            //Assert
            Assert.assertEquals(true, result);

        }

         /** @subcontract 28 days in month {
         *   @requires month == 2 && 1 <= day <= 28 &&
         *             (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0));
         *   @ensures \result = true;
         * }
         */

         @Test
         public void testInputRequires28Days2Months2001YearsEnsuresTrue(){

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
        public void testInputRequires28Days2Months1900YearsEnsuresTrue(){

            //Arrange
            int days = 28;
            int month = 2;
            int year = 1900;
            //Act
            Boolean result = Logic.DateTools.validateDate(days, month, year);
            //Assert
            Assert.assertEquals(true, result);

        }


         /** @subcontract all other cases {
         *   @requires no other accepting precondition;
         *   @ensures \result = false;
         * }
         *
         */

         // Hallo Arnom wij begrijpen niet zo goed wat met het bovenste subcontract bedoeld wordt.
        // Moeten hier testcases gemaakt worden zoals wanneer een opgegeven data meer dan 31 dagen heeft, maand meer dan 12 maanden heeft, of negatieve getallen ingevoerd zijn?

    }

