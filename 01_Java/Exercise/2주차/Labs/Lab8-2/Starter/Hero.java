public class Hero {
    protected String name;

    public Hero(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}


class IronMan extends Hero {
    private String reactor;

    public IronMan(String name, String reactorName) {
        super(name);
        this.reactor = reactorName;
    }
}