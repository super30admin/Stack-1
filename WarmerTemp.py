#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        lst=[]
        res=[0]*len(temperatures)
        for i in range(len(temperatures)):
            while lst and temperatures[lst[-1]]<temperatures[i]:
                index=lst.pop()
                res[index]=i-index
            
            lst.append(i)
        return res