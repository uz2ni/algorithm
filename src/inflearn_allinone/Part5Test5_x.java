package inflearn_allinone;

import java.lang.Math;

/**
 * 태어난김에 세계일주1
 */
public class Part5Test5_x {

    static int maxCount = 0;

    public static void main(String[] args) {
        int balance = 600;
        int[][] countries = {{70, 350}, {100,550}, {350,400}};
        System.out.println(solution(balance, countries));
    }

    public static int solution(int balance, int[][] countries) {
        boolean[] visited = new boolean[countries.length];
        dfs(balance, 0, countries, visited);
        return maxCount;
    }

    public static void dfs(int balance, int count, int[][] countries, boolean[] visited) {
        maxCount = Math.max(maxCount, count);
        for(int i=0; i<countries.length; i++) {
            if(!visited[i] && balance >= countries[i][1]){
                visited[i] = true;
                dfs(balance - countries[i][0], count+1, countries, visited);
                visited[i] = false;
            }
        }
    }
}
