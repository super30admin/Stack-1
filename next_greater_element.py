# Time complexity: O(n)
# Space complexity: O(n)

def nextGreaterElements(nums):
    n = len(nums)
    result = [-1] * n
    stack = []
    for i in range(n * 2):
        while stack and nums[stack[-1]] < nums[i % n]:
            result[stack.pop()] = nums[i % n]
        stack.append(i % n)
    return result
