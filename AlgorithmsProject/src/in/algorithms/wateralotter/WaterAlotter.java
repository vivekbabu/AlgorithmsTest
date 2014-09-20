package in.algorithms.wateralotter;

class Pair {
	public int start;
	public int end;

	public Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class WaterAlotter {

	public void allotWater(float liters, int level, float cupSize) {
		float[] cups = new float[200];
		cups[1] = liters;
		for (int i = 1; i <= level; i++) {
			Pair range = getRange(i);
			for (int j = range.start; j <= range.end; j++) {
				if (cups[j] > cupSize) {
					float extra = cups[j] - cupSize;
					cups[j] = cupSize;
					float childOneContent = cups[j + i];
					float childTwoContent = cups[j + i + 1];
					cups[j + i] = childOneContent + extra / 2;
					cups[j + i + 1] = childTwoContent + extra / 2;
				}
			}
		}
		int end = getRange(level).end;
		for (int i = 1; i <= end; i++) {
			System.out.println(i + " = " + cups[i]);
		}
	}

	public static void main(String[] args) {
		new WaterAlotter().allotWater(10, 5, 1);
	}

	private Pair getRange(int n) {
		int start = ((n * (n - 1)) / 2) + 1;
		int end = start + n - 1;
		return new Pair(start, end);
	}

}
