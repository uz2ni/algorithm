package goorm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [구름] LV3. 알파벳 트리 장난감 (트리) - 미완료
 */
public class AlphabetTreeToy {

    static String[] alphabet = {null, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    static List<String> alphabetList = Arrays.asList(alphabet);
    static List<String> tree = new ArrayList<>();
    static List<List<String>> graphList = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 트리 총 높이

        tree.add(null); // 트리 0 인덱스 빈 값

        // 입력 받으면서 트리 리스트에 넣기
        for(int i=0; i<n; i++) {
            String[] lines = br.readLine().split("");
            for(int j=0; j<lines.length; j++) {
                tree.add(lines[j]);
            }
        }

        // 인접 그래프 초기화
        for(int i=0; i<alphabet.length; i++) {
            graphList.add(new ArrayList<>());
        }

        // 트리 -> 인접 그래프
        for(int i=1; i<=tree.size(); i++) {
            if(i*2 >= tree.size()) break;
            String node = tree.get(i);
            int nodeIdx = alphabetList.indexOf(node);
            String a1 = tree.get(i*2);
            String a2 = tree.get(i*2+1);
            graphList.get(nodeIdx).add(a1);
            graphList.get(nodeIdx).add(a2);
        }

        dfs(1, 0);
    }

    public static void dfs(int i, int sum) {
        if(i*2 <= tree.size()) {
            // 누적 합계 출력
            System.out.println(sum);
            return;
        }

        int leftIdx = alphabetList.indexOf(tree.get(i*2));
        graphList.get(leftIdx);
    }
}
