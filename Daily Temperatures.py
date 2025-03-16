class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        if temperatures == None or len(temperatures) == 0:
            return []

        n =len(temperatures)
        result = [0 for i in range(n)]
        stack =[]
        
        for i in range(n):

            while stack and temperatures[stack[-1]] < temperatures[i]:
                popped = stack.pop()
                result[popped] = i - popped

            stack.append(i)


        return result    


        

        