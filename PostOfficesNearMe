/*
K Nearest Post Offices
Find the k post offices located closest to you, given your location and a list of locations of all post offices available.
Locations are given in 2D coordinates in [X, Y], where X and Y are integers.
Euclidean distance is applied to find the distance between you and a post office.
Assume your location is [m, n] and the location of a post office is [p, q], the Euclidean distance between the office and you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
K is a positive integer much smaller than the given number of post offices. from aonecode.com

e.g.
Input
you: [0, 0]
post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
k = 3

Output from aonecode.com
[[-1, 2], [0, 3], [4, 3]] 

*/
import java.util.ArrayList;

public class PostOfficesNearMe {

	public static void main(String[] args) {
		int[][] inp = {{-16,5},{-1,2},{4,3},{10,-2},{0,3},{-5,-9}};
		int k = 3;
		int[][] myLoc = {{0,0}};
		getPostOffices(myLoc, inp, 3);

	}

	private static void getPostOffices(int[][] myLoc, int[][] inp, int count) {
		int index =0;
		ArrayList<Integer> list = new ArrayList();
		for(int j=1; j<=count; j++) {	
			double minDist = Double.MAX_VALUE;
			for(int i=0; i<inp.length ; i++) {	
				int x , y;
				x = inp[i][0];
				y = inp[i][1];
				int mulp = Math.multiplyExact(myLoc[0][0]- x, myLoc[0][0] - x)+Math.multiplyExact((myLoc[0][1] - y), (myLoc[0][1] - y));
				double dist = Math.sqrt(mulp);	
				if(dist < minDist && !list.contains(i)) {					
					minDist = dist;
					index = i;
				}
			}
			list.add(index);
		}
		System.out.println(list);
	}

}
