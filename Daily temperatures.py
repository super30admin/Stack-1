#Always write the base condition like stack not empty in while loop first and then the temperature 
# condition so the while loop first checks the tack if it is empty and then 
# only checks the second condition.

# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        if temperatures==None or len(temperatures)==0: return None
        n=len(temperatures)
        arr=[0 for i in range(n)]
        stack=[]
        stack.append(0)
        for i in range(1,n):
            while(len(stack)!=0 and temperatures[i]>temperatures[stack[len(stack)-1]] ):
                k=stack.pop()
                arr[k]=i-k
            stack.append(i)
        return arr