package top.caolizhi.example.compiler.symbols;

import java.util.Hashtable;

import top.caolizhi.example.compiler.inter.Id;
import top.caolizhi.example.compiler.lexer.Token;

public class Env {

	private Hashtable table;
	protected Env prev;

	public Env(Env n) { table = new Hashtable(); prev = n; }

	public void put(Token w, Id i) { table.put(w, i); }

	public Id get(Token w) {
		for( Env e = this; e != null; e = e.prev ) {
			Id found = (Id)(e.table.get(w));
			if( found != null ) return found;
		}
		return null;
	}
}
