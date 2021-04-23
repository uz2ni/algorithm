package programmers;
/*
    소수 만들기
 */
public class test_12977 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(solution(arr));
    }

    // 1. 2~N 이하 자연수로 나누어지는지 판별
    static public int solution(int[] nums) {
        int answer = 0;

        // 서로 다른 3개의 수 조회
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    int num = nums[i]+nums[j]+nums[k];
                    // 소수 판별
                    boolean isSosu = true;
                    for(int a=2; a<num; a++) {
                        if(num%a == 0) {
                            isSosu = false;
                        }
                    }
                    if(isSosu) answer++;
                }
            }
        }

        return answer;
    }

    // 2. 2~루트N 사이의 자연수로 나누어지는지 판별
    static public int solution2(int[] nums) {
        int answer = 0;

        // 서로 다른 3개의 수 조회
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    int num = nums[i]+nums[j]+nums[k];
                    // 소수 판별
                    boolean isSosu = true;
                    for(int a=2; a<=Math.sqrt(num); a++) {
                        if(num%a == 0) {
                            isSosu = false;
                        }
                    }
                    if(isSosu) answer++;
                }
            }
        }

        return answer;
    }
}
