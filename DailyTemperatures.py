class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        """using stack to store the tempeartures till the one higher then those are found
        Time complexity-O(2n)~O(n)
        Space complexity-O(n)
        """
        arr=[0 for _ in range(len(temperatures))]
        stack=[]
        for i in range(len(temperatures)):
            while stack and temperatures[stack[-1]]<temperatures[i]:
                temp=stack.pop()
                arr[temp]=i-temp
            stack.append(i)
        return arr
            
        