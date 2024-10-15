class Solution {
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(rooms, rooms.get(0));

        boolean ans = true;
        for(boolean x : visited) {
            if(!x) {
                ans = false;
                break;
            }
        }

        return ans;
    }

    public void dfs(List<List<Integer>> rooms, List<Integer> enter) {
        for(int key : enter) {
            if(!visited[key]) {
                visited[key] = true;
                dfs(rooms, rooms.get(key));
            }
        }
    }
}