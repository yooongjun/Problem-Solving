package programmers;

class string_Q1_문자열압축 {
    public int solution(String s) {
        int answer = s.length();

        // 단위별로 잘라서 조사 ( 1 ~ 문자열 /2 길이까지)
        for(int i = 1; i <= s.length()/2; i++){
            answer = Math.min(compressStr(s, i), answer);
        }

        return answer;
    }

    int compressStr(String s, int unit){
        int length = s.length();

        // 유닛 단위로 쪼개기
        for(int i = 0; i + unit <= s.length(); i += unit)
        {
            // 현재 유닛
            String cur_unit = s.substring(i, i + unit);

            // 현재 유닛의 개수
            int cur_unit_count = 1;

            for(int j = i + unit; j + unit <= s.length(); j += unit ){
                // 다음 유닛
                String next_unit = s.substring(j, j + unit);
                i = j - unit;
                // 다음 유닛과 현재 유닛이 일치하는 경우 압축시킵니다
                if(cur_unit.equals(next_unit)){
                    length -= unit;
                    cur_unit_count++;
                    continue;
                }

                break;
            }

            length += ((cur_unit_count > 1) ? String.valueOf(cur_unit_count).length() : 0);


        }

        return length;
    }

}