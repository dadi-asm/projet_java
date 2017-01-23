package pack1;

import java.math.BigInteger;

public class unit64 {
	BigInteger value;
	public unit64(BigInteger b)
	{
		this.value=b;
	}
	public unit64 xor(unit64 a){
		BigInteger res=this.value.xor(a.value);
		unit64 resultat=new unit64(res);
		return resultat;		
	}
	
	public BigInteger rotateLeft(int c) {
		BigInteger ret=this.value;
		while(c-->0)
		{
	    ret = ret.shiftLeft(1);
		    if (ret.testBit(4)) 
		    {
		        ret = ret.clearBit(4).setBit(0);
		    }
		}
	    return ret;
	}
	
	public unit64 add(unit64 a){
		BigInteger res=this.value.add(a.value);
		unit64 resultat=new unit64(res);
		return resultat;		
	}
	public static void main(String[] args) 
	{
		BigInteger max=new BigInteger("12");
		unit64 a=new unit64(max);
		//System.out.println(max.shiftLeft(64));
		
		System.out.println(a.rotateLeft(2));
	}

}
