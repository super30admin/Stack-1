#Time complexity is O(n)
#Space complexity is O(1)
#No issues faced while coding
#Code ran sucecssfully on leetcode
class Solution(object):
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        #initializing all the required variables
        n=len(nums)
        result=[-1 for i in range(0,n)]
        st=[]
        #We will be iterating through the array two times
        for i in range(2*n):
            #We will be moving the index until the below while condition satisfies
            while(len(st) and nums[i%n]>nums[st[len(st)-1]]):
                #We will pop the stack, we will get an index and we will then 
                #inser the number at that index
                result[st.pop()]=nums[i%n]
            #If i is less than n, then only we insert into the stack
            if(i<n):
                #Appending i into the stack
                st.append(i)
        #Finally we will return result array
        return result