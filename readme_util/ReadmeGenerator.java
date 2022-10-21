import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadmeGenerator {
    public static void main(String[] args) {
        Config config = Config.defaultConfig();
        SolutionParser parser = new SolutionParser(config);
        try {
            Files.write(Paths.get(config.getDestinationPath()), generateReadmeContents(parser).getBytes());
        } catch (IOException e) {
            System.out.println("Error writing to destination file.");
        }
    }

    private static String generateReadmeContents(SolutionParser parser) {
        StringBuilder sb = new StringBuilder();

        // Intro stuff
        sb.append("# LeetCode solutions").append("\n");
        sb.append("My solutions to various problems on LeetCode. Solutions are written in Java. They are divided into various sections. Individual details of a problem are given in their respective sections. Here is my [leetcode profile link](https://leetcode.com/jorgophool/).").append("\n\n");

        sb.append("## Solutions").append("\n");
        sb.append("Solutions are grouped by its type and in most cases has a leetcode link associated to it. This is generated using the [readme generator util](readme_util/).").append("\n\n");

        for (SolutionGroup solutionGroup: parser.getData()) {
            sb.append("#### ").append(solutionGroup.getGroupName()).append("\n");
            sb.append("|Solution|Leetcode Link|\n|--------|-----------|\n");

            for (Solution solution: solutionGroup.getSolutions()) {
                sb.append("|[")
                    .append(solution.getName())
                    .append("](")
                    .append(solution.getRepoLink()).append(")|")
                    .append(solution.getLink() == null || solution.getLink().isEmpty() ? "-" : "[Link](" + solution.getLink() + ")").append("|\n");
            }

            sb.append("|Total|").append(solutionGroup.getSolutions().size()).append("|\n\n\n");
        }

        sb.append("## Summary").append("\n");
        sb.append("Thank you for checking out my solutions to these ").append(parser.getCount()).append(" leetcode problems. Let me know if any solution can be improved.\n");

        return sb.toString();
    }
}