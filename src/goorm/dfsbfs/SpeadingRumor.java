package goorm.dfsbfs;

import java.io.*;
import java.util.*;

/**
 * [구름] LV1. 퍼져나가는 소문
 */
public class SpeadingRumor {

    static boolean[] visited; // 방문 기록
    static int cnt = 0; // 소문 들은 친구 수
    static List<List<Integer>> list; // 관계 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 친구 수
        int m = Integer.parseInt(br.readLine()); // 관계 수
        visited = new boolean[n+1];
        list = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<Integer>());
        }
        for(int i=0; i<m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list.get(b).add(a);
            list.get(a).add(b);

        }

        dfs(1);

        System.out.println(cnt);

    }

    static public void dfs(int node) {
        visited[node] = true;
        cnt++;
        List nodeList = list.get(node);
        for(int i=0; i< nodeList.size(); i++) {
            if(!visited[(int)nodeList.get(i)]) {
                dfs((int)nodeList.get(i));
            }
        }
    }
}
