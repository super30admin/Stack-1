//TC : O(n)
//SC : O(2n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if(temperatures == null || n == 0) return null;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int temp = stack.pop();
                result[temp] = i-temp;    
            }
            stack.push(i);
        }
        return result;
    }
    /*public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        result[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            if(temperatures[i] < temperatures[i+1]){
                result[i] = 1;
            }else{
                int cnt = 0;
                int j = i+1;
                while(j<n && temperatures[i] >= temperatures[j]){
                    j++;
                    cnt ++;
                }
                if(j==n)
                    result[i] =0;
                else
                    result[i] = cnt+1;
            }
        }
        return result;
    }*/
}
