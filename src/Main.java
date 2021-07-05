import java.io.File;
import java.io.FileNotFoundException;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Diameter d1 = new Diameter(new File("C:\\Users\\An Chao\\eclipse-workspace\\RingRndSC\\src\\Ring.txt"));
		System.out.println(d1);
		System.out.println(d1.getDiameter());
		System.out.println(d1.getUsage());
		Diameter d = new Diameter(new File("C:\\Users\\An Chao\\eclipse-workspace\\RingRndSC\\src\\RSC.txt"));
		System.out.println(d);
		System.out.println(d.getDiameter());
		System.out.println(d.getUsage());
		
//		Scanner sc = new Scanner(d.getLine(1));
//		while(sc.hasNextInt()) {
//			System.out.print(sc.nextInt()+" ");
//		}
//		sc.remove();
//		
	}

}
