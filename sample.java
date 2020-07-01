/**
Stack based solution where the indexes of the unresolved days are stored in the stack that will be popped out once we find the warmer day.

TC = 2n = O(n) where n is the num of elements
SC = O(n)
Problem-1: Daily tempratures
*/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        if(T == null || T.length == 0) return new int [0];
        
        int[] result = new int[T.length];
        
        Stack<Integer> s = new Stack();
        
        for(int i=0; i< T.length; i++){
            
            while(!s.isEmpty() && T[i] > T[s.peek()]){ // seeing if the current day is warmer than the previous day
                int index = s.pop(); // taking out the element of the previous day
                result[index] = i - index; // prev day - current warmern than prev day
            }
            
            s.push(i); // the current unresolved day
        } 
        
        return result;
        
    }
}

/**
Stack solution: Adding elements that are not resolved in the stack and popping out once the bigger number than the element in the top of the stack is found. 
TC = 3n = O(n) where n is len of nums. n + n since it is a circular array. + n to reitrate the elements once more in the stack
SC = O(n) counting num os elements in the stack
Problem-2: Next Greater Element II
*/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        if(nums == null || nums.length == 0) return new int[0];
        Stack<Integer> s = new Stack<>(); // to store the indices of the unresolved elements
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // filling resultant array with -1 so that unresolvable elements will be set to -1
        
        for(int i=0; i < 2*n; i++){ // iterating the array two times since it is a circular array
            
            while(!s.isEmpty() && nums[i%n] > nums[s.peek()]){
                int idx = s.pop();
                
                result[idx] = nums[i%n];
            }
            
           if(i < n) s.push(i);
        }
        
        return result;
        
    }
}
