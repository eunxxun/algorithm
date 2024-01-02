package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Leet_0130Test {
    @Test
    public void surroundedRegionsTest_1() {
        Leet_0130 test = new Leet_0130();

        char[][] board = new char[][]
                {{'X','X','X','X'},
                        {'X','O','O','X'},
                        {'X','X','O','X'},
                        {'X','O','X','X'}};

        test.solve(board);

        char[][] target = new char[][]
                {{'X','X','X','X'},
                        {'X','X','X','X'},
                        {'X','X','X','X'},
                        {'X','O','X','X'}};

        assertArrayEquals(board, target);
    }

    @Test
    public void surroundedRegionsTest_2() {
        Leet_0130 test = new Leet_0130();

        char[][] board = new char[][]
                {{'X'}};

        test.solve(board);

        char[][] target = new char[][]
                {{'X'}};

        for (int i = 0; i < target.length; ++i) {
            for (int j = 0; j < target[0].length; ++j) {
                assertEquals(target[i][j], board[i][j]);
            }
        }
    }

    @Test
    public void surroundedRegionsTest_3() {
        Leet_0130 test = new Leet_0130();

        char[][] board = new char[][]
                {   {'O','O','X','X'},
                        {'X','X','O','X'},
                        {'O','O','X','X'},
                        {'X','O','X','O'}};

        test.solve(board);

        char[][] target = new char[][]
                {   {'O','O','X','X'},
                        {'X','X','X','X'},
                        {'O','O','X','X'},
                        {'X','O','X','O'}};

        assertArrayEquals(board, target);
    }

    @Test
    public void surroundedRegionsTest_4() {
        Leet_0130 test = new Leet_0130();

        char[][] board = new char[][]
                {   {'O','X','X','O','X'},
                        {'X','O','O','X','O'},
                        {'X','O','X','O','X'},
                        {'O','X','O','O','O'},
                        {'X','X','O','X','O'}};

        test.solve(board);

        char[][] target = new char[][]
                {   {'O','X','X','O','X'},
                        {'X','X','X','X','O'},
                        {'X','X','X','O','X'},
                        {'O','X','O','O','O'},
                        {'X','X','O','X','O'}};

        assertArrayEquals(board, target);
    }

    @Test
    public void surroundedRegionsTest_5() {
        Leet_0130 test = new Leet_0130();

        char[][] board = new char[][]
                {   {'O','X','O','O','O','O','O','O','O'},
                        {'O','O','O','X','O','O','O','O','X'},
                        {'O','X','O','X','O','O','O','O','X'},
                        {'O','O','O','O','X','O','O','O','O'},
                        {'X','O','O','O','O','O','O','O','X'},
                        {'X','X','O','O','X','O','X','O','X'},
                        {'O','O','O','X','O','O','O','O','O'},
                        {'O','O','O','X','O','O','O','O','O'},
                        {'O','O','O','O','O','X','X','O','O'}};

        test.solve(board);

        char[][] target = new char[][]
                {   {'O','X','O','O','O','O','O','O','O'},
                        {'O','O','O','X','O','O','O','O','X'},
                        {'O','X','O','X','O','O','O','O','X'},
                        {'O','O','O','O','X','O','O','O','O'},
                        {'X','O','O','O','O','O','O','O','X'},
                        {'X','X','O','O','X','O','X','O','X'},
                        {'O','O','O','X','O','O','O','O','O'},
                        {'O','O','O','X','O','O','O','O','O'},
                        {'O','O','O','O','O','X','X','O','O'}};

        assertArrayEquals(board, target);
    }
}