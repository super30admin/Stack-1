class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            if (!s.isEmpty()){
                    while(!s.isEmpty() && temperatures[i]>temperatures[s.peek()]){
                        int idx = s.pop();
                        arr[idx] = i - idx;
                    }

                
                s.push(i);
                
            }
            else{
                s.push(i);
            }
        }
        while(!s.isEmpty()){
            int idx = s.pop();
            arr[idx] = 0;
        }

        return arr;
        
    }
}