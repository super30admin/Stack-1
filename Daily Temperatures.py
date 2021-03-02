#time: O(n)
#space: O(n)


class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if(T==None or len(T)==0):
            return []
        n=len(T)
        stack=[]
        result=[0]*n
        for i in range(len(T)):
            while(stack!=[] and T[i]>T[stack[-1]]):
                idx=stack.pop()
                result[idx]=i-idx
            stack.append(i)
        return result
            
        