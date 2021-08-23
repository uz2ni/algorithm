package programmers.weekly;

import java.util.*;

/*
    week4 - 직업군 추천하기
 */
public class test_84325 {

    public static void main(String[] args) {
        String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#",
                            "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                            "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
                            "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                            "GAME C++ C# JAVASCRIPT C JAVA" };
        String[] languages = { "PYTHON", "C++", "SQL" };
        int[] preference = {7, 5, 5};

        System.out.println(solution(table,languages,preference));

    }
    static public String solution(String[] table, String[] languages, int[] preference) {
        TreeSet<Developer> ts = new TreeSet<>();

        for(int i=0; i<table.length; i++) {
            String[] tbArr = table[i].split(" ");
            int sum = 0;
            for(int j=0; j<languages.length; j++) {
                int idx = findLanguage(tbArr, languages[j]);
                int weight = 0;
                if(idx > -1) { weight = tbArr.length-idx; }
                sum += (preference[j] * weight);
            }
            ts.add(new Developer(tbArr[0], sum));
        }

        return ts.first().language;
    }

    static public int findLanguage(String[] tbArr, String language) {
        for(int i=0; i<tbArr.length; i++) {
            if(tbArr[i].equals(language)) {
                return i;
            }
        }
        return -1;
    }
}

class Developer implements Comparable<Developer> {

    String language;
    int grade;

    Developer (String language, int grade) {
        this.language = language;
        this.grade = grade;
    }

    @Override
    public int compareTo(Developer o) {
        if(this.grade < o.grade) return 1;
        else if(this.grade == o.grade) {
            return this.language.compareTo(o.language);
        }else return -1;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "language='" + language + '\'' +
                ", grade=" + grade +
                '}';
    }
}