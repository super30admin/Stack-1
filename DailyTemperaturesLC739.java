class Solution {
    
    //Approach 2
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> stack = new Stack<>();
        
        int[] result = new int[temperatures.length];
        
        for(int i=temperatures.length - 1; i>=0; i--){                      //itertaing the array starting from the end
            
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]){           //check if stack is not empty and check if the temperature for the top of the stack is less than and equal to the temperature of the incoming element
                stack.pop();                                                    //if so, then pop the element out of the stack, as it's not useful as it is not the warmer day compared to the incoming element
            }
            
            if(!stack.isEmpty()){                               //check if stack is not empty
                int diff = stack.peek() - i;                    //if so, then get the index of the peek element of stack which is just warmer than the current day, and calculate the diff
                result[i] = diff;                               //update the diff in the resulting array
            }
            stack.push(i);                                      //push that day into stack
        }   
        return result;                                          //return the array
    }
    


        //Approach 1
    
//     //Time Complexity: O(n)
//     //Space Complexity: O(n)

//     public int[] dailyTemperatures(int[] temperatures) {
        
//         Stack<Integer> stack = new Stack<>();
        
//         int[] result = new int[temperatures.length];
        
//         for(int i=0; i<temperatures.length; i++){                    //iterating through array
            
//             while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){     //check if stack is not empty, and check if the top of stack's day temperature is lesser than the incoming element, means that we got the warmer day than the current day
                
//                 int index = stack.pop();                         //pop the element from stack, and calculate the diff, and update the result 
//                 int diff = i - index;
//                 result[index] = diff;
                
//             }
//             stack.push(i);                                       //push that element into stack
//         }
//         return result;
//     }
}
