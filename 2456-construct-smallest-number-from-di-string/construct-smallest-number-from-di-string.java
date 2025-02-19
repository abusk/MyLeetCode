class Solution {

    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();

        // Start building the sequence by calling the helper function
        buildSequence(0, 0, pattern.toCharArray(), result);
        // Reverse the final result
        return result.reverse().toString();
    }

    // Recursively build the sequence
    int buildSequence(
        int currentIndex,
        int currentCount,
        char[] patternArray,
        StringBuilder result
    ) {
        if (currentIndex != patternArray.length) {
            if (patternArray[currentIndex] == 'I') buildSequence(
                // If 'I', increment the count and move to the next index
                currentIndex + 1,
                currentIndex + 1,
                patternArray,
                result
            );
            else currentCount = buildSequence(
                // If 'D', keep the count and move to the next index
                currentIndex + 1,
                currentCount,
                patternArray,
                result
            );
        }

        result.append(currentCount + 1);
        // Return the next count for the sequence
        return currentCount + 1;
    }
}