#Time , space  O(n)

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack=[]
        res=[0]*len(temperatures)
        #Appending elements in the stack and if incoming element is greater than the element popping element and adding both their differences in result array
        for i in range(len(temperatures)):     
            while stack and (temperatures[stack[-1]]<temperatures[i]):
                
                res[stack[-1]]=i-stack[-1]
                stack.pop()             
            stack.append(i)
                             
        return res
