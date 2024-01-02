package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class PirodoTest {

    @Test
    public void pirodoTest100() {
        Pirodo pirodo = new Pirodo();
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int result = pirodo.solution(80, dungeons);
        assertEquals(3, result);
    }

}