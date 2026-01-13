package solutions.p141;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class NaiveSolution {

        public boolean hasCycle(ListNode head) {
            Set<ListNode> visited = new HashSet<>();

            ListNode curr = head;
            while (curr != null) {
                if (visited.contains(curr)) {
                    return true; // cycle detected
                }
                visited.add(curr);
                curr = curr.next;
            }

            return false; // reached null → no cycle
        }


}
