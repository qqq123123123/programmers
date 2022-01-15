package programmers.array;

public class keypadPress {
    public static void main(String[] args) {
        String answer = "";
        int[] numbers = new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        answer = solution(numbers, hand);

        System.out.println(answer);
    }

    static String solution(int[] numbers, String hand) {
        String answer = "";
        
        Integer left = 10;
        Integer right = 12;
        
        int L_Distance = 0;
        int R_Distance = 0;

        for(int i = 0; i < numbers.length; i++)
        {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) // 1, 4, 7 왼손 고정 처리
            {
                answer += "L";
                left = numbers[i];
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) // 3, 6, 9 오른손 고정 처리
            {
                answer += "R";
                right = numbers[i];
            }
            else if(numbers[i] == 0) // 0 처리
            {
                L_Distance = Math.abs(((11 - left) / 3)) + Math.abs(((11 - left) % 3));
                R_Distance = Math.abs(((right - 11) / 3)) + Math.abs(((right - 11) % 3));
                if(L_Distance > R_Distance)
                {
                    answer += "R";
                    right = 11;
                }
                else if(L_Distance < R_Distance)
                {
                    answer += "L";
                    left = 11;
                }
                else
                {
                    if (hand.equals("left"))
                    {
                        answer += "L";
                        left = 11;
                    }
                    else
                    {
                        answer += "R";
                        right = 11;
                    }
                }
            }
            
            else // 2, 5, 8 처리
            {
                L_Distance = Math.abs(((numbers[i] - left) % 3)) + Math.abs(((numbers[i] - left) / 3));
                R_Distance = Math.abs(((right - numbers[i]) % 3)) + Math.abs(((right - numbers[i]) / 3));
                
                if(L_Distance < R_Distance)
                {
                    answer += "L";
                    left = numbers[i];
                }
                else if(L_Distance > R_Distance)
                {
                    answer += "R";
                    right = numbers[i];
                }
                else
                {
                    if(hand.equals("left"))
                    {
                        answer += "L";
                        left = numbers[i];
                    }
                    else
                    {
                        answer += "R";
                        right = numbers[i];
                    }
                }
            }
        }
        return answer;
    }
}
