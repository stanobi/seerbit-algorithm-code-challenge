package org.seerbit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.seerbit.model.TimestampInterval;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class MergeIntervalPairTest {

    @Test
    void given_emptyArray_when_collapseOverlap_should_returnEmptyArray() {
        MergeIntervalPair mergeIntervalPair = new MergeIntervalPair();
        Assertions.assertDoesNotThrow(() -> mergeIntervalPair.collapseOverlap(null));
        Assertions.assertTrue(mergeIntervalPair.collapseOverlap(null).isEmpty());
        Assertions.assertTrue(mergeIntervalPair.collapseOverlap(new ArrayList<>()).isEmpty());
    }

    @Test
    void given_non_overlaping_interval_when_collapseOverlap_should_returnSameIntervals() {

        List<TimestampInterval> intervals = List.of(
                new TimestampInterval(Timestamp.valueOf(LocalDateTime.of(2018, 5, 1, 10, 10, 10)), Timestamp.valueOf(LocalDateTime.of(2018, 5, 2, 12, 10, 10))),
                new TimestampInterval(Timestamp.valueOf(LocalDateTime.of(2018, 6, 1, 10, 10, 10)), Timestamp.valueOf(LocalDateTime.of(2018, 6, 2, 12, 10, 10))),
                new TimestampInterval(Timestamp.valueOf(LocalDateTime.of(2018, 7, 1, 10, 10, 10)), Timestamp.valueOf(LocalDateTime.of(2018, 7, 1, 12, 10, 10))),
                new TimestampInterval(Timestamp.valueOf(LocalDateTime.of(2018, 8, 1, 10, 10, 10)), Timestamp.valueOf(LocalDateTime.of(2018, 8, 1, 12, 10, 10)))
        );

        MergeIntervalPair mergeIntervalPair = new MergeIntervalPair();
        Assertions.assertEquals(4, mergeIntervalPair.collapseOverlap(intervals).size());
    }

    @Test
    void given_overlapping_interval_when_collapseOverlap_should_returnSameIntervals() {

        List<TimestampInterval> intervals = List.of(
                new TimestampInterval(Timestamp.valueOf(LocalDateTime.of(2018, 5, 1, 10, 10, 10)), Timestamp.valueOf(LocalDateTime.of(2018, 5, 2, 12, 10, 10))),
                new TimestampInterval(Timestamp.valueOf(LocalDateTime.of(2018, 5, 1, 11, 30, 10)), Timestamp.valueOf(LocalDateTime.of(2018, 6, 2, 12, 10, 10))),
                new TimestampInterval(Timestamp.valueOf(LocalDateTime.of(2018, 6, 2, 12, 10, 10)), Timestamp.valueOf(LocalDateTime.of(2018, 7, 1, 12, 10, 10))),
                new TimestampInterval(Timestamp.valueOf(LocalDateTime.of(2018, 8, 1, 10, 10, 10)), Timestamp.valueOf(LocalDateTime.of(2018, 8, 1, 12, 10, 10)))
        );

        MergeIntervalPair mergeIntervalPair = new MergeIntervalPair();
        Assertions.assertEquals(2, mergeIntervalPair.collapseOverlap(intervals).size());
    }

}
