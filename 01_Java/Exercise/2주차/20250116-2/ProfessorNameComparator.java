import java.util.Comparator;

public class ProfessorNameComparator implements Comparator<Professor> {
    @Override
    public int compare(Professor p1, Professor p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
