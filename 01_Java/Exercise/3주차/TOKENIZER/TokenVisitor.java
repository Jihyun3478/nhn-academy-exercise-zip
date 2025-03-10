/* Visitor 
 * 왜 class가 아니라 interface일까? 
 * -> interface는 구현체의 선언부
*/
public interface TokenVisitor {
    String visit(Token acceptor);
    String visit(ClassToken acceptor);
    String visit(KeywordToken acceptor);
    String visit(NullToken acceptor);
}

class ClassTokenVisitor implements TokenVisitor {
    public String visit(Token acceptor) {
        return "";
    }
    
    public String visit(ClassToken acceptor) {
        return "<font color='blue'>" + acceptor.getWord() + "</font>";
    }

    public String visit(KeywordToken acceptor) {
        return "<font color='green'>" + acceptor.getWord() + "</font>";
    }

    public String visit(LineToken acceptor) {
        return "<font color='red'>" + acceptor.getWord() + "</font>";
    }

    public String visit(NullToken acceptor) {
        return acceptor.getWord();
    }
}