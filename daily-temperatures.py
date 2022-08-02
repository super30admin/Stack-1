# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if temperatures==None or len(temperatures)==0: return None
        stack=[]
        result=[0]*len(temperatures)
        stack.append(0)
        for i in range(1,len(temperatures)):
            while len(stack)!=0 and temperatures[stack[len(stack)-1]]<temperatures[i]:
                cur=stack.pop()
                result[cur]=i-cur
            stack.append(i)
        return result