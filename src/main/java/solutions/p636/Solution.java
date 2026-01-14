package solutions.p636;

import java.util.List;
import java.util.Stack;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {

        int[] res = new int[n];           // Result array: res[i] = exclusive time of function i
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of currently running functions
        int prevTime = 0;                 // Previous timestamp we've processed

        // Iterate through all logs
        for (String log : logs) {
            String[] parts = log.split(":");        // Split log into [id, type, timestamp]
            int id = Integer.parseInt(parts[0]);    // Function ID
            String type = parts[1];                 // "start" or "end"
            int time = Integer.parseInt(parts[2]);  // Timestamp

            if (type.equals("start")) {
                // If some function is already running, add the time slice since prevTime to it
                if (!stack.isEmpty()) {
                    res[stack.peek()] += time - prevTime;
                }

                // Push current function onto stack (it starts running now)
                stack.push(id);

                // Update prevTime to the start time of current function
                prevTime = time;
            } else { // type == "end"
                // Pop the function from the stack (it ends now)
                // Add its inclusive time: (current timestamp - prevTime + 1)
                res[stack.pop()] += time - prevTime + 1;

                // Update prevTime to the next time slice (after this function ends)
                prevTime = time + 1;
            }
        }

        return res;
    }
}
