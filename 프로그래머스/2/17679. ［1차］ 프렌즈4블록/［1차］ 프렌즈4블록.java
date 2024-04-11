import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] table = new char[m][n];
        for(int i=0;i<m;i++){
            table[i]=board[i].toCharArray();
        }
        //몇번 지워질지 모르니 무한반복
        while(true){
            boolean flag=true;
            boolean[][] check =new boolean[m][n];
            //블록체크
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if(table[i][j]=='x'){
                        continue;
                    }
                    char a =table[i][j];
                    if(table[i][j+1]==a&&table[i+1][j]==a&&table[i+1][j+1]==a){
                        check[i][j]=true;
                        check[i][j+1]=true;
                        check[i+1][j]=true;
                        check[i+1][j+1]=true;
                        flag=false;
                    }
                }
            }

            //블록체크가 안됬으면 == 지울 블록이없으면 반복문 종료
            if(flag){
                break;
            }
            //체크된 블록 삭제("x"으로 변환)
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(check[i][j]){
                        table[i][j]='x';
                        answer++;
                    }
                }
            }
            //블록 내리기 (윗블록과 스왑하기)
            for(int i=m-1;i>=0;i--){
                for(int j=n-1;j>=0;j--){
                    if(table[i][j]=='x'){
                       for(int k=i-1;k>=0;k--){
                           if(table[k][j]=='x'){
                               continue;
                           }
                           table[i][j]=table[k][j];
                           table[k][j]='x';
                           break;
                       }
                    }
                }
            }
        }   
        return answer;
    }
    
    public static void print(char[][] table) {
        for(char[] a : table) {
            for(char b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}