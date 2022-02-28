# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        """
        stack, push smaller, pop if bigger found
        circular -> loop twice, mod index
        O(N) time and space
        """
        N=len(nums)
        A=nums+nums
        s=[]
        ans=[-1]*N
        for i,v in enumerate(A):
            if not s or v<=A[s[-1]]:
                s.append(i%N)
            else:
                while s and v>A[s[-1]]:
                    ans[s.pop()]=v
                s.append(i%N)
        
        return ans