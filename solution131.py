#Time Complexity:O(2n)
#Space Complexity:O(n/2)
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        if len(nums)==0:
            return []
        n=len(nums)
        result=[-1 for i in range(n)]                       #declare a resultant array
        st=[]                                               #declare a stack 
        for i in range(2*n):                                #parse each element twice until all elements have a greater element.
            while st and nums[i%n]>nums[st[-1]]:            #if the element at top of stack is greater than the current element
                pos=st.pop()                                #get the element position and add the greater element to that position.
                result[pos]=nums[i%n]
            if i<n:
                st.append(i)
        return result