import java.util.Comparator;

public class DesendingOrder implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user2.getUserAge() - user1.getUserAge();
    }
}
