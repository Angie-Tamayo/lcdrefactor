package lcdrefactor;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//	will be:
// 	   0
//	1     3
//	   2
//	4     6
//	   5
//
// ex: 0 is only 0, 1 , 3, 4, 5 and 6 are true
// ex: 1 is only 3 and 6 are true
// ex: 2 is only 0, 2, 3, 4 and 5 are true
//

public class LCDDisplay {
 						
	private Boolean[][] impresor;
	private ArrayList <Integer> list;
	private int n;
	private String num;
	public LCDDisplay(int n, String num) {
//					     pos  =  0      1      2      3      4      5      6
		 impresor = new Boolean[][] {{ true,  true, false,  true,  true,  true,  true},  /* 0 */
					 	  {false, false, false,  true, false, false,  true},  /* 1 */
					 	  { true, false,  true,  true,  true,  true, false},  /* 2 */
					 	  { true, false,  true,  true, false,  true,  true},  /* 3 */
					 	  {false,  true,  true,  true, false, false,  true},  /* 4 */
					 	  { true,  true,  true, false, false,  true,  true},  /* 5 */
					 	  { true,  true,  true, false,  true,  true,  true},  /* 6 */
					 	  { true, false, false,  true, false, false,  true},  /* 7 */
					 	  { true,  true,  true,  true,  true,  true,  true},  /* 8 */
					 	  { true,  true,  true,  true, false,  true,  true}}; /* 9 */
		list = new ArrayList<> ();
		this.n = n;
		this.num = num;
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		LCDDisplay LC_Display;
		while(true) {
			LC_Display = new LCDDisplay(cin.nextInt(), cin.next());
			if(LC_Display.n == 0 && LC_Display.num.equals("0")) {
				break;
			}
			for(int i = 0; i < LC_Display.num.length(); i++) {
				LC_Display.list.add(LC_Display.num.charAt(i) - '0');
			}
			LC_Display.imprimir();
			System.out.println();
		}
		cin.close();
	}
	
	public void imprimir() {
		char[] used1 = new char[n*2];
		char[] blank1 = new char[n*2];
		Arrays.fill(used1, '=');
		Arrays.fill(blank1, ' ');
		String used = new String(used1);
		String blank = new String(blank1);
		imprimirFila(used, blank, 0);
		
		for(int i = 0; i < n; i++) {
			imprimirColumna(blank, 1, 3);
		}
		
		imprimirFila(used, blank, 2);
		
		for(int i = 0; i < n; i++) {
			imprimirColumna(blank, 4, 6);
		}
		
		imprimirFila(used, blank, 5);
	}
	
	public void imprimirFila(String used, String blank, int pos) {
		for(int i = 0; i < list.size(); i++) {
			if(i != 0) {
				System.out.print("  ");
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(impresor[list.get(i)][pos] ? ("  " + used + "  ") : ("  " + blank + "  "));
		}
		System.out.println();
	}
	
	public void imprimirColumna(String blank, int posL, int posR) {
		for(int i = 0; i < list.size(); i++) {
			if(i != 0) {
				System.out.print("  ");
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(impresor[list.get(i)][posL] ? "||" : "  ");
			System.out.print(blank);
			System.out.print(impresor[list.get(i)][posR] ? "||" : "  ");
		}
		System.out.println();
	}

}

