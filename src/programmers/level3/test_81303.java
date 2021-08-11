package programmers.level3;

import java.util.LinkedList;
import java.util.Stack;

/*
    2021 카카오 채용연계형 인턴십 - 표 편집
 */
public class test_81303 {
    public static void main(String[] args) {
        int n = 8, k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        //String[] cmd = {"U 2", "D 4", "C", "D 2","Z", "C"};
        System.out.println(solution(n,k,cmd));
    }
    public static String solution(int n, int k, String[] cmd) {
        String answer = "";


        Stack<BackValue> backList = new Stack<>();
        LinkedList<Integer> arr = new LinkedList<>();
        LinkedList<Integer> arr2 = new LinkedList<>();
        for(int i=0; i<n; i++) {
            arr.add(i);
            arr2.add(i);
        }

        for(int i=0; i<cmd.length; i++) {

            // 명령어, 인자 분리
            String[] ch = cmd[i].split(" ");
            String a = ch[0];                // 명령문자
            int x = 0;
            if(ch.length == 2) {
                x = Integer.parseInt(ch[1]); // 칸 숫자
            }

            switch(ch[0]) {
                case "U":
                    // 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
                    k = k-x;

                break;
                case "D":
                    // 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
                    k = k+x;

                break;
                case "C":
                    // 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
                    if(arr.size()-1 == k) { // 마지막 행인 경우 윗행 선택
                        k = k-1;
                        BackValue bv = new BackValue(arr.get(arr.size()-1), arr.size()-1);
                        backList.push(bv);
                        arr.remove(arr.size()-1);

                    }else {
                        BackValue bv = new BackValue(arr.get(k), k);
                        backList.push(bv);
                        arr.remove(k);
                    }

                break;
                case "Z":
                    // 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
                    BackValue bv = backList.pop();
                    if(bv.idx < arr.size()) {
                        arr.add(bv.idx, bv.backVal);
                        k++;
                    }else {
                        arr.add(bv.idx, bv.backVal);
                    }


                break;

            }
        }
        // 비교확인
        String result = "";
        for(int i=0; i<arr2.size(); i++) {
            boolean isUse = false;
            for(int j=0; j<arr.size(); j++) {
                if(arr2.get(i) == arr.get(j)) {
                    result = result + "O";
                    isUse = true;
                    break;
                }
            }
            if(!isUse) {
                result = result + "X";
            }

        }


        return result;
    }

    static public void printNow(LinkedList<Integer> arr, int k) {
        for(int i=0; i<arr.size(); i++) {
            if(i == k) {
                System.out.print("[" + arr.get(i) + "]" + ",");
            }else {
                System.out.print(arr.get(i) + ",");
            }
        }
        System.out.println();
    }

    public static class BackValue {
        int backVal;
        int idx;
        BackValue(int a, int b) {
            this.backVal = a;
            this.idx = b;
        }
    }
}