package top.caolizhi.example.compiler.symbols;

import java.util.Hashtable;

import top.caolizhi.example.compiler.inter.Id;
import top.caolizhi.example.compiler.lexer.Token;

/**
 * 把字符串词法单元映射为类 Id 的对象。
 * 类 Id 和其他的对应于表达式和语句的类在 inter 包中定义
 */
public class Env {

	private Hashtable table;
	protected Env prev;

	public Env(Env n) {
		this.table = new Hashtable();
		this.prev = n;
	}

	public void put(Token w, Id i) {
		table.put(w, i);
	}

	public Id get(Token w) {
		for (Env e = this; e != null; e = e.prev) {
			Id found = (Id)e.table.get(w);
			if (found != null) {
			    return found;
			}
		}
		return null;
	}
}
