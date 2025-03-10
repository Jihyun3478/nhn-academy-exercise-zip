package player;
public class Orch {
    public static void main(String[] args) {
        Player v1 = new ViolinPlayer();
        Player v2 = new ViolinPlayer();

        Player t1 = new TrumpetPlayer();
        Player t2 = new TrumpetPlayer();

        Player[] orchestra = { v1, v2, t1, t2 };

        for(Player p : orchestra) {
            p.play();
        }
    }
}
