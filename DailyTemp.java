class Solution {
    public int[] dailyTemperatures(int[] T) {
        for (int i = 0; i < T.length; i++) {
            int val = 0;
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                val = j - i;
                break;
      }
    }
    T[i] = val;
  }
  return T;
    }
}
//SC:O(1)
//TC:O(N*N)
