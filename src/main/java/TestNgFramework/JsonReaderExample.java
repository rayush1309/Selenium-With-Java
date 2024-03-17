import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReaderExample {

    public static void readDataFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Specify the path to your JSON file
        File jsonFile = new File("resources/login.json");

        // Read JSON file into a JsonNode
        JsonNode rootNode = objectMapper.readTree(jsonFile);

        // Iterate through the array elements
        for (JsonNode userNode : rootNode) {
            // Access elements by their keys within each object
            String name = userNode.get("Name").asText();
            String password = userNode.get("Password").asText();
            boolean booleanValue = userNode.get("boolean").asBoolean();

            // Now you can use the variables as needed
            System.out.println("Name: " + name);
            System.out.println("Password: " + password);
            System.out.println("Boolean: " + booleanValue);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            readDataFromJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
