package arrayProblems;

public class FindTheLongestString {
    public  String findLongestString(String[] stringList) {
        // Initialize an empty string to keep track of the longest string
        String longestString = "";

        // Loop through each string in the input list
        for (String str : stringList) {
            // Check if the current string is longer than the longest one found so far
            if (str.length() > longestString.length()) {
                // If it is, update longestString to be this string
                longestString = str;
            }
        }

        // After checking all strings, return the longest one
        return longestString;
    }

}
