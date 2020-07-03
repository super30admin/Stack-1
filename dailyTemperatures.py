#Time Complexity:O(n)
#Space COmplexity:O(n)
#Ran successfully on Leetcode:yes
#Algorithm
#1.Create a stack and an array to return the number of days.
#2.Check if the top of tha stack has greater temperature or not. If not pop it put and calculate the -that particular index-present index to return . 
#3. Append the index of the tempertature we are passing thru. 
#4.Repeat the above procedure untill we reach the end of the array
class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack=[]
        ans=[0]*len(T)
        for i in range(len(T)):
            while stack and T[i]>T[stack[-1]]:
                temp=stack.pop()
                ans[temp]=i-temp
            stack.append(i)
        return ans
                
        
