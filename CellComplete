public class CellComplete {

	public static void main(String[] args) {
		int[] inp = {1,1,1,0,1,1,1,1};
		int days = 2;

		cellCompete(inp, days);
	}   
	  
	public static List<Integer> cellCompete(int[] states, int days)
	    {
			Object[] inp = new Object[states.length];
			for(int i=0; i<states.length; i++) {
				inp[i] = states[i];
			}
			ArrayList<Integer> op = new ArrayList<Integer>();
			
	    	for(int i=0; i< days; i++) {
	    		op.clear();
	    		for(int j=0; j<states.length ; j++) {
	    			int prev = 0, next = 0;
	    			if(j == 0) {
	    				next = (int) inp[j+1];
	    			}else if(j == states.length -1) {
	    				prev = (int) inp[j-1];
	    			}else {
	    				next = (int) inp[j+1];
	    				prev = (int) inp[j-1];
	    			}
	    			if(prev == next) {
	    				op.add(0);
	    			}else {
	    				op.add(1);
	    			}
	    		}
	    		inp = op.toArray();
	    	}
	    	return op;
	    }
	 
}
