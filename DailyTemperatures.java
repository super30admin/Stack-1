//Approach - 1: Brute Force
//Time Complexity : O(n^2) 
//Space Complexity : O(1)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(temperatures[j] > temperatures[i]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }
}

//Approach - 2: Monotonic Dec Stack
//Time Complexity : O(n) 
//Space Complexity : O(n)

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        
        int[] result = new int[n];
        
        //Monotonic Decreasing Stack 4,3,2,1
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int poppedIndex = st.pop();
                result[poppedIndex] = i - poppedIndex;
            }
            st.push(i);
        }
        return result;
    }
}
