/**
 * @author Arseniy Karmanov
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";
        int start = 0;
        int end = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
                left--;
                right++;
            }
            if (right - left - 1 > maxLen) {
                start = left + 1;
                end = right - 1;
                maxLen = right - left - 1;
            }
        }
        String substring1 = s.substring(start, end + 1);

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i + 1;
            while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
                left--;
                right++;
            }
            if (right - left - 1 > maxLen) {
                start = left + 1;
                end = right - 1;
                maxLen = right - left - 1;
            }
        }
        String substring2 = s.substring(start, end + 1);
        System.out.println(substring1.length() > substring2.length() ? substring1 : substring2);
    }
}
