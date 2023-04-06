#All TC passed on leetcode

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:

        #Here we traverse the array and push num index into stack. 
        #If cur num is greater than top of stack we pop and add cur nums as result for poped index. 
        #To make it circular we run the loop for 2n times.
        #Time complexity: O(2n)
        #Space complexity: O(n) 
        
        res = [-1]*len(nums)
        stack = []
        n = len(nums)

        for i in range(2*n):

            if stack and i%n==stack[-1]: #optional, just ends the loop soon. 
            #If element on top of stack and i reaches same element again then no greater than element found hence return
                break
            while stack and nums[i%n]>nums[stack[-1]]:
                res[stack.pop()] = nums[i%n]
            
            if i<n:
                stack.append(i)

        return res
