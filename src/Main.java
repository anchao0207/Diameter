import java.io.File;
import java.io.FileNotFoundException;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Diameter d1 = new Diameter(new File("C:\\Users\\An Chao\\eclipse-workspace\\RingRndSC\\src\\Ring.txt"));
		System.out.println(d1);
		System.out.println(d1.getDiameter());
		System.out.println(d1.UsageToString());
		Diameter d = new Diameter(new File("C:\\Users\\An Chao\\eclipse-workspace\\RingRndSC\\src\\RSC.txt"));
		System.out.println(d);
		System.out.println(d.getDiameter());
		System.out.println(d.UsageToString());
		int[][] usage = d.getUsage();
		int n=usage.length;
		int count1=0;
		int count2=0;
		for(int i=0;i<n;i++) {
			for(int j=i+2;j<n;j++) {
				if(usage[i][j]>=100) {
					if(usage[i][j]>=150)
						count1++;
					if(usage[i][j]<150)
						count2++;
					System.out.println(i+" to "+j+": "+usage[i][j]);
				}
			}
		}
		System.out.print(count1+" "+count2);
	}

}
