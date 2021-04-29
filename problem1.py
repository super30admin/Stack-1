#Time Complexity=O(n)
#Space Complexity=O(1)
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if not T or len(T)==0:
            return []
        stack=deque()
        output=[0 for i in range(len(T))]
        for i,t in enumerate(T):
            while stack and t>T[stack[-1]]:
                index=stack.pop()
                output[index]=i-index
            stack.append(i)
        return output
                
        
