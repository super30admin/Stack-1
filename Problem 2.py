# Time Complexity : O(n) where n is length of T
# Space Complexity :O(n) where n is length of T
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # Brute Force
        #         def uptolast(idx):
        #             for i in range(idx, len(nums)):
        #                 if nums[i] > nums[idx]:
        #                     return nums[i]
        #             return None
        #         def uptoNumber(idx):
        #             for i in range(idx+1):
        #                 if nums[i] > nums[idx]:
        #                     return nums[i]
        #             return None

        #         ans = []
        #         for i in range(len(nums)):
        #             fst = uptolast(i)
        #             if fst is not None:
        #                 ans.append(fst)
        #             else:
        #                 scnd = uptoNumber(i)
        #                 if scnd is not None:
        #                     ans.append(scnd)
        #                 else:
        #                     ans.append(-1)
        #         return ans

        stack = []
        ans = [-1] * len(nums)

        # iterating for 2 times the length
        # in the first iteration, those numbers get set which has a greater value on the right of itself
        # in the second iteration, those numbers get set which has a greater number on its left side
        # This is becuse the stack now has the numbers starting from 0 to the max numbers in the second iteration
        for i in range((2 * len(nums)) - 1, -1, -1):

            # if the first element of stack is greater than the present number than update the ans
            if stack and stack[0] > nums[i % len(nums)]:
                ans[i % len(nums)] = stack[0]

                # if the present number is greater than the first element of stack then emove elemets till greter num is foiund or the stack is empty
            elif stack and stack[0] <= nums[i % len(nums)]:
                while (stack and stack[0] <= nums[i % len(nums)]):
                    stack.pop(0)
                # if a gretaer number exists then update ans
                if stack:
                    ans[i % len(nums)] = stack[0]
                    # insert the present number in the stack
            stack.insert(0, nums[i % len(nums)])
        return ans