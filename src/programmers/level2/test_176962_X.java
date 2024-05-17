package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* 과제 진행하기 */
public class test_176962_X {

    public static void main(String[] args) {

        String[][] plans = {
                {"math", "12:30", "40"},
                {"korean", "11:40", "30"}, // name, start, playtime
                {"english", "12:10", "20"}
        };

        String[] result = solution(plans);
//        System.out.println(result.toString());

    }

    public static String[] solution(String[][] plans) {
        String[] answer = {};
        ArrayList answerList = new ArrayList();
        ArrayList keepList = new ArrayList(); // 대기 플랜 (name, time)

        // 1. 시간순 정렬
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[1].compareTo(o2[1])<0) return -1;
                else return 1;
            }
        });

        for(int i=0; i<plans.length; i++) {
            if(i < plans.length-1) {
                int beforeTimeMin = convertMinuit(plans[i][1]);
                int afterTimeMin = convertMinuit(plans[i+1][1]);
                int subTimeMin = afterTimeMin - beforeTimeMin; // 후-전 시간차
                int duringMin = Integer.parseInt(plans[i][2]); // 전 소요 시간(분)

                if(duringMin-subTimeMin > 0) { // keep 저장
                    String[] keep = {plans[i][0], String.valueOf(duringMin-subTimeMin)};
                    keepList.add(keep);
                }else {
                    answerList.add(plans[i][0]); // 결과 추가
                    // 다음시간 전까지 keep 에서 차감

                }


            }else {
                // 마지막 꺼는 바로 결과 담기
                // 대기 플랜 결과 담기
            }
        }

        List<String[]> plansList = Arrays.stream(plans).toList();

//        for(String[]  plan : plansList) {
//            System.out.println(Arrays.stream(plan).toList());
//        }

        return answer;
    }

    public static int convertMinuit(String planTime) {
        int h = Integer.parseInt(planTime.split(":")[0]);
        int m = Integer.parseInt(planTime.split(":")[1]);
        return  (h * 60) + m;
    }

}
