package in.algorithms.activityselection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {
    public static class Activity {
        public final int start;
        public final int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<Activity> selectActivities(List<Activity> activities) {
        if (activities == null || activities.isEmpty()) return Collections.emptyList();
        
        List<Activity> sorted = new ArrayList<>(activities);
        sorted.sort(Comparator.comparingInt(a -> a.end));

        List<Activity> selected = new ArrayList<>();
        selected.add(sorted.get(0));
        int lastEnd = sorted.get(0).end;

        for (int i = 1; i < sorted.size(); i++) {
            if (sorted.get(i).start >= lastEnd) {
                selected.add(sorted.get(i));
                lastEnd = sorted.get(i).end;
            }
        }
        return selected;
    }
}
