class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        

        #Method 1 - Brute force, 2 pointer in circular manner -> O(n^2)
        #Method 2 - Monotic decreasing Stack - TC O(n) but actually O(4n)-1n+2n+1n
        if not nums or len(nums)==0: return [0]
        n=len(nums)
        st=[]
        res=[-1]*n #1n
        for i in range(2*n): #2n

            #we need circular operation, so worst case it we need to go till n for the 2nd time (till 2n). Example, you are at nth position and the next greater doesn't exist then we need to iterate till we reach the nth element again.

            while st and nums[st[-1]]<nums[i%n]:#1n 

            #but actual index is till n, so do mod
                popped=st.pop()
                res[popped]=nums[i%n] 
            if i<n: #no need to push in the 2nd time
                st.append(i)
        return res
