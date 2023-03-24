class Solution {
    
    //Time Complexity: O(n)
    //Space Complexity: O(n)

    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        int[] result = new int[n];                          //creating the result array
        
        Stack<Integer> stack = new Stack<>();               //initialize the stack
        
        for(int i=0; i<2*n ; i++){                          //iterating the array 2 times, as it is circular
            
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]){      //check if stack is not empty and check if the stack's top element is less than the incoming elememt
                
                int index = stack.pop();                    //if so, then pop the element from the stack, add the value to that index
                result[index] = nums[i%n];
            }
            
            if(i<n){                                        //check if we are iterating through first time, because we dont't want to push the element to the second time, as we are iterating through second time because we will have some elements in the stack for which we didn't find the greater element, so for that we have to iterate through second time, but we don't want to push element for the second time
                stack.push(i);
            }
        }
        
        while(!stack.isEmpty()){                        // at last, we only have one element in the stack or multiple elements which has the same highest value, we have to initialize the -1 for those numbers 
            result[stack.pop()] = -1;
        }
        return result;
    }
}
