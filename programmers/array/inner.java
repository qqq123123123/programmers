package programmers.array;

public class inner {
    public static void main(String[] args) {
        // https://programmers.co.kr/learn/courses/30/lessons/70128
        int[] a = new int[] {1,2,3,4,5};
        int[] b = new int[] {1,2,3,4,5};
        int answer = 0;
        int temp = 0;
        for(int i = 0; i < a.length; i++)
        {
            temp = a[i] * b[i];
            answer += temp;
        }
        System.out.println(answer);
    }
}
