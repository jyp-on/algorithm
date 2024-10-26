class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0;
        int start = 0;
        
        for(int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            
            tank += gas[i] - cost[i];
            // System.out.printf("tank : %d, gas[%d] = %d, cost[%d] = %d\n", tank, i, gas[i], i, cost[i]);
            if(tank < 0) {
                // 현재 위치까지 도달 불가능하므로
                // 다음 위치부터 다시 시작
                start = i + 1;
                tank = 0;
            }
        }
        
        // 전체 gas가 전체 cost보다 작으면 불가능
        return totalGas < totalCost ? -1 : start;
    }
}