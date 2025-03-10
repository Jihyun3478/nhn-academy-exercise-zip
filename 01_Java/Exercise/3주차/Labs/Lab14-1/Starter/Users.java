import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class Users<E extends User> implements Iterable<E> {
    private String name;
    private String address;
    private List<E> list;

    public Users(String name, String address) {
        this.name = name;
        this.address = address;
        this.list = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public List<E> getList() {
        return this.list;
    }

    public void add(E user) {
        this.list.add(user);
    }

    public void sortByNo() {
        Collections.sort(list, (u1, u2) -> u1.getUserNo() - u2.getUserNo());
    }

    public void sortByName() {
        Collections.sort(list, (u1, u2) -> u2.getUserName().compareTo(u1.getUserName()));
    }

    public void sortByAge() {
        Collections.sort(list, new DesendingOrder());
    }

    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }
}
