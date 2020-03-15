// Time Complexity : O(n^2) where n is the length of array T
// Space Complexity : O(n) where n is the length of array T
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class dailyTemperatures_BruteForce {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        if (T.length == 0) return ans;
        for (int i = 0; i < T.length; i++) {
            int j = i + 1;
            int count = 1;
            while (j < T.length && T[j] <= T[i]) {
                count++;
                j++;
            }
            if (j == T.length) ans[i] = 0;
            else ans[i] = count;
        }
        return ans;
    }
}