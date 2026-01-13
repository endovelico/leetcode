package solutions.p455;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] greedy, int[] cookies) {
        Arrays.sort(greedy);
        Arrays.sort(cookies);

        int child = 0;
        int cookie = 0;
        int content = 0;

        while (child < greedy.length && cookie < cookies.length) {
            if (cookies[cookie] >= greedy[child]) {
                content++;
                child++;
                cookie++;
            } else {
                cookie++;
            }
        }

        return content;
    }
}
