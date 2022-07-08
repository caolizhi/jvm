package top.caolizhi.example.jvm.jmm.object;

public class LazyLoading {
	public static void main(String[] args) {
		Long l = 1_000L;

		Long lL = 2_000L;

		String s = new String("124");
		String s5 = new String("124");
		s.intern();
		String s2 = "124";
		System.out.println(s == s2);
		System.out.println(s == s5);

		String s3 = new String("1") + new String("1");
		s3.intern();
		String s4 = "11";
		System.out.println(s3 == s4);

		;
	}
}
