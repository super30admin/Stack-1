class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # Monotonic stack - ie top element needs to be resolved first and stack has either increasing or decreasing elements
        # think of this pattern when you cannot resolve other elements in stack before working with top most
        # Stack TC - O(n) SC -O(n)
        stack = []
        n = len(temperatures)
        output = [0 for _ in range(n)]
        for i, temp in enumerate(temperatures):
            while stack and temperatures[stack[-1]] < temp:
                curr_index = stack.pop()
                output[curr_index] = i - curr_index
            stack.append(i)
        return output

    '''
        #Same as above just includes both temperaure and index in stack
        stack = [(temperatures[0], 0)]
        n= len(temperatures)
        output = [0 for _ in range(n)]
        for i, temp in enumerate(temperatures):
            #if i !=0: I don't need this but kept it for understanding
            while stack:
                (peek_temp,j) = stack[-1]
                if peek_temp < temp:
                    (curr_temp, k) = stack.pop()
                    output[k] = i - k
                else:
                    break
            stack.append((temp,i))
        return output

    '''
    '''
       # Array, optimized space TC - O(n) SC - O(1)
        n = len(temperatures)
        output = [0 for _ in range(n)]
        hottest = 0

        for i in range(n-1,-1,-1):
            if temperatures[i] >= hottest:
                hottest = temperatures[i]
                continue      #no hotter day on the right of i, therefore answer[i] = 0
            else:
                days = 1
                while temperatures[i+days] <= temperatures[i]:
                    days += output[i+days]
                output[i] = days
        return output 
    '''

    '''
        # Brute Force TC - O(n**2) Time limit exceed
        n= len(temperatures)
        output = [0 for _ in range(n)]
        for i in range(n):
            for j in range(i+1,n):
                if temperatures[j] > temperatures[i]:
                    output[i] = j-i
                    break
        return output
    '''
