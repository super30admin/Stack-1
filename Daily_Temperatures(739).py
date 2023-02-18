class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if((temperatures is None) or (len(temperatures)==0)):
            return []
        # T.C. = O(n)
        # S.C. = O(n)
        # here we use the concept of a monotonic stack
        # we keep on popping the stack until we encounter a temp that is greater than the current
        # so as to ensuren that the stack is in descending order from bottom to top
        size = len(temperatures)
        stack = list()
        stack.append(0)
        idx = 1
        ans = [0 for _ in range(size)]

        while idx<size:
            # we go on popping the top element until the current element is greater than the top
            # element of the stack
            while len(stack)!=0 and temperatures[idx]>temperatures[stack[-1]]:
                ans[stack[-1]] = idx - stack[-1]
                stack.pop()
            # The current element will always go inside the stack since we need to solve for the
            # current index as well
            stack.append(idx)
            idx+=1
        return ans

        # Approach 1 : Storing index and temperatures both
        # if((temperatures is None) or (len(temperatures)==0)):
        #     return []

        # size = len(temperatures)
        # stack = list()
        # stack.append([0,temperatures[0]])
        # idx = 1
        # ans = [0 for _ in range(size)]

        # while idx<size:
        #     while len(stack)!=0 and temperatures[idx]>stack[-1][1]:
        #         ans[stack[-1][0]] = idx - stack[-1][0]
        #         stack.pop()
        #     stack.append([idx,temperatures[idx]])
        #     idx+=1
        # return ans