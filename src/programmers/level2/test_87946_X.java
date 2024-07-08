package programmers.level2;

/** 87946
 * 코딩테스트 연습 > 완전탐색 > 피로도
 */
public class test_87946_X {

    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(80, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return count;
    }

    public static void dfs(int depth, int k, int[][] dungeons) { // depth: 현재까지 방문한 회수
        for(int i=0; i< dungeons.length; i++) {
            System.out.println("idx:" + i + ", depth:" + depth + ", k:" + k);
            if(visited[i] || dungeons[i][0] > k) {
                continue;
            }
            visited[i] = true;
            dfs(depth+1, k-dungeons[i][1], dungeons);
            visited[i] = false; // 백트래킹 기법. 앞선 재귀 끝나고 다른 경로에서는 방문할 수 있도록 초기화
        }
        System.out.println("===");
        count = Math.max(depth, count); // 최대 방문수 갱신
    }
}
