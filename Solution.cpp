
#include <cmath>
#include <string>
using namespace std;

class Solution {
    
public:
    bool isOneEditDistance(const string& source, const string& target) const {
        if (abs(static_cast<int>(source.length()) - static_cast<int>(target.length())) > 1) {
            return false;
        }

        string shorterInput = (source.length() <= target.length()) ? source : target;
        string longerInput = (source.length() > target.length()) ? source : target;

        int indexShorter = 0;
        int indexLonger = 0;
        int countDifferentChars = 0;

        while (indexShorter < shorterInput.length() && indexLonger < longerInput.length() && countDifferentChars < 2) {
            if (shorterInput[indexShorter] == longerInput[indexLonger]) {
                ++indexShorter;
                ++indexLonger;
                continue;
            }
            ++countDifferentChars;
            indexShorter += 1 ^ (longerInput.length() - shorterInput.length());
            ++indexLonger;
        }

        return countDifferentChars + (longerInput.length() - indexLonger) == 1;
    }
};
