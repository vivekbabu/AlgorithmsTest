package in.algorithms.roomalotter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Tuple {
	public int start;
	public int end;
	private int order;

	public Tuple(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "[" + start + "," + end + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (!(obj instanceof Tuple))
			return false;
		else {
			Tuple t = (Tuple) obj;
			return t.start == this.start && t.end == this.end
					&& t.order == this.order;
		}
	}
}

public class RoomAlotter {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int NumberOfTestCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < NumberOfTestCases; i++) {
			br.readLine();
			int numberOfRooms = 0;
			List<Tuple> tuples = new ArrayList<Tuple>();
			for (int j = 0; j < 2; j++) {
				String[] splited = br.readLine().split("\\s+");
				for (int k = 0; k < splited.length; k++) {
					if (j == 0) {
						Tuple tuple = new Tuple(k);
						tuple.start = Integer.parseInt(splited[k].trim());
						tuples.add(tuple);
					}

					else {
						tuples.get(k).end = tuples.get(k).start+ Integer.parseInt(splited[k]);
					}
				}
			}

			Collections.sort(tuples, new Comparator<Tuple>() {

				@Override
				public int compare(Tuple o1, Tuple o2) {
					if (o1.start < o2.start)
						return -1;
					else if (o1.start == o2.start)
						return 0;
					else
						return 1;
				}
			});
			System.out.println(tuples);
			while (true) {
				if (!tuples.isEmpty()) {
					numberOfRooms++;
					Tuple tuple = tuples.get(0);
					tuples.remove(tuple);
					List<Tuple> tuplesToRemove = new ArrayList<Tuple>();
					for (Tuple remainTuple : tuples) {
						if (remainTuple.start >= tuple.end) {
							tuple = remainTuple;
							tuplesToRemove.add(remainTuple);
						}
					}
					tuples.removeAll(tuplesToRemove);
				}
				else break;
			}
			System.out.println(numberOfRooms);
		}

	}
}
