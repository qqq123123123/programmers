package programmers.array;

import java.util.ArrayList;
import java.util.HashMap;


public class getReportResult {
    public static void main(String[] args) {
        //https://programmers.co.kr/learn/courses/30/lessons/92334
        String[] id_list = new String[] {"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[] {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int[] result = new int[id_list.length];
        int k = 2;

        result = solution2(id_list, report, k);

        for(int i : result)
        {
            System.out.print(i + " ");
        }

    }

    public static int[] solution(String[] id_list, String[] report, int k) // 해결 x
    {
        int[] answer = new int[id_list.length];

        /*
        1. 중간 공백을 기준으로 나눠서 2차원 배열 생성
        2. id_list길이 새 배열 파서 신고 횟수 카운트 하기
        3. 카운트 만족하는 애 찾아서 +1 해주기
        
        */
        HashMap <String, Integer> reportCounts = new HashMap<String, Integer>();

        for(int i = 0; i < id_list.length; i++)
        {
            reportCounts.put(id_list[i], 0);
        }

        // map.put(key, map.get(key) + 1)

        String[][] reports = new String[report.length][2];
        for(int i = 0; i < report.length; i++) // 2차원 배열 생성
        {
            reports[i] = report[i].split(" ");
            System.out.println(reports[i][0] + " " + reports[i][1]);
        }

        for(int i = 0; i < reports.length; i++) // 중복체크
        {
            for(int j  = 0; j < reports.length; j++)
            {
                if(i == j)
                {
                    continue;
                }
                else
                {
                    if(reports[i][0].equals(reports[j][0]) && reports[i][1].equals(reports[j][1]))
                    {
                        continue;
                    }
                    else
                    {
                        reportCounts.put(reports[i][1], reportCounts.get(reports[i][1]) + 1);
                    }
                }
            }
        }

        reportCounts.forEach((key, value) ->
        {
            if(value >= k)
            {
                for(int i = 0; i < reports.length; i++)
                {
                    // if()
                }
            }
        });
        return answer;
    }

    public static int[] solution2(String[] id_list, String[] report, int k)
    {
        /*
            ************시간 복잡도 개선하기**************
        */
        /*
        1. 중복 제거 후 
        2. " "로 split해서 2차원 배열로 쪼개서 신고한놈, 신고당한놈 분리
        */
        int[] answer = new int[id_list.length];

        ArrayList<String> reportArrayList = new ArrayList<String>();

        for(String item : report) // 중복 제거 및 배열에 넣기
        {
            if(!reportArrayList.contains(item))
            {
                reportArrayList.add(item);
            }
        }

        String[][] reportDB = new String[reportArrayList.size()][2];
        for(int i = 0; i < reportArrayList.size(); i++)
        {
            reportDB[i] = reportArrayList.get(i).split(" ");
            // System.out.println(reportDB[i][0] + " " + reportDB[i][1] + " 체크"); // 배열이 제대로 들어갔는지 체크
        }

        HashMap <String, Integer> reportCountMap = new HashMap<String, Integer>(); // 신고횟수 카운트용
        HashMap <String, Integer> MailCountMap = new HashMap<String, Integer>(); // 메일 회신 카운트용 (답안)


        for(int i = 0; i < id_list.length; i++)
        {
            reportCountMap.put(id_list[i], 0); // 신고 횟수 카운트 용
            MailCountMap.put(id_list[i], 0); // 메일 송부 카운트 용 (answer)
        }

        for(int i = 0; i < reportDB.length; i++) // 신고 카운트
        {
            reportCountMap.put(reportDB[i][1], reportCountMap.get(reportDB[i][1]) + 1);
        }

        /*
            string 전역변수 한개하고
            k 2면 거기 넣고
            for문 돌려서
            reportDB에서 reportDB[i][1] 이 key인 놈을 찾아서 숫자 
        */
        reportCountMap.forEach((key, value) ->
        {
            if(value >= k)
            {
                for (int i = 0; i < reportDB.length; i++) 
                {
                    
                    String report11 = null;
                    if(reportDB[i][1].equals(key))
                    {
                        report11 = reportDB[i][0];
                        MailCountMap.put(report11, MailCountMap.get(report11) + 1);
                    }
                }
            }
        });

        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = MailCountMap.get(id_list[i]);
        }

        return answer;
    }
}
