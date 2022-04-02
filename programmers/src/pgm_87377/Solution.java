package pgm_87377;

import java.util.ArrayList;

public class Solution {
    private final boolean SOLVE_X = true;
    private final boolean SOLVE_Y = false;

    public String[] solution(int[][] line) {
        ArrayList<int[]> meetLocs = new ArrayList<>();
        for(int i = 0; i < line.length-1; i++){
            for(int j = i+1; j < line.length; j++){
                findMeet(line[i],line[j],meetLocs);
            }
        }
        int maxX= Integer.MIN_VALUE;
        int maxY= Integer.MIN_VALUE;
        int minX= Integer.MAX_VALUE;
        int minY= Integer.MAX_VALUE;
        for(int i = 0; i < meetLocs.size(); i++){
            minX = minX < meetLocs.get(i)[0] ? minX : meetLocs.get(i)[0];
            minY = minY < meetLocs.get(i)[1] ? minY : meetLocs.get(i)[1];
            maxX = maxX > meetLocs.get(i)[0] ? maxX : meetLocs.get(i)[0];
            maxY = maxY > meetLocs.get(i)[1] ? maxY : meetLocs.get(i)[1];
        }

        char[][] result = new char[maxX-minX+1][maxY-minY+1];
        for(int i = 0; i < meetLocs.size(); i++){
            int[] loc = meetLocs.get(i);
            result[loc[0] - minX][loc[1] - minY] = '*';
        }
        String[] answer = new String[maxX-minX+1];
        for(int i = 0; i < result.length; i++){
            String input = "";
            for(int j = 0; j <result[i].length; j++){
                input += result[i][j] == '*' ? "*" : ".";
            }
            answer[answer.length-1-i] = input;
        }

        return answer;
    }

    private boolean findMeet(int[] line1, int[] line2, ArrayList<int[]> meetLocs) {
        double x = 0;
        double y = 0;

        if ((line1[0] == 0 && line2[0] == 0) || (line1[1] == 0 && line2[1] == 0))
            return false;

        if(line1[0] == 0){
            y = -1.0*line1[2]/line1[1];
            x = solveEquation(SOLVE_X, y, line2);
        }
        else if(line1[1] == 0){
            x = -1.0*line1[2]/line1[0];
            y = solveEquation(SOLVE_Y, x, line2);
        }
        else if(line2[0] == 0){
            y = -1.0*line2[2]/line2[1];
            x = solveEquation(SOLVE_X, y, line1);
        }
        else if(line2[1] == 0){
            x = -1.0*line2[2]/line2[0];
            y = solveEquation(SOLVE_Y, x, line1);
        }
        else{
            double multiply = 1.0*line2[0]/line1[0];
            double changeY = line2[1] - (line1[1] * multiply);
            double changeC = line2[2] -(line1[2] * multiply);
            y = -1.0*changeC/changeY;
            x = solveEquation(SOLVE_X,y, line2);
        }

        if(x == (int)x && y == (int)y)
            meetLocs.add(new int[]{(int)y,(int)x});
        return true;
    }

    private double solveEquation(boolean solveX, double val, int[] line){
        return solveX ? -1.0*(line[1]*val + line[2]) /line[0] : -1.0*(line[0]*val + line[2]) / line[1];
    }
}