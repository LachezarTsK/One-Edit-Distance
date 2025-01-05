
using System;

public class Solution
{
    public bool IsOneEditDistance(string source, string target)
    {
        if (Math.Abs(source.Length - target.Length) > 1)
        {
            return false;
        }

        char[] shorterInput = (source.Length <= target.Length) ? source.ToCharArray() : target.ToCharArray();
        char[] longerInput = (source.Length > target.Length) ? source.ToCharArray() : target.ToCharArray();

        int indexShorter = 0;
        int indexLonger = 0;
        int countDifferentChars = 0;

        while (indexShorter < shorterInput.Length && indexLonger < longerInput.Length && countDifferentChars < 2)
        {
            if (shorterInput[indexShorter] == longerInput[indexLonger])
            {
                ++indexShorter;
                ++indexLonger;
                continue;
            }
            ++countDifferentChars;
            indexShorter += 1 ^ (longerInput.Length - shorterInput.Length);
            ++indexLonger;
        }

        return countDifferentChars + (longerInput.Length - indexLonger) == 1;
    }
}
