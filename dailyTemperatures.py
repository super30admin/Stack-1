'''
We can make use of stack
Tme Complexity --> O(n)
Space Complexity --> O(n)
'''
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0 for x in range(len(temperatures))]
        stk = []
        for i in range(len(temperatures)):
            if len(stk)==0:
                stk.append((i,temperatures[i]))
            else:
                if temperatures[i]>stk[-1][1]:
                    while len(stk)!=0 and temperatures[i]>stk[-1][1]:
                        res[stk[-1][0]] = (i-stk[-1][0])
                        stk.pop(-1)
                stk.append((i, temperatures[i]))
        return res



