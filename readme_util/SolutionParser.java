import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SolutionParser {
    private final Config config;

    private final List<SolutionGroup> solutionGroups = new ArrayList<>();
    private int count = 0;

    public SolutionParser(Config config) {
        this.config = config;

        parse();
    }

    public List<SolutionGroup> getData() {
        return solutionGroups;
    }

    public int getCount() {
        return count;
    }

    private void parse() {
        try {
            File root = new File(config.getWorkingDirectory());

            // Read the children
            // Expectation is that it is a folder
            for (File l1: root.listFiles()) {
                // Process directory only
                if (l1.isDirectory() && !config.canIgnore(l1.getName())) {
                    String groupName = processGroupName(l1.getName());
                    List<Solution> solutionForThisGroup = new ArrayList<>();

                    for (File l2: l1.listFiles()) {
                        String solutionName = l2.getName().replace(".java", "");
                        String repoLink = l1.getName() + "/" + l2.getName();
                        StringBuilder link = new StringBuilder();

                        // Try to extract leetcode link
                        try (Stream<String> stream = Files.lines(Paths.get(l2.getAbsolutePath()))) {
                            stream.forEach(x -> {
                                if (x.contains("https://leetcode.com") && link.length() == 0) {
                                    int start = x.indexOf("https://leetcode.com");
                                    int end = x.indexOf(" ", start);

                                    if (end > start) {
                                        link.append(x.substring(start, end));
                                    } else {
                                        link.append(x.substring(start));
                                    }
                                }
                            });
                        } catch (IOException e) {
                            System.out.println("Error while reading " + l2.getAbsolutePath());
                        }

                        solutionForThisGroup.add(new Solution(solutionName, link.toString(), repoLink));
                    }

                    solutionGroups.add(new SolutionGroup(groupName, solutionForThisGroup));
                    count += solutionForThisGroup.size();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String processGroupName(String folderName) {
        String[] parts = folderName.replace("_", " ").split(" ");
        StringBuilder sb = new StringBuilder();

        for (String part: parts) {
            char[] arr = part.toCharArray();
            arr[0] = Character.toUpperCase(arr[0]);

            sb.append(new String(arr)).append(" ");
        }

        return sb.toString().trim();
    }
}
