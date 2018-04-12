package edu.wiki.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Merge {

	// Definition for an interval.
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	/*
	 * intervals == null intervals size == 1 assume valid interval
	 * 
	 * int1 end = 4 and int2.start = 5 -> combine.
	 * 
	 * 1 case end1 before start2 by 1 2 case combine end1 touches or overlap
	 * start2
	 * 
	 * ----- ----
	 * 
	 * ------- ---
	 * 
	 * ---- ----
	 * 
	 * ------ ---
	 */
	public List<Interval> merge(List<Interval> intervals) {
		ArrayList<Interval> merger = new ArrayList<>();
		if (intervals == null)
			return merger;
		if (intervals.size() <= 1)
			return intervals;

		intervals.sort(new IntervalComparator());

		Interval pre = intervals.get(0);
		int j = 1;
		while (j < intervals.size()) {
			Interval cur = intervals.get(j);

			if (pre.end >= cur.start) {
				// combine
				pre = new Interval(pre.start, Math.max(pre.end, cur.end));
			} else {
				merger.add(pre);
				pre = intervals.get(j);
			}

			j++;
		}

		merger.add(pre);
		return merger;

	}

	class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval i1, Interval i2) {
			if (i1.start == i2.start) {
				return new Integer(i1.end).compareTo(i2.end);
			} else {
				return new Integer(i1.start).compareTo(i2.start);
			}
		}
	}
}