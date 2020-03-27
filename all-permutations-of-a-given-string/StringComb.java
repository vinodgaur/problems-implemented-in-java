class StringComb{
	public static void main(String[] args) {
		StringComb("ABC",0,2);
	}


	static void StringComb(String str,int l,int r){
		if(l==r){
			System.out.println(str);
		} else {
			for (int i=l; i<=r; i++) {
				String s = swap(str,l,i);
				StringComb(s,l+1,r);
			}
		}
	}

	static String swap(String s,int a,int b){
		char ch[] = s.toCharArray();
		char temp = ch[a];
		ch[a] = ch[b];
		ch[b] = temp;
		return String.valueOf(ch);
	}
}