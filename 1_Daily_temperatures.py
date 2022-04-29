// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


# Algorithm

# 1. Iterate through the list.
# 2. Use a stack, append temperature for which we have to 
# find next greater elements
# 3. Compare the element at present index to top element of stack
# 4. If greater pop from stack and update the index difference in resut list
# or keep looking for next greater element.
# 5. Return result array








class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result=[0 for i in range(0,len(temperatures))]
        
        stack=[]
        stack.append(0)
        
        for n in range(1,len(temperatures)):
            
            while len(stack)>0 and temperatures[stack[-1]] < temperatures[n]:
                val=stack.pop()
                result[val]=n-val
                
            stack.append(n)
            
        return result
                
            
            
        