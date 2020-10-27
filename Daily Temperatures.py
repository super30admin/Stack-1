class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        #Time: O(N)
        #Space: O(N)
        if len(T)<1:
            return None
        output = [0]*len(T)
        stack = []
        for i in range(len(T)):
            while stack!= [] and T[i]>T[stack[-1]]:
                curr=stack.pop()
                output[curr]=i-curr
            stack.append(i)
        return output