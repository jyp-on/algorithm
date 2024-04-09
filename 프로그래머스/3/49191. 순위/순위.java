class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];
		for (int[] edge : results) {
			graph[edge[0]][edge[1]] = 1; // a가 이김
			graph[edge[1]][edge[0]] = - 1; // a가 짐
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
                    //i가 k를 이기고 k가 j를 이겼으면 (i는 j를 이김 -> j는 i에게 짐)
					if(graph[i][k] == 1 && graph[k][j] == 1) {
						graph[i][j] = 1;
						graph[j][i] = -1;
					}
                    //i가 k에게 지고 k가 j에게 지면 (i는 j에게 짐 -> j는 i에게 이김)
					if(graph[i][k] == -1 && graph[k][j] == -1) {
						graph[i][j] = -1;
						graph[j][i] = 1;
					}
				}
			}
		}
        
		int answer = 0;
		
		for(int i = 0 ; i <=n; i++) {
			int count = 0;
			for (int j = 0; j <= n; j++) {
				if(graph[i][j] != 0) count++; // 0이 아니면 승패를 알 수 있음
			}
			if(count == n-1) answer++; // 본인을 제외한 n-1명과의 승패를 알면 등수를 알 수 있음
		}
        return answer;
    }
}