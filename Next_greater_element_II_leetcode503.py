class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # similar to 739 daily temperatures
        # Stack TC - O(n) SC - O(n)
        greatest = max(nums)
        n = len(nums)
        stack = []  # put index in stack
        output = [0 for _ in range(n)]
        for i in range(n):
            while stack and nums[i] > nums[stack[-1]]:
                idx = stack.pop()
                output[idx] = nums[i]
            if nums[i] < greatest:
                stack.append(i)
            elif nums[i] == greatest:
                output[i] = -1

        while stack:
            for i in range(n):
                while stack and nums[i] > nums[stack[-1]]:
                    idx = stack.pop()
                    output[idx] = nums[i]
        return output

    '''
            j = 0
            while stack and i == n-1:
                while stack and nums[j] < greatest and nums[j] > nums[stack[-1]]:
                    idx = stack.pop()
                    output[idx] = nums[j]
                    j += 1
                while stack:
                    idx = stack.pop()
                    output[idx] = greatest
        return output
    '''





