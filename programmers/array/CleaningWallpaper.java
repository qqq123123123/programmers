package programmers;

public class CleaningWallpaper {
    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/161990
        int x1 = -1;
        int x2 = -1;
        int y1 = 2100000000;
        int y2 = -1;


        String[] param = {"..........", ".....#....", "......##..", "...##.....", "....#....."};

        for (int i = 0; i < param.length; i++) {
            for (int j = 0; j < param[i].length(); j++) {
                if(param[i].charAt(j) == '#'){
                    if(x1 == -1){
                        x1 = i;
                    }
                    if(j < y1){
                        y1 = j;
                    }
                    if(i > x2){
                        x2 = i;
                    }
                    if(j > y2){
                        y2 = j;
                    }
                }
            }
        }
        int[] result = new int[4];
        result[0] = x1;
        result[1] = y1;
        result[2] = x2 + 1;
        result[3] = y2 + 1;
        
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

/**
     
입출력 예
wallpaper	
result
[".#...", "..#..", "...#."]	
[0, 1, 3, 4]

["..........", ".....#....", "......##..", "...##.....", "....#....."]	
[1, 3, 5, 8]

[".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."]	
[0, 0, 7, 9]

["..", "#."]	
[1, 0, 2, 1]



    
    */
    
}
