#Monotonic decreasing stack
#Time complexity = O(n)
#Space complexity = O(n)
class Solution(object):
    def dailyTemperatures(self, temperatures):

        answer = [0] * len(temperatures)
        stack = [] # store the index of the temperature

        #for loop to iterate through temperatures
        for r in range(len(temperatures)):
            #while loop to compare current and previous temperatue.
            while stack and temperatures[stack[-1]] < temperatures[r]:
                l = stack.pop() #pop the top element (colder temperature)
                answer[l] = r - l

            stack.append(r)
        
        return answer


        