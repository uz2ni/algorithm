package programmers.topkit.dfsbfs;

/** 43165
 * 코딩테스트 연습 > DFS/BFS > 타겟넘버
 */
public class test1 {

    static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = {4,1,2,1};
        System.out.println(solution(numbers, 4));
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    public static void dfs(int[] numbers, int depth, int target, int sum) {
        if(depth == numbers.length){
            if(sum == target) answer++;
        }else {
            dfs(numbers, depth+1, target, sum - numbers[depth]);
            dfs(numbers, depth+1, target, sum + numbers[depth]);
        }

    }
}
