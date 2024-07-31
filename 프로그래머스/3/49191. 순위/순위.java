class Solution {
    /**
    * 1. 그래프를 이용한다.
    * 2. 자신이 몇등인지 어떻게 알 수 있지?
    *    - 자기 자신의 경기 결과를 전부 알수있으면 ? 5명일때 (승이 4개면 1등), (3승1패면 2등), (2승2패면, 3등)..
    * 3. 모든 사람의 경기 경과를 알고싶다? 플로이드워셜 알고리즘 사용
    *    - A와 B의 최단 거리를  K를 거쳐서 판단한다.
    *      graph[a][b] = min(graph[a][b], graph[a][k], graph[b][k])
    */
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n+1][n+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=n; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=0; i<results.length; i++) {
            int[] result = results[i];
            int win = result[0];
            int lose = result[1];
            
            graph[win][lose] = 1;
            graph[lose][win] = -1;
        }
        
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(graph[i][j] == Integer.MAX_VALUE) {
                        // i가 k를 이기고, k가 j를 이기면 i가 j를 이긴다.
                        if(graph[i][k] == 1 &&  graph[k][j] == 1)  {
                            graph[i][j] = 1;
                        } // i가 k한테 지고, k가 j한테 지면 i는 j한테 진다.
                        else if(graph[i][k] == -1 && graph[k][j] == -1) {
                            graph[i][j] = -1;
                        }
                    }
                }
            }
        }
        
        
        for(int i=1; i<=n; i++) {
            boolean check = true;
            
            for(int j=1; j<=n; j++) {
                // 등수를 알 수 없음
                if(i !=j && graph[i][j] == Integer.MAX_VALUE) {
                    check = false;
                    break;
                } 
            }
            
            if(check) {
               answer++; 
            }
        }
        return answer;
    }
}