package Logic;

public class MailTools {

    /**
     * @desc Validates if mailAddress is valid. It should be in the form of:
     * <at least 1 character>@<at least 1 character>.<at least 1 character>
     * @subcontract no mailbox part {
     * @requires !mailAddress.contains("@") ||
     * mailAddress.split("@")[0].length < 1;
     * @ensures \result = false; X
     * }
     * @subcontract subdomain-tld delimiter {
     * @requires !mailAddress.contains("@") ||
     * mailAddress.split("@")[1].split(".").length > 2;
     * @ensures \result = false;X
     * }
     * @subcontract no subdomain part {
     * @requires !mailAddress.contains("@") ||
     * mailAddress.split("@")[1].split(".")[0].length < 1;
     * @ensures \result = false;
     * }
     * @subcontract no tld part {
     * @requires !mailAddress.contains("@") ||
     * mailAddress.split("@")[1].split(".")[1].length < 1;
     * @ensures \result = false;
     * }
     * @subcontract valid email {
     * @requires no other precondition
     * @ensures \result = true;
     * }
     */
    public static boolean validateMailAddress(String mailAddress) {

        if (mailAddress == null) {
            return false;
        }
        if (!mailAddress.contains("@")) {
            return false;
        }

        if (mailAddress.split("@")[0].length() < 1) {
            return false;
        }

        if (mailAddress.split("@")[1].split("\\.").length > 2) {
            return false;
        }

        if (mailAddress.split("@")[1].split("\\.")[0].length() < 1) {
            return false;
        }

        if (mailAddress.split("@")[1].split("\\.").length < 2) {
            return false;
        }
        return true;
    }
}