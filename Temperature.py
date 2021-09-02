#time:O(n)
#space:O(1)
class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        ans = []
        for i in range(len(temperatures)-1,-1,-1):
            # print("curr_Stack",stack,i)
            while(stack and temperatures[stack[-1]]<=temperatures[i]):
                stack.pop()
            # print("processed_Stack",stack,i)
            if len(stack)<1:
                # print("stack is empty ,temperature",temperatures[i],i)
                ans.append(0)
            else:
                # print("non empty",temperatures[i],stack[-1])
                ans.append(stack[-1]-i)
                # print("curr_answer",ans)
            stack.append(i)
            # print("updated_Stack",stack,i)
        return ans[::-1]