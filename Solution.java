
public class Solution {

    public boolean isOneEditDistance(String source, String target) {
        if (Math.abs(source.length() - target.length()) > 1) {
            return false;
        }

        char[] shorterInput = (source.length() <= target.length()) ? source.toCharArray() : target.toCharArray();
        char[] longerInput = (source.length() > target.length()) ? source.toCharArray() : target.toCharArray();

        int indexShorter = 0;
        int indexLonger = 0;
        int countDifferentChars = 0;

        while (indexShorter < shorterInput.length && indexLonger < longerInput.length && countDifferentChars < 2) {
            if (shorterInput[indexShorter] == longerInput[indexLonger]) {
                ++indexShorter;
                ++indexLonger;
                continue;
            }
            ++countDifferentChars;
            indexShorter += 1 ^ (longerInput.length - shorterInput.length);
            ++indexLonger;
        }

        return countDifferentChars + (longerInput.length - indexLonger) == 1;
    }
}
