'''
time complexity: O(n)
space complexit: O(n)
'''
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [-1 for _ in range(n)]
        st = [0]
        for i in range(2*n):
            while(len(st)!=0 and nums[st[-1]] < nums[i%n]):
                curr = st.pop()
                
                res[curr] = nums[i%n]
            if i < n:
                st.append(i)
        return res