package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class NetworkTest {
    @Test
    public void networkTest() {
        Network nw = new Network();
        assertEquals(nw.solution(3, new int[][]{{1,1,0}, {1,1,0}, {0,0,1}}), 2);
        assertEquals(nw.solution(3, new int[][]{{1,1,0}, {1,1,1}, {0,1,1}}), 1);
    }
}