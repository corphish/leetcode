import java.util.ArrayList;
import java.util.List;

// Data class to hold solutions for each type
public class SolutionGroup {
    private final String _groupName;
    private final List<Solution> _solutions = new ArrayList<>();

    public SolutionGroup(String groupName, List<Solution> solutions) {
        this._groupName = groupName;
        this._solutions.addAll(solutions);
    }

    public String getGroupName() {
        return _groupName;
    }

    public List<Solution> getSolutions() {
        return _solutions;
    }

    public String toString() {
        return String.format("{name=%s, solutions=%s}\n", _groupName, _solutions.toString());
    }
}
