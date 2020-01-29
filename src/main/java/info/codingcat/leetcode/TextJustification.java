package info.codingcat.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * TextJustification
 */
public class TextJustification {

    public static void main(String[] args) {
        TextJustification t = new TextJustification();
        for (String s : t.fullJustify(new String[] {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20)) {
            System.out.println("[" + s + "]");
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedText = new ArrayList<>();
        StringBuilder curr = null;
        int currLen = 0;
        int numOfWords = 0;
        int start = 0;

        for (int i = 0; i < words.length; i++) {
            // numOfWords - 1 ====> accounting at least one space between words
            if (currLen + (numOfWords - 1) + words[i].length() >= maxWidth) {
                curr = new StringBuilder();

                // Handle the case the numOfWords = 1;
                if (numOfWords == 1) {
                    curr.append(words[start]).append(space(maxWidth - currLen));
                } else {
                    int spaceAtEach = (maxWidth - currLen) / (numOfWords - 1);
                    int extra = (maxWidth - currLen) % (numOfWords - 1);
                    for (int j = start; j < i; j++) {
                        curr.append(words[j]);
                        if (j != i - 1) {
                            curr.append(space(spaceAtEach + (extra-- > 0 ? 1 : 0)));
                        }
                    }
                }
                justifiedText.add(curr.toString());
                start = i;
                currLen = 0;
                numOfWords = 0;
            }
            numOfWords++;
            currLen += words[i].length();

        }

        if (currLen != 0) {
            curr = new StringBuilder();
            for (int i = start; i < words.length; i++) {
                curr.append(words[i]);
                if (i != words.length - 1) {
                    curr.append(" ");
                    currLen++;
                } else {
                    curr.append(space(maxWidth - currLen));
                }
            }
            justifiedText.add(curr.toString());
        }

        return justifiedText;
    }

    public String space(int i) {
        StringBuilder s = new StringBuilder();
        while (i-- > 0) {
            s.append(" ");
        }
        return s.toString();
    }

}