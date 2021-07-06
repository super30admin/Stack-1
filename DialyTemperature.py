Daily Temperatures
 Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100]. 


Time  complexity O(n) | Space complexity O(n)


class Solution(object):
    def dailyTemperatures(self, T):
        """
        :type T: List[int]
        :rtype: List[int]
        """
        stack,result = [] ,[0 for i in range(len(T))]
        
        for index in range (len(T)):
        #Monotonic stack we are comapring with the elements in the array with the stack element 
            while(len(stack) and  T[stack[-1]] < T[index]):
          #  if its less than the stack element we are poping it 
                prorityIndex = stack.pop()
                #calculating the index value
                result[prorityIndex] = index - prorityIndex
            #if the stack is empty keep adding
            stack.append(index)
        return result

