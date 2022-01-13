# Time: O(n)
# Space: O(n)
class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = [-1] * len(nums)
        stack = []
        i = 1
        stack.append(0)
        n = len(nums)
        while i < 2*len(nums):
            if nums[stack[-1]%n] >= nums[i%n]:
                stack.append(i)
            else:
                #print(stack[-1], i)
                while len(stack) != 0 and nums[stack[-1]%n] < nums[i%n]:
                    curr = stack.pop()%n
                    #print(curr, i)
                    ans[curr] = nums[i%n]
                stack.append(i)
            i += 1
        return ans
            
        
