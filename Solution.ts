
function isOneEditDistance(source: string, target: string): boolean {
    if (Math.abs(source.length - target.length) > 1) {
        return false;
    }

    const shorterInput = (source.length <= target.length) ? source : target;
    const longerInput = (source.length > target.length) ? source : target;

    let indexShorter = 0;
    let indexLonger = 0;
    let countDifferentChars = 0;

    while (indexShorter < shorterInput.length && indexLonger < longerInput.length && countDifferentChars < 2) {
        if (shorterInput[indexShorter] === longerInput[indexLonger]) {
            ++indexShorter;
            ++indexLonger;
            continue;
        }
        ++countDifferentChars;
        indexShorter += 1 ^ (longerInput.length - shorterInput.length);
        ++indexLonger;
    }

    return countDifferentChars + (longerInput.length - indexLonger) === 1;
};
