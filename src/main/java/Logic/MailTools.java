package Logic;

public class MailTools {

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
    public static boolean validateMailAddress(String mailAddress){
        checksIfInputNull(mailAddress);

        CheckIfMailContainsAtSign(mailAddress);

        CheckIfMailContainsAtleastOneCharBeforeAtSign(mailAddress);

        subdomainTldDelimiter(mailAddress);

        noSubdomainPart(mailAddress);

        noTldPart(mailAddress);



        return true;
    }

    private static void noTldPart(String mailAddress) {
        if (mailAddress.split("@")[1].split(".")[1].length() < 1) {
            throw new ArrayIndexOutOfBoundsException("Minimaal 2 letters na de punt!");
        }
    }

    private static void noSubdomainPart(String mailAddress) {
        if (mailAddress.split("@")[1].split("\\.")[0].length() < 1) {
            throw new ArrayIndexOutOfBoundsException("Minimaal 2 letters voor de punt!");
        }
    }

    private static void subdomainTldDelimiter(String mailAddress) {
        if (mailAddress.split("@")[1].split("\\.").length > 2) {
            throw new ArrayIndexOutOfBoundsException("Minimaal 3 letters na de punt!");
        }
    }

    private static void CheckIfMailContainsAtSign(String mailAddress) {
        if (!mailAddress.contains("@")) {
            throw new IllegalArgumentException("Bevat geen '@'");
        }
    }

    private static void CheckIfMailContainsAtleastOneCharBeforeAtSign(String mailAddress) {
        if (mailAddress.split("@")[0].length() < 1) {
            throw new ArrayIndexOutOfBoundsException("Minimaal 1 letter voor de @!");
        }
    }

    private static void checksIfInputNull(String mailAddress) {
        if (mailAddress == null) {
            throw new NullPointerException("Vul eerst een geldig email in.");
        }
    }

}