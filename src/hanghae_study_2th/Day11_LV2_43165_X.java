package hanghae_study_2th;

/**
 * 24.5.30 (수)
 * [프로그래머스] LV2 - 43165. 코딩테스트 연습 > DFS/BFS > 타겟 넘버
 **/
public class Day11_LV2_43165_X {
    static int answer = 0;

    public static void main(String[] args) {

        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        System.out.println(solution(numbers, target));

    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);

        return answer;
    }

    // 깊이 우선 탐색
    public static void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){ // 마지막 노드 까지 탐색한 경우
            if(target == sum) answer++;
        } else {
            dfs(numbers, depth + 1, target, sum + numbers[depth]); // 해당 노드의 값을 더하고 다음 깊이 탐색
            dfs(numbers, depth + 1, target, sum - numbers[depth]); // 해당 노드의 값을 빼고 다음 깊이 탐색
        }
    }


}
