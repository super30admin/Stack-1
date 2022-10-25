// Time complexity: O(n^2)
// Space complexity: O(1)

// Approach: brute force. Nested iteration to find next largest element

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }
}