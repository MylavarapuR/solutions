/*Problem Statement
Movies on Flight
You are on a flight and wanna watch two movies during this flight. 
You are given int[] movie_duration which includes all the movie durations. 
You are also given the duration of the flight which is d in minutes. 
Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min). 
Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.

e.g. 
Input
movie_duration: [90, 85, 75, 60, 120, 150, 125]
d: 250

Output from aonecode.com
[90, 125]
90min + 125min = 215 is the maximum number within 220 (250min - 30min)
.
*/


import java.util.Arrays;

public class MoviesOnFlight {

	public static void main(String[] args) {
		int[] inpArr = {90, 85, 75, 60, 120, 150, 125};
		int[] otp = new int[2];
		int d = 250;
		otp = calculateDuration(inpArr , d);
		System.out.println(otp[0] +","+otp[1]);
	}
	//Calculates the movies
	//Inputs array of movies duration
	//duration of flight
	public static int[] calculateDuration(int[] inpArr, int d) {
		int ot[] = new int[2];
		Arrays.sort(inpArr);//Sort so that u get the max item in the list first
		int totalTime = 0;
		for(int i = inpArr.length -1; i >=0; i--) {
			for(int k = inpArr.length -1; k>=0; k--) {
				int temp = inpArr[i] + inpArr[k];
				if((temp <= d-30 ) && totalTime < temp && k!=i ) {//Check if it is equal to the duration and more the the prev duration
					ot[1] = inpArr[i];
					ot[0] = inpArr[k];
					totalTime = temp;
				}
			}
		}
		return ot;		
	}

}
