package pgm_42842;

class Solution {
    public int[] solution(int brown, int yellow) {
        int gridCount = brown + yellow;

        int length = 3;
        while (gridCount % length != 0)
            length++;
        int width = gridCount / length;


        while (brown != (width*2) + (length*2) -4){
            length ++;
            while (gridCount % length != 0)
                length++;
            width = gridCount / length;
        }

        return new int[]{width,length};
    }
}