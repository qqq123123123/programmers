package programmers;

public class MakePrimeNumber {
    public static void main(String[] args) {

        //https://programmers.co.kr/learn/courses/30/lessons/12977?language=java
        Solution solution = new Solution();
        int[] nums1 = new int[] {1,2,3,4};
        int[] nums2 = new int[] {1,2,7,6,4};

        int answer1 = solution.solution(nums1);
        int answer2 = solution.solution(nums2);

        System.out.println(answer1);
        System.out.println(answer2);
    }
}

class Solution 
{
    public int solution(int[] nums) 
    {
        int answer = 0;

        for(int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++) 
            {
                for (int k = j + 1; k < nums.length; k++) 
                {
                    answer += findPrime(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        return answer;
    }

    public int findPrime(int num)
    {
        for(int i = 2; i < num; i++)
        {
            if(num % i == 0)
            {
                return 0;
            }
        }
        return 1;
    }
}

