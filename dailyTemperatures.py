#All TC passed on leetcode

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:

        #Here we traverse the array and push temperature index into stack. 
        #If cur temp is greater than top of stack we pop and add in result the difference of their indices
        #Time complexity: O(n)
        #Space complexity: O(n) 
        stack = []
        res = [0]*len(temperatures)

        for i in range(len(temperatures)):

            while stack and temperatures[stack[-1]]<temperatures[i]:
                val = stack.pop()
                res[val] = i-val
        
            stack.append(i)

        return res


        