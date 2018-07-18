package com.wxy.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Cser_W on 2018/4/21.
 */
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
public class 合并重复数组 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 0; i < intervals.size(); i++) {
            if (0 != res.size()){
                Interval temp = intervals.get(i);
                Interval stackTemp = res.get(res.size() - 1);
                if (stackTemp.end >= temp.start) {
                    res.remove(res.size() - 1);
                    int minStart = Math.min(stackTemp.start, temp.start);
                    int minEnd = Math.max(stackTemp.end, temp.end);
                    res.add(new Interval(minStart,minEnd));
                } else{

                    res.add(temp);
                }

            } else {
                res.add(intervals.get(i));
            }

        }
        return res;
    }
}
