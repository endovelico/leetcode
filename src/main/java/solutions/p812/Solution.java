package solutions.p812;

class Solution {
    public double largestTriangleArea(int[][] points) {

        double maximum_area = 0;
        int number_of_coordinates = points.length;

        for (int point_a = 0; point_a < number_of_coordinates; point_a++) {
            for (int point_b = point_a + 1; point_b < number_of_coordinates; point_b++) {
                for (int point_c = point_b + 1; point_c < number_of_coordinates; point_c++) {

                    int[] p1 = points[point_a], p2 = points[point_b], p3 = points[point_c];

                    double area = Math.abs(
                            p1[0]*(p2[1]-p3[1]) +
                                    p2[0]*(p3[1]-p1[1]) +
                                    p3[0]*(p1[1]-p2[1])
                    ) / 2.0;
                    maximum_area = Math.max(maximum_area, area);

                }
            }
        }

        return maximum_area;
    }
}