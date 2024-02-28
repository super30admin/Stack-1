#Monotonic decreasing stack
#Time complexity = O(n)
#Space complexity = O(n)
#Did this code successfully run on Leetcode: Yes
#Any problem you faced while coding this : Yes. Incorporating 2 for loops into 1.


class Solution(object):
    def nextGreaterElements(self, nums):

        n = len(nums)
        answer = [-1] * n # Initializing list with -1 
        stack = []

        for i in range(2 * n):  #Iterating twice the list and using % to overcome index out of bound error.
            index = i % n
            while stack and nums[stack[-1]] < nums[index]:
                
                answer[stack.pop()] = nums[index]       #popping the top element 
            
            if i < n:
                stack.append(i)

        return answer
    
    