package cs1632_deliverable4;

public class Laboonify {
	public int[] laboonify(int[] x){
		int result[] = new int[x.length+1];
		int total = 0;
		for( int i = 0; i< x.length; i++){
			result[i] = x[i] * x[i];	// square
			total += result[i];
		}
		result[x.length] = total;
		return result;
	}
	
	public Laboonify(){
		
	}
}
