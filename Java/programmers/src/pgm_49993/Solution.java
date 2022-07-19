package pgm_49993;

public class Solution {
    public int solution(String skill, String[] skill_trees) {

        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            if (checkSkillTree(skill, skill_trees[i]))
                answer++;
        }

        return answer;
    }

    public boolean checkSkillTree(String leadingSkill, String skillTree) {
        for (int i = 0; i < skillTree.length(); i++) {
            if (leadingSkill.contains(skillTree.charAt(i) + "")) {
                if (leadingSkill.charAt(0) != skillTree.charAt(i))
                    return false;
               leadingSkill = leadingSkill.substring(1);
            }
        }
        return true;
    }
}
