package solutions.p2103;

public class Solution {

    public int countPoints(String rings) {

        boolean[][] rods = new boolean[10][3];

        for (int i = 0; i < rings.length(); i+=2) {

           char current_color =  rings.charAt(i);
           int current_rod = rings.charAt(i + 1) - '0';

           if ( current_color == 'R') { rods[current_rod][0] = true; }
           else if (current_color == 'G') { rods[current_rod][1] = true;}
           else if  (current_color == 'B') { rods[current_rod][2] = true;}

        }

        int full_ring_count = 0;

        for (int j = 0; j < rods.length; j++) {

            if( rods[j][0] && rods[j][1] && rods[j][2]) { full_ring_count++;}
        }

        return full_ring_count;
    }
}
