# Time Complexity:O(3n)
# Space Complexity:O(n)
# Did this code successfully run on Leetcode :Yes
# Approach: loop for 2n times and compare the incoming value with top of the stack, if greater, then pop the index and put the incoming value to the result array at popped index, add to stack else if loop for n has completed, dont add to stack 


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        #stack initialization
        dq = deque()
        n = len(nums)
        #dummy -1 values
        res = [-1]* len(nums)
        #loop for 2n times
        for i in range(2*len(nums)):
            #if stack is empty
            if not dq:
                dq.append(i)
            # if stack is not empty
            while dq and nums[dq[-1]]<nums[i%n]:
                #get the index to be resolved
                idx = dq.pop()
                #update the res array
                res[idx] = nums[i%n]
                
            #if looping for once
            if i<n:
                dq.append(i)
        return res


        