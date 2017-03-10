
public class N_Queens {
	private int N;
	private int cols[];
	
	public N_Queens(int N) {
		this.N = N;
		cols = new int[N];
	}
	
	public void back_tracking(int level) {
		if(level == N) {
			for(int i=0; i<N; i++) {
				System.out.print(cols[i]);
			}
			
			System.out.println("");
		} else {
			for(int i=0; i<N; i++) {
				cols[level] = i;
				if(isPossible(level)) {
					back_tracking(level+1);
				}
			}
		}
	}
	
	public boolean isPossible(int level){
	    for(int i=0; i<level; i++){	         
	        if(cols[i] == cols[level] || Math.abs(level-i) == Math.abs(cols[level]-cols[i])){
	            return false;
	        }
	    }
	    
	    return true;
	}
}
