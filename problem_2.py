# TC: O(n)
# SC: O(n)

def nextGreaterElements(nums):
    n = len(nums)
    ans = [-1] * n
    stack = []

    for i in range(n * 2 -1, -1, -1):
        while stack and stack[-1] <= nums[i%n]:
            stack.pop()
        ans[i % n] = -1 if not stack else stack[-1]
        stack.append(nums[i%n])
    return ans

