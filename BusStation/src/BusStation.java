import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
There are n groups of friends, and each group is numbered from 1 to n. The ith group contains ai people.

They live near a bus stop, and only a single bus operates on this route. An empty bus arrives at the bus stop and all the groups want to travel by the bus.

However, group of friends do not want to get separated. So they enter the bus only if the bus can carry the entire group.

Moreover, the groups do not want to change their relative positioning while travelling. In other words, group 3 cannot travel by bus, unless group 1 and group 2 have either (a) already traveled by the bus in the previous trip or (b) they are also sitting inside the bus at present.

You are given that a bus of size x can carry x people simultaneously. 

Find the size x of the bus so that (1) the bus can transport all the groups and (2) every time when the bus starts from the bus station, there is no empty space in the bus (i.e. the total number of people present inside the bus is equal to x)?
*/
public class BusStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			String[] s = br.readLine().split(" ");
			for(int i = 0 ; i<s.length; i++)
			{
				a[i] = Integer.parseInt(s[i]);
			}
			int windowSize = a[0];
			StringBuilder sb = new StringBuilder();
			int sum = 0, max = Integer.MIN_VALUE;
			for(int j = 0; j < a.length; j++)
			{
				sum += a[j];
				if(a[j] > max) max = a[j];
			}
			for (int i = 1; i < a.length; i++)
			{
				if(windowSize >= max){
					if(windowSize > sum - windowSize){break;}
					if((sum - windowSize) % windowSize == 0 ){
						if(isOk(windowSize, i, a)){
							sb.append(windowSize + " ");
						}
					}
				}
				windowSize += a[i];
			}
			sb.append(sum);
            System.out.println(sb.toString());
		}
		catch(IOException io)
		{
			
		}
	}
	
	public static boolean isOk(int windowSize, int i, int[] a)
	{
		int temp = windowSize;
		for(int j = i ; j < a.length; j++){
			temp = temp - a[j];
			if(temp < 0) return false;
			else if (temp == 0) temp = windowSize;
		}
        if(temp == windowSize){
            return true;
        }
        else{
            return false;
        }
	}

}
