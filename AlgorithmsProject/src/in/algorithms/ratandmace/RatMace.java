package in.algorithms.ratandmace;

public class RatMace {

	private static int n = 7;
	static Integer test[][] = new Integer[n + 1][n + 1];
	static Integer maze[][] = new Integer[n + 1][n + 1];

	private static int countpath = 0;

	private static void path(int i, int j) {

		if (i == n  && j == n )
			countpath++;
		test[i][j] = 1;
		if ((j + 1) <= n && test[i][j + 1] == 0 && maze[i][j + 1] == 0)
			path(i, j + 1);
		if ((i + 1) <= n && test[i + 1][j] == 0 && maze[i + 1][j] == 0)
			path(i + 1, j);
		if ((j - 1) >= 1 && test[i][j - 1] == 0 && maze[i][j - 1] == 0)
			path(i, j - 1);
		if ((i - 1) >= 1 && test[i - 1][j] == 0 && maze[i - 1][j] == 0)
			path(i - 1, j);
		test[i][j] = 0;
		return;
	}

	public static void main(String[] args) {
		for (int i = 1; i <= n ; i++) {
			for (int j = 1; j <= n ; j++) {
				maze[i][j] = test[i][j] = 0;
			}
		}
		maze[1][3] = maze[2][1] = maze[2][3] = maze[2][4] = maze[3][5] = maze[3][7] = maze[4][1] = maze[4][3] = maze[5][1] = maze[5][3] = maze[5][4] = maze[5][6] = maze[6][1] = maze[6][6] = maze[7][1] = maze[7][2] = maze[7][3] = maze[7][4] = 1;

		path(1, 1);
		System.out.println(countpath);
	}

}
