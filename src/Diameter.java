import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Diameter {
	File file;
	int[][] distance;
	int[][] usage;
	List<LinkedList<Integer>> vertices = new LinkedList<>();
	
	public Diameter(File file) throws FileNotFoundException {
		this.file=file;
		int n=this.getSize();
		this.distance = new int[n][n];
		this.usage = new int[n][n];
		for(int i=0;i<n;i++) {
			Scanner sc = new Scanner(getLine(i+1));
			LinkedList<Integer> neighbors = new LinkedList<>();
			while(sc.hasNextInt()) {
				neighbors.add(sc.nextInt());
			}
			vertices.add(neighbors);
			sc.close();
		}
		

		for(int r=0;r<n;r++) {
			for(int c=0;c<n;c++) {
				distance[r][c]=Integer.MAX_VALUE;
			}
		}
		for(int i=0;i<n;i++) {
			Queue<Integer> queue = new LinkedList<>();
			Set<Integer> visited = new HashSet<>();
			queue.add(i);
			distance[i][i]=0;
			while(queue.size()>0) {
				int v = queue.poll();
				
				if(visited.contains(v)) {
					continue;
				} else {
					visited.add(v);
					queue.addAll(vertices.get(v));
				}
				for(Integer neighbor:vertices.get(v)) {
					int temp=distance[i][v]+1;
					
					if(distance[i][neighbor]>temp) {
						distance[i][neighbor]=temp;
					}
				}
			}
			
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				Usage(i,j);
			}
		}
		
	}
	
	public void Usage(int i,int j) {
		if(i==j) {
			usage[i][j]=0;
		} else {
			if(vertices.get(i).contains(j)) {
				usage[i][j]++;
			} else {
				for(Integer neighbor:vertices.get(i)) {
					if(1+distance[neighbor][j]==distance[i][j]) {
						usage[i][neighbor]++;
						if(distance[neighbor][j]==1) {
							usage[neighbor][j]++;
						} else {
							Usage(neighbor,j);
						}
					}
				}
			}
		}
	}
	
	public String getUsage() {
		String result="";
		int n=usage.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				result+=usage[i][j]+" ";
			}
			result+="\r";
		}
		return result;
	}
	
	public int getSize() throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		int size=sc.nextInt();
		sc.close();
		return size;
	}
	
	public String getLine(int i) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		String line="";
		for(int j=0;j<=i;j++) {
			line=sc.nextLine();
		}
		sc.close();
		return line;	
	}
	
	public String toString() {
		String result="";
		int n=distance.length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				result+=distance[i][j]+" ";
			}
			result+="\r";
		}
		return result;
	}
	
	public int getDiameter() {
		int n=distance.length;
		int max=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(max<distance[i][j])
					max=distance[i][j];
			}
		}
		return max;
	}
	
}
