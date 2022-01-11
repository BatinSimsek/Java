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


    /**
     * @subcontract no mailbox part {
     * @requires !mailAddress.contains("@") ||
     * mailAddress.split("@")[0].length < 1;
     * @ensures \result = false;
     * }
     */
    @Test
    public void CheckIfMailContainsAtSign() {
        //Arrange
        String email = "thomasgmail.com";

        //Act
        boolean result = MailTools.validateMailAddress(email);

        //Assert
        assertEquals(false, result);
    }

    @Test
    public void CheckIfMailContainsAtleastOneCharBeforeAtSign() {
        //Arrange
        String email = "@test.com";

        //Act
        boolean result = MailTools.validateMailAddress(email);

        System.out.println();
        //Assert
        assertEquals(false, result);
    }


    /**
     * @subcontract subdomain-tld delimiter {
     * @requires !mailAddress.contains("@") ||
     * mailAddress.split("@")[1].split(".").length > 2;
     * @ensures \result = false;
     * }
     */
    @Test
    public void ChecksIfMailContainsMaxOneDot() {
        //Arrange
        String email = "a.broeders@student.avans.nl";

        //Act
        boolean result = MailTools.validateMailAddress(email);

        //Assert
        assertEquals(false, result);
    }


    /**
     * @subcontract no subdomain part {
     * @requires !mailAddress.contains("@") ||
     * mailAddress.split("@")[1].split(".")[0].length < 1;
     * @ensures \result = false;
     * }
     */
    @Test
    public void ChecksAmountOfCharactersBeforeDot() {
        //Arrange
        String email = "Vanotterloo.thomas@.com";

        //Act
        boolean result = MailTools.validateMailAddress(email);

        //Assert
        assertEquals(false, result);
    }


    /**
     * @subcontract no tld part {
     * @requires !mailAddress.contains("@") ||
     * mailAddress.split("@")[1].split(".")[1].length < 1;
     * @ensures \result = false;
     * }
     */
    @Test
    public void ChecksAmountOfCharactersAfterDot() {
        //Arrange
        String email = "vanotterloo.thomas@gmail.";

        //Act
        boolean result = MailTools.validateMailAddress(email);

        //Assert
        assertEquals(false, result);
    }


    /**
     * @subcontract valid email {
     * @requires no other precondition
     * @ensures \result = true;
     * }
     */
    @Test
    public void ChecksIfMailIsValid() {
        //Arrange
        String email = "vanotterloo.thomas@gmail.com";

        //Act
        boolean result = MailTools.validateMailAddress(email);

        //Assert
        assertEquals(true, result);
    }
}
