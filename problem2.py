#timecomplexity  O(3N)= O(n)
#space complecxity o(n) stack size
#desc adding index in stack if stack is empty
# in for looping chking if the curr value is greater then the top index value of stack 
# it means we find out the next greater value of that index https://leetcode.com/problems/next-greater-element-ii/
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if nums==[] or len(nums)==0: return  []
        result=[-1 for _ in range(len(nums))]
        n=len(nums)
        st=[]
        for i in range(2*n):
            while(st!=[] and nums[i%n]>nums[st[len(st)-1]]):
                id=st.pop()
                result[id]=nums[i%n]
            if i<n:
                st.append(i)
        return result