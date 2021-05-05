package dictionary;
/*
    순열
 */
public class permutation {
    public static void main(String[] args) {
        int[] numbers = {1,2,3};
        int[] output = new int[numbers.length];
        boolean[] visited = new boolean[numbers.length];

        perm(numbers, output, visited, 0, numbers.length, numbers.length);

    }
    // 순열
    // 사용 예시: perm(arr, output, visited, 0, n, 3);
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            String str = "";
            for(int i=0; i<output.length; i++) {
                str = str + output[i];
            }
            System.out.println(str);
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                //output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;
            }
        }
    }
}
