/**
Leet Code Submitted : Yes
Time Complexity : O(2N) //While loops runs for max once on the elements
Space Complexity : O(N)

The idea is to use stack to store array index. At each iteration we will check recursively(while loop) stack peek index temperature and see if its less than current index temperature. If this condition satisfies update result index. At the end just add it to stack the current index.
**/
class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        Stack<Integer> s = new Stack<>();
        int[] result = new int[T.length];
        
        if(T == null || T.length < 2)
            return result;
        
        //Pushing first index of stack
        s.push(0);
        
        for(int i =1; i<T.length;i++){
            //Checking if stack value is greater or eqaul than current Temp (Do Nothing)
            if(T[s.peek()] >= T[i]){
                s.push(i);
            }else {
            //Checking if stack value is less than current Temp (Pop and update index of result)
                    while(!s.isEmpty() && T[s.peek()] < T[i]){
                        int curr = s.pop();
                        result[curr] = i - curr;     
                    }
                    s.push(i);
                }
        }
                
        return result;
    }
}
