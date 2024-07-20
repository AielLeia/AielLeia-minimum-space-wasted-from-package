package com.ismaelmohamedbouh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("fournirCasDeTest")
    void testEspaceMinimalPerdu(int[] paquets, int[][] boites, int attendu) {
        assertEquals(attendu, solution.minWastedSpace(paquets, boites));
    }

    private static Stream<Arguments> fournirCasDeTest() {
        return Stream.of(
            Arguments.of(
                new int[]{2, 3, 5},
                new int[][]{{4, 8}, {2, 8}},
                6
            ),
            Arguments.of(
                new int[]{2, 3, 5},
                new int[][]{{1, 4}, {2, 3}, {3, 4}},
                -1
            ),
            Arguments.of(
                new int[]{1, 2, 3},
                new int[][]{{4, 5, 6}, {3, 4, 5}},
                3
            ),
            Arguments.of(
                new int[]{10, 20},
                new int[][]{{30, 40}, {20, 50}},
                10
            ),
            Arguments.of(
                new int[]{7, 5, 3, 2},
                new int[][]{{10, 20}, {5, 7, 8}},
                5
            ),
            Arguments.of(
                new int[]{1, 5, 8},
                new int[][]{{2, 8, 10}, {5, 6, 7}},
                4
            )
        );
    }
}
