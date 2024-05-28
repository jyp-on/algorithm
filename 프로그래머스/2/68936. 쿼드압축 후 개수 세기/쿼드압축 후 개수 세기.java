class Solution {
    static int[] answer;
    public boolean zip(int[][] arr, int x, int y, int size, int val) {
        for(int i = x; i < x + size; i++)
            for(int j = y; j < y + size; j++)
                if(arr[i][j] != val)
                    return false;
        return true;
    }
    public void quad(int[][] arr, int x, int y, int size){
        if(zip(arr,x,y,size, arr[x][y])){ // 좌측 상단의 값으로 압축되는지
            if(arr[x][y] == 1) // 압축이 1로 됬다면
                answer[1]++;
            else answer[0]++; // 압축이 0으로 됬다면
            return ;
        }
        quad(arr,x,y, size/2); // 왼쪽 위
        quad(arr,x,y + size/2, size/2); // 왼쪽 아래
        quad(arr,x+size/2,y, size/2); // 오른쪽 위
        quad(arr,x+size/2,y + size/2, size/2); // 오른쪽 아래
    }
    public int[] solution(int[][] arr) {
        answer = new int[2];
        quad(arr,0,0,arr.length);
        return answer;
    }
}