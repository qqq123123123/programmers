package programmers.string;

public class RecommandNewId
{
    public static void main(String[] args) {
        RecommandNewIdSolution sol1 = new RecommandNewIdSolution();
        System.out.println(sol1.solution("abcdefghijklmn.p"));
        
    }
}

class RecommandNewIdSolution
{
    public String solution(String new_id) 
    {
        String answer = "";
        String str1 = new_id;
        str1 = str1.toLowerCase();
        str1 = str1.replaceAll("[^a-z\\d\\-_.]*", "");
        StringBuilder strBuilder1 = new StringBuilder(str1);
        int checkPoint = -2;
        int strLength = strBuilder1.length();
        for(int i = 0; i < strLength; i++)
        {
            if(strBuilder1.charAt(i) == '.')
            {
                if(checkPoint == i - 1)
                {
                    strBuilder1 = strBuilder1.deleteCharAt(i);
                    i -= 1;
                    strLength -= 1;
                }
                checkPoint = i;
            }
        }
        str1 = strBuilder1.toString();
        
        if(str1.charAt(0) == '.')
        {
            strBuilder1 = strBuilder1.deleteCharAt(0);
        }
        str1 = strBuilder1.toString();
        
        // 4-2 마침표가 마지막에 있는지 확인
        if(str1.length() > 0 && strBuilder1.charAt(strBuilder1.length()-1) == '.')
        {
            strBuilder1 = strBuilder1.deleteCharAt(str1.length()-1);
        }
        str1 = strBuilder1.toString();
        
        // 5단계: 빈 문자열일 경우 a로 바꾸기
        if("".equals(str1))
        {
            str1 = "a";
        }

        // 6단계: 16글자 이상일 경우 15글자 까지만 살린다.
        if(str1.length() >= 16)
        {
            str1 = str1.substring(0,15); 
        }
        
        // 6-2 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        strBuilder1 = new StringBuilder(str1);
        if(strBuilder1.charAt(strBuilder1.length()-1) == '.')
        {
            strBuilder1 = strBuilder1.deleteCharAt(strBuilder1.length()-1);
        }
        str1 = strBuilder1.toString();


        // 7단계: new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(str1.length() <= 2)
        {
            for(int i = str1.length(); i < 3; i++)
            {
                str1 += str1.charAt(str1.length()-1);
            }
        }
        answer = str1;
        return answer;
    }
}
