
public class Solution {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
	}
	public static String longestPalindrome(String s) {//solves with an O(n) complexity
		if (s == null || s.length() < 1) return "";
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("#");
			sb.append(s.charAt(i));
		}
		sb.append("#");
		String t = sb.toString();
		int[] p = new int[t.length()];
		int center = 0, rightBoundary = 0;
		for (int i = 0; i < t.length(); i++) {
			int mirror = 2 * center - i;
			p[i] = (rightBoundary > i) ? Math.min(rightBoundary - i, p[mirror]) : 0;
			int left = i - (1 + p[i]);
			int right = i + (1 + p[i]);
			while (left >= 0 && right < t.length() && t.charAt(left) == t.charAt(right)) {
				p[i]++;
				left--;
				right++;
			}
			if (i + p[i] > rightBoundary) {
				center = i;
				rightBoundary = i + p[i];
			}
		}
		int maxLen = 0, centerIndex = 0;
		for (int i = 0; i < p.length; i++) {
			if (p[i] > maxLen) {
				maxLen = p[i];
				centerIndex = i;
			}
		}
		return s.substring((centerIndex - maxLen) / 2, (centerIndex + maxLen) / 2);

	}
}
