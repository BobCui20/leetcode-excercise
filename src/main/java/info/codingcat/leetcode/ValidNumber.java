package info.codingcat.leetcode;

/**
 * ValidNumber
 */
public class ValidNumber {

    public static void main(String[] args) {
        ValidNumber v = new ValidNumber();
        System.out.println(v.isNumber(".."));
    }

    public boolean isNumber(String s) {

        s = s.trim();

        if(s.equals("0")) {
            return true;
        }

        if(s.length() == 0) {
            return false;
        }

        boolean allowSign = true;
        boolean allowFloat = true;
        boolean allowE = false;
        boolean hasE = false;
        boolean hasFloat = false;
        boolean isValidNumber = false;
        char[] chars = s.toCharArray();

        for (char c : chars) {

            if (c >= '0' && c <= '9') {
                allowSign = false;
                allowE = true;
                isValidNumber = true;
            } else if (c == '-' || c == '+') {
                if (!allowSign) {
                    return false;
                }
                isValidNumber = false;
                allowSign = false;
            } else if (c == '.') {
                if (allowFloat && !hasFloat) {
                    allowSign = false;
                    allowFloat = false;
                    hasFloat = true;
                } else {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                if (allowE && !hasE) {
                    allowE = false;
                    allowFloat = false;
                    allowSign = true;
                    hasE = true;
                    isValidNumber = false;
                } else {
                    return false;
                }
            } else {
                return false;
            }

        }

        return isValidNumber;
    }

}