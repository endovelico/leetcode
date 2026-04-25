package solutions.p1064;

class Solution {

    public int fixedPoint(int[] arr) {

        return 0;
    }

    private boolean collinear(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1);
    }
}