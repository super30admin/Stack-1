# Time Complexity : O(N) 
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : None

def nextGreaterElements(self, nums: List[int]) -> List[int]:
    result=[-1] *len(nums)

    stack=[]
    for i in range(2*len(nums)):
        i=i%len(nums)
        while stack and nums[stack[-1]]<nums[i]:
            popIndex=stack.pop()
            result[popIndex]=nums[i]

        if i<len(nums):
            stack.append(i)
    return result

# Approach:
# 1. Initialize a result list with -1, which will store the next greater element for each element
# 2. Initialize an empty stack
# 3. Iterate over the array twice, considering the array as circular 
# (i.e., the last element
# 4. For each element, check if the stack is not empty and the top element of the stack
# 5. If the top element of the stack is smaller than the current element, pop the
# 6. element from the stack and update the result list with the current element
# 7. Push the current index to the stack
# 8. Return the result list

        

