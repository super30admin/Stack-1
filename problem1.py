class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        stack = []
        ans = [0 for _ in range(n)]
        for i in range(n):
            while(len(stack)!=0 and temperatures[stack[-1]]<temperatures[i]):
                if(temperatures[stack[-1]]<temperatures[i]):
                    curr = stack.pop(-1)
                    ans[curr] = i-curr
            stack.append(i)
        return ans