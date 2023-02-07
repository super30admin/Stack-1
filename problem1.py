#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: Yes
#Use a stack to track all indexes which have not been processed(ie temperatures whose next greateset value have not been found so far). When a temparture encountered is greater than the top element in the stack, this means an appropriate temperature for the top element has been found out. Keep on processing elements in stack from top one by on e as long as current element > top.
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stk=[(temperatures[0],0)]
        L=[0]*len(temperatures)
        for i in range(1,len(temperatures)):
            while(stk and stk[-1][0]<temperatures[i]):
                L[stk[-1][1]]=i-stk[-1][1]
                del(stk[-1])
            stk.append((temperatures[i],i))
        
        return L
