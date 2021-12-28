package programmers.hash1;

import java.util.ArrayList;
import java.util.HashSet;

public class hash1 {
    public static void main(String[] args) {
        String[] participation = {"abc", "def", "g", "h", "i"};
        ArrayList<String> stringArr = new ArrayList<String>();
        // HashSet
        for(String s : participation)
        {
            stringArr.add(s);
        }
        if(stringArr.contains("abc"))
        {
            stringArr.remove("abc");
            stringArr.get(0);
        }
        for(String s : stringArr)
        {
            System.out.println(s);
        }
    }
}
