class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        
        if temperatures == None or len(temperatures)== 0:
            return None
        stack = []
        res = [0 for _ in range(len(temperatures))]
        stack.append(0)
 
        for a in range(1,len(temperatures)):
            
            while len(stack)!=0 and temperatures[a] > temperatures[stack[-1]]:
                popped = stack.pop()
                res[popped] = a - popped
            stack.append(a)
        return res