import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
Red John has committed another murder. But this time, he doesn't leave a red smiley behind. What he leaves behind is a puzzle for Patrick Jane to solve. He also texts Teresa Lisbon that if Patrick is successful, he will turn himself in. The puzzle begins as follows.

There is a wall of size 4xN in the victim's house. The victim also has an infinite supply of bricks of size 4x1 and 1x4 in her house. There is a hidden safe which can only be opened by a particular configuration of bricks in the wall. In every configuration, the wall has to be completely covered using the bricks. There is a phone number written on a note in the safe which is of utmost importance in the murder case. Gale Bertram wants to know the total number of ways in which the bricks can be arranged on the wall so that a new configuration arises every time. He calls it M. Since Red John is back after a long time, he has also gained a masters degree in Mathematics from a reputed university. So, he wants Patrick to calculate the number of prime numbers (say P) up to M (i.e. <= M). If Patrick calculates P, Teresa should call Red John on the phone number from the safe and he will surrender if Patrick tells him the correct answer. Otherwise, Teresa will get another murder call after a week.

You are required to help Patrick correctly solve the puzzle.
 */

public class RedJohnIsBack {
	static int[][] L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			int n;
			while(T != 0){
				n = Integer.parseInt(br.readLine());
				L = new int[5][n+1];
				int ans = NumberOfWays(4,n);
				if(ans <= 1){
					System.out.println(0);
				}
				else if(ans == 2){System.out.println(ans);}
				else{
					System.out.println(Math.round(ans/Math.log(ans)));
					}
				T--;
				}
		}catch(IOException io){
			
		}
		
	}
	public static int NumberOfWays(int a, int b)
	{
		int m=0,n=0;
		if(L[a][b] != 0){
			return L[a][b];
		}
		else{
			if(a < 4 && b < 4){
				return -1;
			}
			else if(a <= 0 || b <= 0){
				return -1;
			}
			else if(a == 4 && b == 4){
				return 2;
			}
			else if(a < 4 && b == 4){
				m = a;
			}
			else if(a == 4 && b < 4){
				n = b;
			}
			else if(a == 4 && b > 4){
				m = NumberOfWays(a, b-1); //4,1
				n = NumberOfWays(a-1, 4) * NumberOfWays(a, b-4); //1,4
			}
		}
		if(m > 0 && n > 0){
			L[a][b] = m*n;
		}
		else if(m > 0 && n < 0){
			L[a][b] = m;
		}
		else if(n > 0 && m < 0){
			L[a][b] = n;
		}
		else{
			L[a][b] = -1;
		}
		
		return L[a][b];
	}
}
