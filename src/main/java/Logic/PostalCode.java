package Logic;

public class PostalCode {

    /**
     * @desc Formats the input postal code to a uniform output in the form
     * nnnn<space>MM, where nnnn is numeric and > 999 and MM are 2 capital letters.
     * Spaces before and after the input string are trimmed.
     *
     * @subcontract null postalCode {
     *   @requires postalCode == null;
     *   @signals (NullPointerException) postalCode == null;
     * }
     *
     * @subcontract valid postalCode {
     *   @requires Integer.valueOf(postalCode.trim().substring(0, 4)) > 999 &&
     *             Integer.valueOf(postalCode.trim().substring(0, 4)) <= 9999 &&
     *             postalCode.trim().substring(4).trim().length == 2 &&
     *             'A' <= postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z' &&
     *             'A' <= postalCode.trim().substring(4).trim().toUpperCase().charAt(0) <= 'Z';
     *   @ensures \result = postalCode.trim().substring(0, 4) + " " +
     *                  postalCode.trim().substring(4).trim().toUpperCase()
     * }
     *
     * @subcontract invalid postalCode {
     *   @requires no other valid precondition;
     *   @signals (IllegalArgumentException);
     * }
     *
     */
    public static String formatPostalCode(/* non_null */ String postalCode) throws IllegalArgumentException, NullPointerException {

        if (postalCode == null) {
            throw new NullPointerException("Geen postcode ingevoerd");
        }

        String validZipCode = postalCode.replaceAll("\\W", "").trim();

        try {
            int postalcodeNumbers = Integer.valueOf(validZipCode.substring(0,4));
            String postalcodeLetters = validZipCode.substring(4).toUpperCase();

            char firstLetter = postalcodeLetters.charAt(0);
            char secondLetter = postalcodeLetters.charAt(1);

            if (postalcodeNumbers > 999 && postalcodeNumbers <= 9999 && postalcodeLetters.length() == 2 && ('A' <= firstLetter && firstLetter <= 'Z') && ('A' <= secondLetter && secondLetter <= 'Z') ){
                return String.format("%s %s", validZipCode.substring(0,4), validZipCode.trim().substring(4).toUpperCase());
            } else {
                throw new IllegalArgumentException("De ingevulde postcode is incorrect");
            }

        }catch (Exception e){
            throw new IllegalArgumentException("De ingevulde postcode is incorrect");
        }
    }
}
