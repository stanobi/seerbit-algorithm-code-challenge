package org.seerbit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxXORSubarrayTest {

    @Test
    void given_emptyArray_when_getMaxXOR_should_returnZero() {
        int[] numbers = {};
        Assertions.assertEquals(0, MaxXORSubarray.getMaxXOR(numbers));
    }

    @Test
    void given_nonEmptyArray_when_getMaxXOR_should_returnValidValue() {
        int[] numbers = {1, 2, 3, 4};
        Assertions.assertEquals(7, MaxXORSubarray.getMaxXOR(numbers));

        int[] numbers2 = {8, 10, 2, 15, 5, 17, 46};
        Assertions.assertEquals(63, MaxXORSubarray.getMaxXOR(numbers2));
    }

}