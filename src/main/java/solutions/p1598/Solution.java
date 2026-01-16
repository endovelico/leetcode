package solutions.p1598;

import java.util.Stack;

class Solution {

    public int minOperations(String[] logs) {

        Stack<String> file_system = new Stack<>();

        for(String operation : logs) {

            if(operation.equals("../")) { if(!file_system.isEmpty()) { file_system.pop();} }
            else if(operation.equals("./")) {continue;}
            else { file_system.add(operation);}
        }



        return file_system.size();
    }
}