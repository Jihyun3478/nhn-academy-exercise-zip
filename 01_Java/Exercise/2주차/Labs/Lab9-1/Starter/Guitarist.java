public class Guitarist {
    private int no;
    private String name;
    private String teamName;
    private String guitar;

    private Guitarist(Builder builder) {
        this.no = builder.no;
        this.name = builder.name;
        this.teamName = builder.teamName;
        this.guitar = builder.guitar;
    }

    public static class Builder {
        private int no;
        private String name;
        private String teamName;
        private String guitar;

        public Builder no(int no) {
            this.no = no;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder teamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        public Builder guitar(String guitar) {
            this.guitar = guitar;
            return this;
        }

        public Guitarist build() {
            return new Guitarist(this);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Guitarist player = new Guitarist.Builder()
            .no(1)
            .name("Slash")
            // .teamName("Beatles")
            .guitar("Lespaul")
            .build();

        Object object = (Object) player;
        System.out.println(object.finalize());
    }
}