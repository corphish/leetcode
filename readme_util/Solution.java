public class Solution {
    private final String _name;
    private final String _link;
    private final String _repoLink;

    public Solution(String name, String link, String repoLink) {
        this._name = name;
        this._link = link;
        this._repoLink = repoLink;
    }

    public String getName() {
        return _name;
    }

    public String getLink() {
        return _link;
    }

    public String getRepoLink() {
        return _repoLink;
    }

    public String toString() {
        return String.format("{name=%s, link=%s, repo=%s}\n", _name, _link, _repoLink);
    }
}
