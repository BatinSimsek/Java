package Logic;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MailToolsTest {
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



    /** @subcontract no mailbox part {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[0].length < 1;
     *   @ensures \result = false;
     *   }
     */
    @Test (expected = IllegalArgumentException.class)
    public void CheckIfMailContainsAtSign () {
        //Arrange
        String email = "thomasgmail.com";

        //Act
        boolean result = MailTools.validateMailAddress(email);

        //Assert
        assertEquals(false, result);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void CheckIfMailContainsAtleastOneCharBeforeAtSign () {
        //Arrange
        String email = "@test.com";

        //Act // waarom vind print hij de exception niet, maar geeft als nog test gehaald?
        boolean result = MailTools.validateMailAddress(email);

        //Assert
        assertEquals(false, result);
    }



    /** @subcontract subdomain-tld delimiter {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[1].split(".").length > 2;
     *   @ensures \result = false;
     *   }
     */
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void ChecksIfMailContainsOnlyOneDot () {
        //Arrange
        String email = "testing@tes..com";

        //Act
        boolean result = MailTools.validateMailAddress(email);

        //Assert
        assertEquals(false, result);
    }


     /** @subcontract no subdomain part {
      *   @requires !mailAddress.contains("@") ||
      *             mailAddress.split("@")[1].split(".")[0].length < 1;
      *   @ensures \result = false;
      * }
     */
     @Test (expected = ArrayIndexOutOfBoundsException.class)
     public void ChecksAmountOfCharactersBeforeDot () {
         //Arrange
         String email = "test@.com";

         //Act
         boolean result = MailTools.validateMailAddress(email);

         //Assert
         assertEquals(false, result);
     }


    /** @subcontract no tld part {
     *   @requires !mailAddress.contains("@") ||
     *             mailAddress.split("@")[1].split(".")[1].length < 1;
     *   @ensures \result = false;
     * }
     */
     @Test (expected = ArrayIndexOutOfBoundsException.class)
        public void ChecksAmountOfCharactersAfterDot () {
            //Arrange
            String email = "test@test.m";

            //Act
            boolean result = MailTools.validateMailAddress(email);

            //Assert
            assertEquals(false, result);
     }



    /** @subcontract valid email {
     *   @requires no other precondition
     *   @ensures \result = true;
     * }
     */
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void ChecksIfMailIsValid () {
        //Arrange
        String email = "vanotterloo.thomas@gmail.com";

        //Act
        boolean result = MailTools.validateMailAddress(email);

        //Assert
        assertEquals(true, result);
    }
}
