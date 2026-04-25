package solutions.p824;

public class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder sb = new StringBuilder();

            if (vowels.indexOf(word.charAt(0)) >= 0) {
                // Starts with vowel
                sb.append(word);
            } else {
                // Starts with consonant
                sb.append(word.substring(1)).append(word.charAt(0));
            }

            sb.append("ma");

            // Append 'a' repeated (i+1) times
            for (int j = 0; j <= i; j++) {
                sb.append('a');
            }

            if (i > 0) result.append(" ");
            result.append(sb);
        }

        return result.toString();
    }
}