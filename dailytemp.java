//Time Complexity: O(N)
//Space Complexity: O(N) //Where N is the space occupied in the stack.
//Iterate over the temperature T array from N to 0.While the stack is not empty and value at i is > or equal to Temperature at the index which is the peek element in the stack and pop the element from stack
//calculate the value for ans array at i by subtracting i from the index value at the top of the stack if present else if empty assign the ans at i to 0 and push i to stack
//Return ans array
class Solution {
    public int[] dailyTemperatures(int[] T) {
        //Declare an ans array of length of T array
        int[] ans = new int[T.length];
        //Declare one stack
        Stack<Integer> stack = new Stack();
        //Iterate over the temperature T array
        for(int i=T.length-1; i>=0; --i)
        {
            //While the stack is not empty and value at i is > or equal to Temperature at the index which is the peek element in the stack
            while(!stack.isEmpty() && T[i]>=T[stack.peek()])
            {
                //pop the element
                stack.pop();
                
            }
            //if the temp at the index which is peek on stack is greater than the temperature at i then check if stack is empty if yes make ans at i 0 or else store the difference between value at peek and i at i position in ans array.
            ans[i] = stack.isEmpty()?0:stack.peek() -i;
            //Then push it into the stack.
            stack.push(i);
        }
        //Return ans
        return ans;
    }
}
//Dry run:
//T = [73,74,75,71,69,72,76,73]
//op = [1,1,4,2,1,1,0,0]
//i =    [7, 6, 5, 4, 3, 2, 1, 0]
//T =    [73,76,72,69,71,75,74,73] (from N-1 to 0)
//Stack: [(7), 6, 5, (4), (3), 2, 1] (the ones in the () gets popped)
//ans =  [ 1, 1, 4, 2, 1, 1, 0, 0]