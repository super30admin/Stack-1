"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""


# Daily Temperatures

# Approach - 1
# Stack

class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        st=[]
        n=len(temperatures)
        result=[0 for _ in range(n)]

        for i in range(n):
            while st and temperatures[st[-1]]<temperatures[i]:
                popped=st.pop()
                result[popped]=i-popped
            st.append(i)
        return result


# Approach - 2
# Bruteforce

class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        n=len(temperatures)
        res=[0]*n
        for i in range(n):
            for j in range(i+1,n):
                if temperatures[j]>temperatures[i]:
                    res[i]=j-i
                    break
        return res