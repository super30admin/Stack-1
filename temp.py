# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we add the elements to a stack if the already stack[top] is greater than new incoming element. if not - if incoming is greater we pop the curent top and check if new top is grater- we pop
# until we reach a greater elem as top and then add the new one to the stack 
class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        # O(n), O(n)
        if(len(temperatures)==0):
          return []
        answer=[0]*len(temperatures)
        

        st=[]
        for i in range(len(temperatures)):
          while(st and temperatures[i]>temperatures[st[-1]]):
            popped=st.pop()
            answer[popped]=i-popped
          st.append(i)
        return answer
