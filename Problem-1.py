class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if not temperatures or len(temperatures)==0:
            return []
        
        stack=[]
        for i in range(len(temperatures)):
            while len(stack)>0 and temperatures[stack[len(stack)-1]]<temperatures[i]:
                idx=stack.pop()
                temperatures[idx] = i - idx
                
            stack.append(i)
            
        while stack:
            temperatures[stack.pop()]=0
        return temperatures
                
                