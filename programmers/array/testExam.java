package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class testExam {
    public static void main(String[] args) {
        // 모의고사
        // https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=java

        /*
            한국어 변수 사용하니까 타자가 더 많아져서 귀찮다
        
        */ 

        int[] question2 = {1,2,3,4,5};
        int[] question1 = {1,3,2,4,2};

        int[] 수포1 = {1,2,3,4,5};
        int[] 수포2 = {2,1,2,3,2,4,2,5};
        int[] 수포3 = {3,1,2,4,5};
        int 수포1Count = 0;
        int 수포2Count = 0;
        int 수포3Count = 0;
        int 수포3Count보조 = 0;
        

        int[] result = {0,0,0};

        for(int i = 0; i < question1.length; i++)
        {
            //수포1
            if(question1[i] == 수포1[수포1Count])
            {
                result[0]++;
            }
            //수포2
            if(question1[i] == 수포2[수포2Count])
            {
                result[1]++;
            }
            
            //수포3
            if(question1[i] == 수포3[(수포3Count % 5)] )
            {
                result[2]++;
            }
            
            수포1Count++;
            수포2Count++;
            수포3Count보조++;
            if(수포3Count보조 % 2 == 0) // 2번 썼는지 체크
            {
                수포3Count++;
            }

            // 수포카운트 초기화
            if(수포1Count > 수포1.length - 1)
            {
                수포1Count = 0;
            }
            if(수포2Count > 수포2.length - 1)
            {
                수포2Count = 0;
            }
        }
        
        // 인덱스 값 찾아서 누가 많이 맞췄는지 리턴
        int max = 0;
        ArrayList<Integer> test1 = new ArrayList<Integer>();
        for(int i = 0; i < result.length; i++)
        {
            if(result[i] != 0 && result[i] == max)
            {
                test1.add(i+1);
            }
            if(result[i] > max)
            {
                test1.clear();
                test1.add(i+1);
                max = result[i];
            }

        }

        int[] whoIsBest = new int[test1.size()];
        for(int i = 0; i < test1.size(); i++)
        {
            whoIsBest[i] = test1.get(i);
            System.out.println(whoIsBest[i]);
        }
    }
}

/*
    수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

    1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

    제한 조건
    시험은 최대 10,000 문제로 구성되어있습니다.
    문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
    입출력 예
    answers	return
    [1,2,3,4,5]	[1]
    [1,3,2,4,2]	[1,2,3]
    입출력 예 설명
    입출력 예 #1

    수포자 1은 모든 문제를 맞혔습니다.
    수포자 2는 모든 문제를 틀렸습니다.
    수포자 3은 모든 문제를 틀렸습니다.
    따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

    입출력 예 #2

    모든 사람이 2문제씩을 맞췄습니다.
    
 */
