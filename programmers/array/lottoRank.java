class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int win_counts = 0;
        int zero_counts = 0;
        for(int i = 0; i < lottos.length; i++)
        {
            if(lottos[i] == 0)
            {
                zero_counts++;
            }
            else
            {
                for(int j = 0; j < win_nums.length; j++)
                {
                    if(lottos[i] == win_nums[j])
                    {
                        win_counts++;
                    }
                }    
            }
        }
        
        int best = 7 - (win_counts + zero_counts);
        int worst = 7 - win_counts;
        if(best == 7)
        {
            best = 6;
        }
        if (worst == 7 || worst == 6)
        {
            worst = 6;
        }
        
        answer[0] = best;
        answer[1] = worst;
        return answer;
        
    }
}
