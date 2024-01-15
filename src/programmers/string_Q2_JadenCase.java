package programmers;

class string_Q2_JadenCase {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        // 다 소문자로 바꾸고 시작
        s = s.toLowerCase();

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);

            if(isFirst){
                if(c >= 97 && c <= 122)
                    c -= 32;
            }

            isFirst = (s.charAt(i) == ' ') ? true : false;
            sb.append(c);
        }

        answer = sb.toString();

        return answer;
    }
}