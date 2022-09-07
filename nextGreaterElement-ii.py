#Time Complexity : O(N)
#Space Complexity : O(N)
def nextGreaterElements(self, nums: List[int]) -> List[int]:
    n = len(nums)
    result = [-1] * (n)
    st = []
    for i in range(0, (n * 2)):
        curr = i % n
        while st and nums[st[-1]] < nums[curr]:
            j = st.pop()
            result[j] = nums[curr]
        if i < n + 1:
            st.append(curr)
    return result