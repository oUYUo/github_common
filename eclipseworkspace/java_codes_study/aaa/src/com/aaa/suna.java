package com.aaa;

public class suna {
	public int gcd(int p ,int q)
	{
		if(q==0)
				{
					return q;
				}
		else
		{
			int r=p%q;
			return gcd(q,r);
		}
	}
	

}
