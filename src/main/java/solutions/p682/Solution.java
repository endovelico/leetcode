package solutions.p682;

import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> operation_stack = new Stack<>();

        for (String operation : operations) {

            switch(operation) {

                case "C":
                    operation_stack.pop();
                    break;
                case "D":
                    operation_stack.push(2 * operation_stack.peek());
                    break;
                case "+":
                    int top = operation_stack.pop();
                    int sum = top + operation_stack.peek();
                    operation_stack.push(top);
                    operation_stack.push(sum);
                    break;
                default:
                    operation_stack.push(Integer.parseInt(operation));
            }

        }

        int total_score = 0;
        for(int score : operation_stack) total_score += score;

        return total_score;
    }
}
