package sk_ict_p3;

class Solution {
    long[] factorial = new long[500];

    public int solution(int width, int height, int[][] diagonals) {
        long count = 0L;
        width += 1;
        height += 1;

        int startRow = 1;
        int startCal = 1;

        int destinationRow= height;
        int destinationCal = width;

        for(int i = 0; i< diagonals.length; i++){
            int leftRow = diagonals[i][0]+1;
            int leftCal =diagonals[i][1];
            int rightRow =diagonals[i][0];
            int rightCal =diagonals[i][1]+1;

            long startToLeftDiagonal = count(startRow, startCal, leftRow, leftCal);
            long startToRightDiagonal = count(startRow, startCal, rightRow, rightCal);

            count += startToLeftDiagonal% 10000019 * count(leftRow, leftCal,destinationRow,destinationCal)% 10000019;
            count += startToRightDiagonal% 10000019 * count(rightRow, rightCal,destinationRow,destinationCal)% 10000019;
        }
        return (int)(count % 10000019);
    }

    public long count(int startRow, int startCal, int destinationRow, int destinationCal){
        int disRow = Math.abs(destinationRow - startRow);
        int disCal = Math.abs(destinationCal - startCal);

        return (factorial(disCal + disRow) / (factorial(disCal) * factorial(disRow)))% 10000019;
    }

    public long factorial(int n){
        if(factorial[n] != 0L){
            return factorial[n];
        }
        if(n == 1 || n == 0)
            return 1;
        return (n * factorial(n-1));
    }
}