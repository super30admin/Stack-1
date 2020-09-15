#Problem 2:https://leetcode.com/problems/next-greater-element-ii/
#Test Cases passed on Leetcode 
#Time Complexity:    O(N)
#Space Complexity:   O(N)

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        #Approach:#Approach:
        #a. Push the element in the stack if 
            #1.stack is empty
            #2.element is less than or equal to the top element 
        #b.If the element is greater than top element on that index, then pop element index till the element smaller than top element is found  or stack is empty
        result= [-1 for i in range(len(nums))]
        stack=[]
        n=len(nums)
        for i in range(2*n):
            while len(stack)>0 and nums[i%n]>nums[stack[-1]]:
                idx=stack.pop()
                #%n done since we need to traverse twice since array is circular,if we just use i , the value will be out of bounds
                result[idx]=nums[i%n]
            stack.append(i%n)
        return result
