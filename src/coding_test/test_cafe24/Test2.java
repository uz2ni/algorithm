package coding_test.test_cafe24;

import java.io.*;

public class Test2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int currentPlanCost, usage, currentPlanTotalCost = 0, recommendedPlanCost = 0, minimumRecommendedCost = 200000;
        int[][] plan = {
                {29900, 300},
                {34900, 1000},
                {39900, 2000},
                {49900, 6000},
                {59900, 11000},
                {69900, -1}
        };

        String[] input = br.readLine().split(" ");
        currentPlanCost = Integer.parseInt(input[0]);
        usage = Integer.parseInt(input[1]);

        int totalCost, additionalCost;
        for (int i=0; i<plan.length; i++) {
            if (i == 5) {
                additionalCost = 0;
            } else {
                if (usage > plan[i][1]) {
                    additionalCost = usage - plan[i][1];
                } else {
                    additionalCost = 0;
                }

                if (additionalCost * 20 > 25000 && additionalCost < 5000) {
                    additionalCost = 25000;
                } else if (additionalCost * 20 > 180000) {
                    additionalCost = 180000;
                } else {
                    additionalCost *= 20;
                }
            }

            // 현재 요금 계산
            if (plan[i][0] == currentPlanCost) {
                currentPlanTotalCost = plan[i][0] + additionalCost;
                continue;
            }
            totalCost = plan[i][0] + additionalCost;
            if (totalCost < minimumRecommendedCost) {
                minimumRecommendedCost = totalCost;
                recommendedPlanCost = plan[i][0];
            }
        }

        System.out.println(recommendedPlanCost + " " + currentPlanTotalCost + " " + minimumRecommendedCost);
    }
}
