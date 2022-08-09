import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Config {
    // Working directory
    private String _workingDirectory;

    // Readme destination
    private String _destinationPath;

    // Files to ignore
    private final List<String> _filesToIgnore = new ArrayList<>();

    // Constants
    // Default config file path
    public static final String DEFAULT_CONFIG_FILE = "config.txt";

    // Working directory node
    public static final String WORKING_DIRECTORY = "WORKING_DIRECTORY";

    // Destination node
    public static final String DESTINATION = "DESTINATION";

    // File to ignore
    public static final String FILES_TO_IGNORE = "FILES_TO_IGNORE";

    public String getWorkingDirectory() {
        return _workingDirectory;
    }

    public String getDestinationPath() {
        return _destinationPath;
    }

    public boolean canIgnore(String fileName) {
        return _filesToIgnore.contains(fileName);
    }

    public String toString() {
        return String.format("{workingDirectory: %s, destination: %s, ignore: %s}\n", _workingDirectory, _destinationPath, _filesToIgnore.toString());
    }

    public static Config fromFile(String path) {
        Config config = new Config();

        Parser parser = new Parser()
            .withLogic(WORKING_DIRECTORY, (dir) -> { config._workingDirectory = dir; })
            .withLogic(DESTINATION, (dir) -> { config._destinationPath = dir; })
            .withLogic(FILES_TO_IGNORE, (dir) -> { 
                config._filesToIgnore.addAll(
                    Arrays.stream(dir.split(","))
                        .map(x -> x.trim())
                        .filter(x -> !x.isEmpty())
                        .collect(Collectors.toList())
                ); 
            });

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(parser::process);
            return config;
        } catch (IOException e) {
            System.out.println("Invalid config file path.");
            return null;
        }
    }

    public static Config defaultConfig() {
        return fromFile(DEFAULT_CONFIG_FILE);
    }

    static class Parser {
        Map<String, Consumer<String>> logicMap = new HashMap<>();

        public Parser withLogic(String node, Consumer<String> logic) {
            logicMap.put(node, logic);
            return this;
        }

        public void process(String line) {
            // Ignore comment or new line
            if (line.startsWith("#") || line.startsWith("\n")) {
                return;
            }

            // Parse the node
            String[] parts = line.split("=");
            if (parts.length != 2) {
                return;
            }

            String node = parts[0].trim();
            String value = parts[1].trim();

            if (logicMap.containsKey(node)) {
                logicMap.get(node).accept(value);
            }
        }
    }
}
