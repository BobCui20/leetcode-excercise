package info.codingcat.leetcode;

/**
 * AddBinary
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("111", "111"));
    }

    public String addBinary(String a, String b) {

        char[] longer = a.length() > b.length() ? a.toCharArray() : b.toCharArray();
        char[] shorter = a.length() > b.length() ? b.toCharArray() : a.toCharArray();

        int idx = longer.length - 1;
        boolean carry = false;

        while(idx >= 0) {
            char d1 = longer[idx];
            char d2 = idx - (longer.length - shorter.length) < 0 ? '0' : shorter[idx - (longer.length - shorter.length)];
            if (d1 == '1' && d2 == '1') {
                if (carry) {
                    longer[idx] = '1';
                } else {
                    longer[idx] = '0';
                    carry = true;
                }
            } else if (d1 == '1' || d2 == '1') {
                if (carry) {
                    longer[idx] = '0';
                    // carry = true;
                } else {
                    longer[idx] = '1';
                }
            } else if (d1 == '0' && d2 == '0') {
                if (carry) {
                    longer[idx] = '1';
                    carry = false;
                } else {
                    longer[idx] = '0';
                }
            }
            idx --;
        }

        if (carry) {
            char[] extended = new char[longer.length + 1];
            extended[0] = '1';
            for (int i = 0; i < longer.length; i++) {
                extended[i + 1] = longer[i];
            }
            longer = extended;
        }

        return String.valueOf(longer);

    }
}