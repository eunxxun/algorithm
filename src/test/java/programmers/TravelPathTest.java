package programmers;

import org.junit.Test;

import static org.junit.Assert.*;

public class TravelPathTest {

    @Test
    public void travelPathTest1() {
        TravelPath travelPath = new TravelPath();
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] solved = travelPath.solution(tickets);
        String[] target = {"ICN","JFK","HND", "IAD"};
        assertArrayEquals(solved, target);
    }

    @Test
    public void travelPathTest2() {
        TravelPath travelPath = new TravelPath();
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[] solved = travelPath.solution(tickets);
        String[] target = {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
        assertArrayEquals(solved, target);
    }

}