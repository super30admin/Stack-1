// Time Complexity : O(n*n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



# Algorithm

# 1. Iterate through the list.
# 2. Use a stack, append temperature for which we have to 
#    find next greater elements in circular so we search in space of 
#    2 times length of array
# 3. Compare the element at present index to top element of stack
# 4. If greater pop from stack and update the index difference in resut list
# or keep looking for next greater element.
# 5. Return result array


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n=len(nums)
        result = [-1 for i in range(0,n)]
        
        for i in range(0,n):
            j=i+1
            while(j<2*n):
                if j%n !=i and nums[i]<nums[j%n]:
                    result[i]=nums[j%n]
                    break
                else:
                    j=j+1
        return result
            
        

// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No





class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n=len(nums)
        result = [-1 for i in range(0,n)]
        
        stack=[]
        for x in range(0,2*n):
            
            index=x%n
            
            
            while( len(stack)>0 and nums[stack[-1]] <nums[index]):
                result[stack.pop()]=nums[index]
                
            if x<n:
                stack.append(x)        
                
                
        return result
            
        
            



            