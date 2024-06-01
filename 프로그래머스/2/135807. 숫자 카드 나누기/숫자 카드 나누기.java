class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int max = 0;
        
        for(int i=0; i<arrayA.length; i++) {
            max = Math.max(max, arrayA[i]);
            max = Math.max(max, arrayB[i]);
        }
        
        for(int i=max; i>=1; i--) {
            boolean firstA = false; // A의 첫 원소가 0으로 나눠지면 true
            boolean firstB = false; // B의 첫 원소가 0으로 나눠지면 true
            
            if(arrayA[0] % i == 0) {
                firstA = true; 
            }
            
            if(arrayB[0] % i == 0) {
                firstB = true;
            }
            
            if(firstA == firstB) continue;
            
            boolean flag = true;
            
            if(firstA && !firstB) {
                for(int k=1; k<arrayA.length; k++) {
                    if(arrayA[k] % i != 0 || arrayB[k] % i == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if(!firstA && firstB) {
                for(int k=1; k<arrayA.length; k++) {
                    if(arrayA[k] % i == 0 || arrayB[k] % i != 0) {
                        flag = false;
                        break;
                    }
                }
            }
            
            if(flag) 
                return i;
        }
        return 0;
    }
}