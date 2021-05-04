package programmers.level1;

public class test_72410 {
    public static void main(String[] args) {
        System.out.println(solution("123_.def"));
    }
    static public String solution(String new_id) {
        String answer = "";

//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();

        String new_id2 = "";
//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        for(int i=0; i<new_id.length(); i++) {
            if(('a' <= new_id.charAt(i) && new_id.charAt(i) <= 'z') || ('0' <= new_id.charAt(i) && new_id.charAt(i) <= '9') || new_id.charAt(i) == '-'|| new_id.charAt(i) == '_'|| new_id.charAt(i) == '.') {
                new_id2 += new_id.charAt(i);
            }
        }
//        System.out.println(new_id2);
//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String new_id3 = "";
        for(int i=0; i<new_id2.length(); i++) {
            if(i != 0 && (new_id2.charAt(i) == '.') && (new_id2.charAt(i-1) == '.')) continue;
            new_id3 += new_id2.charAt(i);
        }
//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        String new_id4 = "";
        for(int i=0; i<new_id3.length(); i++) {
            if( (i==0 || i==new_id3.length()-1) && new_id3.charAt(i) == '.') continue;
            new_id4 += new_id3.charAt(i);
        }

//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        String new_id5 = "";
        new_id5 = new_id4.isEmpty() ? "a" : new_id4;

//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        String new_id6 = "";
        new_id6 = new_id5.length() >= 16 ? new_id5.substring(0, 15) : new_id5;
        new_id6 = new_id6.charAt(new_id6.length()-1) == '.' ? new_id6.substring(0, new_id6.length()-1) : new_id6;
//                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.

//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        String new_id7 = "";
        if(new_id6.length() <= 2) {
            new_id7 = new_id6;
            char ch = new_id6.charAt(new_id6.length()-1);
            for(int i=new_id6.length(); i<3; i++) {
                new_id7 += ch;
            }
        }else {
            new_id7 = new_id6;
        }

        return new_id7;
    }
}
