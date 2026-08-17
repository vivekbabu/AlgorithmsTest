package in.algorithms.activityselection;

import java.util.ArrayList;
import java.util.List;

public class ActivitySelection {
    static class Activity {
        int start, finish;
        Activity(int s, int f) { this.start = s; this.finish = f; }
    }

    public static List<Activity> selectActivities(List<Activity> activities) {
        activities.sort((a, b) -> Integer.compare(a.finish, b.finish));
        List<Activity> selected = new ArrayList<>();
        if (activities.isEmpty()) return selected;

        selected.add(activities.get(0));
        int lastFinish = activities.get(0).finish;

        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i).start >= lastFinish) {
                selected.add(activities.get(i));
                lastFinish = activities.get(i).finish;
            }
        }
        return selected;
    }

    public static void main(String[] args) {
        List<Activity> list = new ArrayList<>();
        list.add(new Activity(1, 2));
        list.add(new Activity(3, 4));
        list.add(new Activity(0, 6));
        list.add(new Activity(5, 7));
        list.add(new Activity(8, 9));
        list.add(new Activity(5, 9));

        List<Activity> result = selectActivities(list);
        System.out.println("Selected activities count: " + result.size());
    }
}
