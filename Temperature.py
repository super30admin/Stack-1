#Monotonic stack solution
#Time complexity: O(2n) #For eg, 76,75,74,73,77
#Space complexity:O(n)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        mono_stack=[]
        output=[0 for i in range(len(temperatures))]
        for i in range(0, len(temperatures)):
            while(mono_stack and temperatures[mono_stack[-1]]<temperatures[i]):
                diff=i-mono_stack[-1]
                output[mono_stack[-1]]=diff
                mono_stack.pop()
            mono_stack.append(i)
        return output 