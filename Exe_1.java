class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] r = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<n; ++i){
            while(!s.isEmpty()){
                if(temperatures[s.peek()]< temperatures[i]){
                    int j = s.pop();
                    r[j] = i-j;
                } else {
                    break;
                }
            }
            s.push(i);
        }
        return r;
    }
}
//tc=O(n);
//sc=O(n);
