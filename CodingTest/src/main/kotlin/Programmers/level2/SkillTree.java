package Programmers.level2;

import java.util.*;

public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int ans = 0;
        ArrayList<Character> s = new ArrayList<Character>();

        for(int i = 0; i < skill.length(); i++){
            s.add(skill.charAt(i));
        }

        for(String skill_tree: skill_trees){
            String idxs = "";
            Boolean flag = true;
            int lastIdx = -1;

            ArrayList<Character> t = new ArrayList<Character>();

            for(int i = 0; i < skill_tree.length(); i++){
                t.add(skill_tree.charAt(i));
            }

            for(Character sk: s){
                if(t.contains(sk)){
                    int idx = t.indexOf(sk);

                    if(lastIdx != -1 && lastIdx > idx){
                        flag = false;
                    }

                    lastIdx = idx;
                    idxs += idx;
                }else{
                    idxs += ".";
                }
            }

            if(flag){
                boolean f = false;
                boolean a = true;

                for(int i = 0; i < idxs.length(); i++){
                    if(idxs.charAt(i) == '.'){
                        f = true;
                    }

                    if(f && idxs.charAt(i) != '.'){
                        a = false;
                    }
                }

                if(a){
                    ans++;
                }
            }

        }

        return ans;
    }
}

class Main {
    public static void main(String[] args){
        SkillTree st = new SkillTree();
        System.out.println(st.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}