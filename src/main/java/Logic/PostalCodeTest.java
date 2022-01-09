package Logic;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PostalCodeTest {


    /**
     * @subcontract null postalCode {
     * @requires postalCode == null;
     * @signals (NullPointerException) postalCode == null;
     */
    @Test(expected = NullPointerException.class)
    public void testformatPostalCodeRequiresNullSignalsNullPointerException() {
        //Arrange
        String zipCode = null;
        //Act
        PostalCode.formatPostalCode(null);
        //Assert
        assertEquals(null, zipCode);
    }

    /**
     * @subcontract valid postalCode {
     * @requires Integer.valueOf(postalCode.trim ().substring(0, 4)) > 999 &&
     * Integer.valueOf(postalCode.trim().substring(0, 4)) <= 9999 &&
     * postalCode.trim().substring(4).trim().length == 2 &&
     * 'A' <= postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z' &&
     * 'A' <= postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z';
     * @ensures \result = postalCode.trim().substring(0, 4) + " " +
     * postalCode.trim().substring(4).trim().toUpperCase()
     * }
     */
    @Test
    public void testformatPostalCodeRequires1234aAEnsures1234_AA() {
        //Arrange
        String postalCode = "1234aA";
        //Act
        String result = PostalCode.formatPostalCode(postalCode);
        //Assert
        assertEquals("1234 AA", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testformatPostalRequires333AB$SignalsIllegalArgumentException() {
        //Arrange
        String postalCode = "333AB";
        //Act
        String result = PostalCode.formatPostalCode(postalCode);
        //Assert
        assertEquals("333AB", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testformatPostalRequires3333A$SignalsIllegalArgumentException() {
        //Arrange
        String postalCode = "3333A";
        //Act
        String result = PostalCode.formatPostalCode(postalCode);
        //Assert
        assertEquals("3333A", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testformatPostalRequires33333AB$SignalsIllegalArgumentException() {
        //Arrange
        String postalCode = "33333AB";
        //Act
        String result = PostalCode.formatPostalCode(postalCode);
        //Assert
        assertEquals("33333 AB", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testformatPostalRequires3333ABA$SignalsIllegalArgumentException() {
        //Arrange
        String postalCode = "3333ABA";
        //Act
        String result = PostalCode.formatPostalCode(postalCode);
        //Assert
        assertEquals("3333 ABA", result);
    }

    /**
     * @subcontract invalid postalCode {
     * @requires no other valid precondition;
     * @signals (IllegalArgumentException);
     * }
     */
    @Test(expected = IllegalArgumentException.class)
    public void testformatPostalCodeRequires1234A$SignalsIllegalArgumentException() {
        //Arrange
        String postalCode = "1234A$";
        //Act
        String result = PostalCode.formatPostalCode(postalCode);
        //Assert
        assertEquals("1234A$", result);
    }

}
