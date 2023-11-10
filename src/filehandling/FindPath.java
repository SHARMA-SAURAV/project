package filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPath {
		static void RecursiveDirectory(File[] arr, int level)
		{
			for (File f : arr) {
				
				if (f.isFile())
					System.out.println(f.getAbsolutePath());

				else if (f.isDirectory()) {
//					System.out.println( f.getAbsolutePath());
					RecursiveDirectory(f.listFiles(), level + 1);
				}
			}
		}
		public static void main(String[] args) throws IOException
		{
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
				System.out.println("Enter directory path:");
				String dirpath = br.readLine();
				System.out.println("Enter the directory name");
				String dname = br.readLine();
				File f = new File(dirpath,dname);

			if (f.exists() && f.isDirectory()) {
				File arr[] = f.listFiles();
				RecursiveDirectory(arr, 0);
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(
//				new InputStreamReader(System.in));
//			System.out.println("Enter directory path:");
//			String dirpath = br.readLine();
//			System.out.println("Enter the directory name");
//			String dname = br.readLine();
//			File f = new File(dirpath,dname);
//			if(f.exists()) {
//				String arr[]=f.list();
////				System.out.println(arr);
//				int n=arr.length;
//				for(int i=0;i<n;i++) {
//					File f1 = new File(f.getPath(),arr[i]);
//					String brr[]=f1.list();
////					System.out.println(brr);
////					System.out.println();
//					System.out.println(f1.getAbsolutePath());
//				}
//			}
//		
//		
//		
//	}
