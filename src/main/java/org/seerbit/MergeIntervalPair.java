package org.seerbit;

import org.seerbit.model.TimestampInterval;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MergeIntervalPair {

    public List<TimestampInterval> collapseOverlap(List<TimestampInterval> timestampIntervalList) {

        List<TimestampInterval> collapsed = new ArrayList<>();
        if (timestampIntervalList == null || timestampIntervalList.isEmpty()) {
            return collapsed;
        }

        //NOTE that the array is already sorted by startTimestamp
        //we pick the first item and use as the starting point.
        Timestamp start = timestampIntervalList.get(0).getStart();
        Timestamp end = timestampIntervalList.get(0).getEnd();

        int arraySize = timestampIntervalList.size();
        for (int i = 1; i < arraySize; i++) {
            TimestampInterval timestampInterval = timestampIntervalList.get(i);
            if (timestampInterval.getStart().after(end)) {
                collapsed.add(new TimestampInterval(start, end));
                start = timestampInterval.getStart();
                end = timestampInterval.getEnd();
            } else {
                end = end.after(timestampInterval.getEnd()) ? end : timestampInterval.getEnd();
            }
        }

        collapsed.add(new TimestampInterval(start, end));
        return collapsed;
    }
}
