package solutions.p1103;

class Solution {
    public int[] distributeCandies(int candies, int num_people) {

        int[] people_array = new int[num_people];

        int candies_to_give = 1;
        int person_receiving = 0;

        while (candies > 0) {
            // give min(candies_to_give, remaining candies)
            int give = Math.min(candies_to_give, candies);
            people_array[person_receiving % num_people] += give;
            candies -= give;

            // move to next person & increase candy amount
            person_receiving++;
            candies_to_give++;
        }

        return people_array;
    }
}
