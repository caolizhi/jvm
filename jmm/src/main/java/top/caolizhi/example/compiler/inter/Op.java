package top.caolizhi.example.compiler.inter;

import top.caolizhi.example.compiler.lexer.Token;
import top.caolizhi.example.compiler.symbols.Type;

public class Op extends Expr {

   public Op(Token tok, Type p)  { super(tok, p); }

   public Expr reduce() {
      Expr x = gen();
      Temp t = new Temp(type);
      emit( t.toString() + " = " + x.toString() );
      return t;
   }
}
