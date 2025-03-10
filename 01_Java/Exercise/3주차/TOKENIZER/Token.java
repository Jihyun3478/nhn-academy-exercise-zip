/* Element 
* 왜 interface가 아니라 abstract일까? 
* abstract는 틀
*/
public abstract class Token {
    String word;

    /**
     * @param word
     */
    public Token(String word) {
        this.word = word;
    }

    public String getWord() {
        return this.word;
    }

    abstract String accept(TokenVisitor visitor);
}

class ClassToken extends Token {
    public ClassToken(String word) {
        super(word);
    }

    public String accept(TokenVisitor visitor) {
        return visitor.visit(this);
    }
}

class NullToken extends Token {
    public NullToken(String word) {
        super(word);
    }

    public String accept(TokenVisitor visitor) {
        return visitor.visit(this);
    }
}

class KeywordToken extends Token {
    public KeywordToken(String word) {
        super(word);
    }

    public String accept(TokenVisitor visitor) {
        return visitor.visit(this);
    }
}

class LineToken extends Token {
    public LineToken(String word) {
        super(word);
    }

    public String accept(TokenVisitor visitor) {
        return visitor.visit(this);
    }
}