
import kotlin.math.abs

class Solution {
    
    fun isOneEditDistance(source: String, target: String): Boolean {
        if (abs(source.length - target.length) > 1) {
            return false
        }

        val shorterInput = if (source.length <= target.length) source else target
        val longerInput = if (source.length > target.length) source else target

        var indexShorter = 0
        var indexLonger = 0
        var countDifferentChars = 0

        while (indexShorter < shorterInput.length && indexLonger < longerInput.length && countDifferentChars < 2) {
            if (shorterInput[indexShorter] == longerInput[indexLonger]) {
                ++indexShorter
                ++indexLonger
                continue
            }
            ++countDifferentChars
            indexShorter += 1 xor (longerInput.length - shorterInput.length)
            ++indexLonger
        }

        return countDifferentChars + (longerInput.length - indexLonger) == 1
    }
}
