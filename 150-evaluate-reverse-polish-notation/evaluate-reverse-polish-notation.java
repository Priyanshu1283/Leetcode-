class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        
        for(int i =0; i<tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") ||tokens[i].equals("*") || tokens[i].equals("/")){
                int a = Integer.parseInt(st.pop());
                int b = Integer.parseInt(st.pop());
                int ans = 0;
                if(tokens[i].equals("+")){
                    ans = b + a;
                }else if(tokens[i].equals("-")){
                    ans = b - a;
                }else if(tokens[i].equals("*")){
                    ans = b * a;
                }else{
                    ans = b / a;
                }
                st.push(String.valueOf(ans));
            }else{
                st.push(tokens[i]);
            }
        }
        return Integer.parseInt(st.pop());
    }
}