#Monotonic decreasing stack
#Time complexity = O(n)
#Space complexity = O(n)
#Did this code successfully run on Leetcode: Yes
#Any problem you faced while coding this : No

class Solution(object):
    def dailyTemperatures(self, temperatures):

        answer = [0] * len(temperatures)
        stack = [] # store the index of the temperature

        #for loop to iterate through temperatures
        for r in range(len(temperatures)):
            #while loop to compare current and previous temperatue.
            while stack and temperatures[stack[-1]] < temperatures[r]:

                l = stack.pop() #pop the top element (colder temperature)

                answer[l] = r - l  #Difference of the indexes of current & previous colder temperatures

            stack.append(r)
        
        return answer


        