package programmers;

public class AbsCalc {
    public static void main(String[] args) {
        //https://programmers.co.kr/learn/courses/30/lessons/76501
        Solution solution = new Solution();
        int[] absolutes1 = new int[] {4, 7, 12};
        int[] absolutes2 = new int[] {1, 2, 3};

        boolean[] signs1 = new boolean[] {true, false, true};
        boolean[] signs2 = new boolean[] {false, false, true};

        int answer1 = solution.calc(absolutes1, signs1);
        int answer2 = solution.calc(absolutes2, signs2);

        System.err.println(answer1);
        System.out.println(answer2);
    }
}

class Solution
{
    public int calc(int[] absolutes, boolean[] signs)
    {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++)
        {
            if(signs[i] == true)
            {
                answer += absolutes[i];
            }
            else
            {
                answer += (absolutes[i] * -1);
            }
        }
        return answer;
    }
}
