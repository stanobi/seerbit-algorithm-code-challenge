package org.seerbit;

import org.seerbit.model.TimestampInterval;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class AlgorithmSolutions {

    public static void main(String[] args) {

        solutionOne();
        solutionTwo();

        System.out.println("App Started but Exiting... kindly use the Test Class to test");
    }

    private static void solutionOne() {
        List<TimestampInterval> intervals = List.of(
                new TimestampInterval(Timestamp.valueOf(LocalDateTime.of(2018, 5, 1, 10, 10, 10)), Timestamp.valueOf(LocalDateTime.of(2018, 5, 2, 12, 10, 10))),
                new TimestampInterval(Timestamp.valueOf(LocalDateTime.of(2018, 5, 1, 11, 30, 10)), Timestamp.valueOf(LocalDateTime.of(2018, 6, 2, 12, 10, 10))),
                new TimestampInterval(Timestamp.valueOf(LocalDateTime.of(2018, 6, 2, 12, 10, 10)), Timestamp.valueOf(LocalDateTime.of(2018, 7, 1, 12, 10, 10))),
                new TimestampInterval(Timestamp.valueOf(LocalDateTime.of(2018, 8, 1, 10, 10, 10)), Timestamp.valueOf(LocalDateTime.of(2018, 8, 1, 12, 10, 10)))
        );

        MergeIntervalPair mergeIntervalPair = new MergeIntervalPair();
        System.out.println("Intervals : "+mergeIntervalPair.collapseOverlap(intervals));
    }

    private static void solutionTwo() {
        int[] numbers = {1, 2, 3, 4};
        System.out.println("MaxXOR : "+MaxXORSubarray.getMaxXOR(numbers));
    }
}
