//Approach - 1: Stack, lastSign, curr
//Time Complexity : O(n)
//Space Complexity : O(1)

class Solution {
    public int calculate(String s) {       
        if(s == null || s.length() == 0) return 0;
        s = s.trim();
        Stack<Integer> st = new Stack<>();
        
        //lastSign and curr number
        char lastSign = '+';
        int curr = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i); 
            //if char is Digit change curr Number
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0'; // convert it into digit eg: string s = "42"            
                if(i== s.length()-1){
                    if(lastSign == '+') st.push(curr);
                    else st.push(-curr);
                }
            }
            //if char is Operator change lastSign and CurrNumber = 0
            else if(c == '+' || c == '-'){
                if(lastSign == '+') st.push(curr);
                else st.push(-curr);
                curr = 0; lastSign = c;
            }
            //if char is Opening small bracket, and lastSign is + then push 1 else -1
            else if(c == '('){
                if(lastSign == '+') st.push(1);
                else st.push(-1);
                st.push(Integer.MAX_VALUE);
                curr = 0; 
                lastSign = '+';
            }
            //if char is Closing small bracket, and lastSign is + push Curr else -Curr
            else if(c == ')'){
                if(lastSign == '+') st.push(curr);
                else st.push(-curr);
                
                //Calculate the result inside the brackets
                int interResult = 0;
                while(st.peek() != Integer.MAX_VALUE){
                    interResult += st.pop();
                }
                st.pop();
                interResult = interResult * st.pop(); 
                st.push(interResult);
                curr = 0; lastSign = '+';
            }
        }
        
        //Calculate the result inside the brackets
        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}
