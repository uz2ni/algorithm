package inflearn_allinone.replay;

public class Part4_태어난김에_세계일주1 {
    public static int answer;
    public static void main(String[] args) {
        // int initBalance = 600;
        // int[][] countries = {{70,350}, {100,500}, {350,400}};

        int initBalance = 500;
        int[][] countries = {{250,250}, {300,400}, {120,450}, {70, 150}};
        System.out.println(solution(initBalance, countries));
    }

    public static int solution(int balance, int[][] countries) {
        answer = 0;
        dfs(balance, countries, new boolean[countries.length], 0); // 순열
        return answer;
    }

    public static void dfs(int balance, int[][] countries, boolean[] visited, int cnt) {
        answer = Math.max(answer, cnt);

        for(int i=0; i<countries.length; i++) {
            if(!visited[i] && (balance >= countries[i][1])) { // 아직 미방문 && 필요잔고 만족한 경우
                    visited[i] = true;
                    dfs(balance-countries[i][0], countries, visited, cnt+1);
                    visited[i] = false;
            }
        }
    }
}
