
package main

import (
    "fmt"
    "math"
)

func isOneEditDistance(source string, target string) bool {
    if math.Abs(float64(len(source))-float64(len(target))) > 1 {
        return false
    }

    var shorterInput string
    var longerInput string

    if len(source) <= len(target) {
        shorterInput = source
        longerInput = target
    } else {
        shorterInput = target
        longerInput = source
    }

    indexShorter := 0
    indexLonger := 0
    countDifferentChars := 0

    for indexShorter < len(shorterInput) && indexLonger < len(longerInput) && countDifferentChars < 2 {
        if shorterInput[indexShorter] == longerInput[indexLonger] {
            indexShorter++
            indexLonger++
            continue
        }
        countDifferentChars++
        indexShorter += 1 ^ (len(longerInput) - len(shorterInput))
        indexLonger++
    }

    return countDifferentChars + (len(longerInput) - indexLonger) == 1
}
