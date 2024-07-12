class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int lt = 0, rt = arr.length - 1;
        while(lt < rt) {
            boolean lt_flag = check(arr[lt]);
            boolean rt_flag = check(arr[rt]);
            if(lt_flag && !rt_flag) {
                rt--;
            } else if(!lt_flag && rt_flag) {
                lt++;
            } else if(!lt_flag && !rt_flag) {
                rt--; lt++;
            } else { // lt_flag && rt_flag
                // swap
                char temp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = temp;
                rt--; lt++;
            }
        }
        
        return String.valueOf(arr);
    }

    public boolean check(char t) { // 모음인지 확인 할 때에는 소문자로 바꿔서 비교
        char x = Character.toLowerCase(t);
        for(char item : new char[]{'a', 'e', 'i', 'o', 'u'}) {
            if(x == item) return true;
        }
        return false;
    }
}