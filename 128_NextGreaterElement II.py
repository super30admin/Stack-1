'''
Accepted on leetcode(503)
time - O(N)
space - O(N)
Approach - similar to daily temperatures question with 3 differences.
differences:
1. Circular Array - take 2 iterations of given array.
2. If larger element is not found return -1 for that index, initialize result array with -1 at beginning.
3. Store values biut not indexes. - taken care in line 20.
'''


class Solution:
    def nextGreaterElements(self, nums):
        result = [-1 for i in range(len(nums))]  # populate with -1, 2nd difference.

        stack = []

        for x in range(len(nums) * 2):  # 1st Difference
            i = x % len(nums)
            while stack and nums[i] > nums[stack[-1]]:
                index = stack.pop()
                result[index] = nums[i]  # 3rd difference
            if result[i] == -1:
                stack.append(i)
        return result