#Time complexity is: O(n)
#Space complexity is O(1)
#No issues faced while coding
#COde ran successfully on leetcode
class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        #Initializing all the required variables
        result=[0 for i in range(0,len(temperatures))]
        st=[]
        #Iterating thorugh the given array
        for i in range(0,len(temperatures)):
            #We will be looping until the condition in the while is satisfied
            while(len(st) and temperatures[i]>temperatures[st[len(st)-1]]):
                #We will pop the index value and we will store in the result array
                popped=st.pop()
                result[popped]=i-popped
            #We will append the index into the stack 
            st.append(i)
        #Finally we are returning the result
        return result    