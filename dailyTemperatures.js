/**
 * @param {number[]} temperatures
 * @return {number[]}
 * Intuition:
  We use a 'monotonic decreasing stack' to store indices of days whose warmer temperature hasn’t been found yet.
  When a warmer temperature appears, we pop previous colder days from the stack and calculate the difference in indices ('i - popped').
  Any indices left in the stack have no warmer future day, so their result is set to '0', keeping the overall time complexity O(n).
  S.C: O(n)
  T.C: O(n)
 */
var dailyTemperatures = function(temperatures) {
    let stack = [];
    let result = [];
    for(let i = 0; i<temperatures.length; i++){
        while(stack.length > 0 && temperatures[i] > temperatures[stack[stack.length-1]]){
         let popped = stack.pop();
         result[popped] = i - popped;
        }
        stack.push(i);
    }
    // for the last temperature
    while(stack.length){
        const popped = stack.pop();
        result[popped] = 0;
    }
    return result;
};