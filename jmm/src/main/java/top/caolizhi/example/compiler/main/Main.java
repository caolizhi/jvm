package top.caolizhi.example.compiler.main;

import java.io.IOException;

import top.caolizhi.example.compiler.lexer.Lexer;
import top.caolizhi.example.compiler.parser.Parser;

public class Main {

	// {
	// 	int i;
	// 	int j;
	// 	float v;
	// 	float x;
	// 	float[100] a;
	// 	while (true) {
	// 		do i = i + 1; while (a[i] < v);
	// 		do j = j - 1; while (a[j] > v);
	// 		if (i >= j) break;
	// 		x = a[i];
	// 		a[i] = a[j];
	// 		a[j] = x;
	// 	}
	// }


	// 输出：
	// L1:L3:	i = i + 1
	// L5:	t1 = i * 8
	// t2 = a [ t1 ]
	// 	if t2 < v goto L3
	// L4:	j = j - 1
	// L7:	t3 = j * 8
	// t4 = a [ t3 ]
	// 	if t4 > v goto L4
	// L6:	iffalse i >= j goto L8
	// L9:	goto L2
	// L8:	t5 = i * 8
	// x = a [ t5 ]
	// L10:	t6 = i * 8
	// t7 = j * 8
	// t8 = a [ t7 ]
	// a [ t6 ] = t8
	// L11:	t9 = j * 8
	// a [ t9 ] = x
	// goto L1
	// L2:


	public static void main(String[] args) throws IOException {
		Lexer lex = new Lexer();
		Parser parse = new Parser(lex);
		parse.program();
		System.out.write('\n');
	}
}
