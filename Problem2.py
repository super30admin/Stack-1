# Problem 2: Next Greater Element II
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [-1 for _ in range(n)]
        st = [(nums[0],0)]

        for i in range(1,2*n):
            while len(st) > 0 and nums[i%n] > st[-1][0]:
                popped = st.pop()
                result[popped[1]] = nums[i%n]

            if i < n:
                st.append((nums[i],i))

        return result