package project1;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Fibonacci 
{
	static int arraysize = 100;
	static int[] fn = new int[arraysize];
	static int[] fn1 = new int[arraysize];
	static int[] fn2 = new int[arraysize];
	
	
	public static int rfibonacci(int n)  
	{
	    if(n <= 0)
	    {
	    	return 0;
	    }
	    else if(n == 1)
	    {
	    	return 1;
	    }
	    else
	    {
	    	return rfibonacci(n - 1) + rfibonacci(n - 2);
	    }
	}
	
	public static int ifibonacci(int n)
	{
	    if(n <= 0)
	    {
	    	return 0;
	    }
	    else
	    {
	    	int x = 0;
	    	int y = 1;
	    	int z = 1;
	    	
	    	for (int i = 1;i <= n;i++)
	    	{
	    		x = y;
	            y = z;
	            z = x + y;
	    	}
	    	return x;
	    }
	}
	
	public static BigInteger iBigfibonacci(int n)
	{
	    if(n <= 0)
	    {
	    	return BigInteger.valueOf(0);
	    }
	    else
	    {
	    	BigInteger X,Y,Z;
	    	X = new BigInteger("0");
	    	Y = new BigInteger("1");
	    	Z = new BigInteger("1");

	    	for (int i = 1;i <= n;i++)
	    	{
	    		X = Y;
	            Y = Z;
	            Z = X.add(Y);;
	    	}
	    	return X;
	    }
	}
	
	public static void fibArray(int n)
	{
		fn1[arraysize-1] = 1;
		for(int i=0;i<n-1;i++)
		{
			addArray((i+2));
		}
	}
	
	public static void addArray(int n)
	{		
		int carry = 0;
		for(int i = arraysize;i > 1;i--)
		{
			fn[i-1] = fn1[i-1] + fn2[i-1] + carry;

			if(fn[i-1] > 9)
			{
				carry = 1;
				fn[i-1] = fn[i-1] - 10;
			}
			else 
			{
				carry = 0;
			}
		}
		
		if (carry == 1)
		{
			System.out.println("Error! Fn" + n + " is over 100 elements\n");
			System.out.println("Largest Fn < 100 is ");
			System.out.println("Fn" + (n-1) + " :" +Arrays.toString(fn1));
		}
		
		for(int i=0; i<arraysize; i++)
		{
		    fn2[i]=fn1[i];
		    fn1[i]=fn[i];
		}
	}
	
	public static void timecompare(int n)
	{
		double nanostartTime,nanostopTime,nanoelapsedTime,nanototalTime=0.0,nanototAvgtime=0.0;
		int j=1000;
		final DecimalFormat df2 = new DecimalFormat( "#.000" );
		
		for(int i=0;i<j;i++)
		{
			nanostartTime = System.nanoTime();
			rfibonacci(n);	
			nanostopTime = System.nanoTime();
			nanoelapsedTime = nanostopTime - nanostartTime;
			nanototalTime += nanoelapsedTime;
		}
		
		nanototAvgtime = (nanototalTime/j)/1000000;
		System.out.println("Recursive average execution time with " + j + " runs is : "+ (df2.format(nanototAvgtime)) +" ms\n");
		nanototalTime=0.0;
		
		for(int i=0;i<j;i++)
		{
			nanostartTime = System.nanoTime();
			iBigfibonacci(n);
			nanostopTime = System.nanoTime();
			nanoelapsedTime = nanostopTime - nanostartTime;
			nanototalTime += nanoelapsedTime;
		}
		nanototAvgtime = (nanototalTime/j)/1000000;
		System.out.println("Iterative average execution time with " + j + " runs is : "+ (df2.format(nanototAvgtime)) +" ms\n");		
	}
	
	public static void main(String[] args) 
	{
		
		int n = 18;  //475 for <100  831082459908702935293955784701120993704369028200651613859972830080739980541065544674812034151699525
					// for rfibonacci >35 slow
					// 17 and greater when recursive takes longer than iterative
		
		fibArray(476);
//		addArray();
//		timecompare(n);
		
//		for (int i = 1;i <= 10;i++)
//		{
//			System.out.println(rfibonacci(i));
//		}
//		
//		for (int i = 1;i <= 10;i++)
//		{
//			System.out.println(ifibonacci(i));
//		}
		
//		System.out.println(rfibonacci(n));
//		System.out.println(ifibonacci(n));
//		System.out.println(iBigfibonacci(n));
		
	}
}
