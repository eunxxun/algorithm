package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaratonTest {
    @Test
    public void maratonTest() {
        String[] p1 = {"leo", "kiki", "eden"};
        String[] c1 = {"eden", "kiki"};
        String[] p2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] c2 = {"josipa", "filipa", "marina", "nikola"};
        String[] p3 = {"mislav", "stanko", "mislav", "ana"};
        String[] c3 = {"stanko", "ana", "mislav"};
        Maraton m = new Maraton();
        assertEquals(m.solution(p1, c1), "leo");
        assertEquals(m.solution(p2, c2), "vinko");
        assertEquals(m.solution(p3, c3), "mislav");
    }
}