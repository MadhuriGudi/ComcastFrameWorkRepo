package practiceDataDrivenTesting;

public class GenerateAlphaNumercRandomdata {

	public static void main(String[] args) {
		int n=10;
		String AlphaNumstring="ABCDEFGHIJKLMNOPQRSTUVWX"
				+ "YZ0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb=new StringBuilder(n);
		int index=0;
		for(int i=0;i<n;i++)
		  index =(int)(AlphaNumstring.length()*Math.random());
		sb.append(AlphaNumstring.charAt(index));

		System.out.println(sb);
	}

}
 