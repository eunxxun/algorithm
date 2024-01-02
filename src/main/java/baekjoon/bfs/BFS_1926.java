package baekjoon.bfs;

/**
 * 1. 아이디어
 - 2중 포문 -> 값 == 1 && 방문 X => BFS
 - BFS 돌면서 그림갯수 + 1, 최대값 갱신

 2. 시간복잡도
 - BFS : O(V+E) = O(5mn)
 - V : m*n = 500*500
 - E : v*4 = 500*4
 - V+E : 5 * 250000 = 100만 < 2억 >> 가능!

 3. 자료구조
 - 그래프 전체 지도 : int[][]
 - 방문 : bool[][]
 - Queue(BFS)
 * */
public class BFS_1926 {
}
