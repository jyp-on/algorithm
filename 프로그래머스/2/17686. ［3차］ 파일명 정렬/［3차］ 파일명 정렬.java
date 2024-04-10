import java.util.*;
class Solution {
    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String fileA, String fileB) {
                String[] s_fileA = seperateHeadAndNumber(fileA);
                String[] s_fileB = seperateHeadAndNumber(fileB);
                int res = s_fileA[0].compareTo(s_fileB[0]);
                
                if(res == 0) { // 헤더가 같은 경우
                    int a = Integer.parseInt(validateNumber(s_fileA[1]));
                    int b = Integer.parseInt(validateNumber(s_fileB[1]));
                    return a - b;
                }
                
                return res;
            }
        });
 
        return files;
    }
    
    public static String[] seperateHeadAndNumber(String file) {
        file = file.toUpperCase();
        String head = file.split("[0-9]")[0];
        String number = file.substring(head.length());
        return new String[]{head, number};
    }
    
    public static String validateNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length(); i++) {
            if(i < 5 && Character.isDigit(number.charAt(i))) {
                sb.append(number.charAt(i));
            } else break;
        }
        return sb.toString();
    }
 
}