# Problem2 Next Greater Element II (https://leetcode.com/problems/next-greater-element-ii/)
# // Time Complexity :O(2N) = O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
class Solution:
    def nextGreaterElements(self, nums):
        n = len(nums)
        # using stack
        stack = []
        # creating result list
        result = [-1] * n
        # iterating over the array twice coz rotaional
        for i in range(2 * n):
            # till the curr temp is greater than last element in stack keep popping
            while stack and nums[stack[-1]] < nums[i % n]:
                result[stack.pop()] = nums[i % n]
            if i < n:
                stack.append(i)
        return result


sol = Solution()
print(sol.nextGreaterElements([1, 2, 1]))
