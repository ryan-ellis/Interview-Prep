// Idea: This is a pretty straight forward stack problem. Push the opposite
//       character to the stack and check if they are equal when popping.

// Run Time: O(n) since we have to iterate through all the character but insertion/deletion
//           is O(1) with a stack. 

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int x = 0; x < s.length(); x++){
            if(s.charAt(x) == '('){
                stack.push(')');
            } else if(s.charAt(x) == '['){
                stack.push(']');
            } else if(s.charAt(x) == '{'){
                stack.push('}');
            } else{
                if(stack.isEmpty() == true || stack.pop() != s.charAt(x)){
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}