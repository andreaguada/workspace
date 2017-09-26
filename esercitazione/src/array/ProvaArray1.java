package array;

public class ProvaArray1 {

	public static void main(String[] args) {

		int x[] = new int [11];
		for(int i=1; i<=10; i++){
			x[i] = +i;
			System.out.println("x["+i+"] = "+x[i]);
		}
		
		System.out.println("\n");

		for(int j=1; j<=10; j++){
			for(int k=1; k<=10; k++){
				System.out.print(j*k +"\t");
			}
			System.out.println();
		}

	}

}
