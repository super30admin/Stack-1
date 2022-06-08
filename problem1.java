class dailyTemperatures1 {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return new int[] {};
        
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack();
        
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int top = s.pop();
                result[top] = i - top;
            }
            s.push(i);
        }
        return result;
    }
}

//time complexity O(n) where n is length of array
//space complexity O(n)