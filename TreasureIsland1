/*Treasure Island
You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. 
There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
Assume the map area is a two dimensional grid, represented by a matrix of characters.
You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
The treasure island is marked as ‘X’ in a block of the matrix. ‘X’ will not be at the top-left corner.
Any block with dangerous rocks or reefs will be marked as ‘D’. You must not enter dangerous blocks. You cannot leave the map area.
Other areas ‘O’ are safe to sail in. The top-left corner is always safe.
Output the minimum number of steps to get to the treasure.
from aonecode.com

e.g.
Input
[
[‘O’, ‘O’, ‘O’, ‘O’],
[‘D’, ‘O’, ‘D’, ‘O’],
[‘O’, ‘O’, ‘O’, ‘O’],
[‘X’, ‘D’, ‘D’, ‘O’],
]

Output from 
Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps. 
*/
import java.util.ArrayDeque;
import java.util.Queue;

public class TreasureIsland1 {
	public static int[][] DIRS = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};

	public static void main(String[] args) {
        char[][] grid = {{'O', 'O', 'O', 'O'},
                         {'D', 'O', 'D', 'O'},
                         {'O', 'O', 'O', 'O'},
                         {'X', 'D', 'D', 'O'}};
        System.out.println(minSteps(grid));
    }
	
	public static class Point{
		int r,c;
		 Point(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	private static int minSteps(char[][] grid) {
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(new Point(0, 0));
		grid[0][0] = 'V';
		for(int steps=1; !queue.isEmpty(); steps++) {
			for(int size = queue.size(); size >0; size--) {
				Point point = queue.poll();
				int r , c;
				for(int[] dir: DIRS) {
					r = point.r + dir[0];
					c = point.c + dir[1]; 
					if(checkSafety(r,c,grid)) {
						queue.add(new Point(r, c));						
						if(grid[r][c] == 'X') {
							return steps;
						}
						grid[r][c] = 'V';
					}
				}
			}
		}
		return -1;
	}

	private static boolean checkSafety(int r, int c, char[][] grid) {
		if(r < 0 || c <0 || r >= grid.length || c >= grid.length || grid[r][c] == 'V' || grid[r][c] == 'D') {
			return false;
		}
		return true;
	}
