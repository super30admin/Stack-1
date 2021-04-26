class DailyTemperatures {
    
    // Time Complexity: O(n) -- O(2n)   (where n -> length of the array)
    // Space Complexity: O(n)
    
    public int[] dailyTemperatures(int[] T) {
        // Edge Case Checking
        if(T == null || T.length == 0)
            return T;
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        // Monotonic Stack Concept
        for(int i = 0; i < T.length; i++){
            // If the current element is greater the element at stack peek - then update the index difference for the stack peek element in the result array
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                int index = stack.peek();
                result[index] = i - index;
                stack.pop();
            }
            // Push the current index on the stack
            stack.push(i);
        }
        return result;
    }
}