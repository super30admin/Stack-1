class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res=[0]*len(temperatures)
        stack=[0]
        for idx, temp in enumerate(temperatures):
            if idx==0:
                continue
            while len(stack)>0 and temp>temperatures[stack[-1]]:
                popped=stack.pop()
                res[popped]=idx-popped
            
            stack.append(idx)
        
        return res


        