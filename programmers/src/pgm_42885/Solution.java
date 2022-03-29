package pgm_42885;

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int bigPeople = people.length-1;
        int smallPeople = 0;

        int boatCount = 0;
        while (bigPeople >= smallPeople){
            boatCount++;
            if(people[smallPeople] + people[bigPeople] <= limit){
                smallPeople++;
            }
            bigPeople--;
        }
        return boatCount;
    }
}