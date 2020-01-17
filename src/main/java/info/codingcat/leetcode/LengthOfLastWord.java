package info.codingcat.leetcode;

public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();
        System.out.println(l.lengthOfLastWord("aaa sdfdsa     "));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.isEmpty()?0:s.length() - s.lastIndexOf(" ") - 1;
    }

}