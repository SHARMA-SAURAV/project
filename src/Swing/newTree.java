import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;

public class newTree {

    public static void main(String[] args) {
        try {
            JsonObject jsonObject = JsonParser.parseReader(new FileReader("C:\\Users\\admin\\Downloads\\0 (1).json")).getAsJsonObject();
            DefaultMutableTreeNode root = createTreeNode(jsonObject);

            JTree tree = new JTree(root);

            JFrame frame = new JFrame("JSON to JTree Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new JScrollPane(tree));
            frame.setSize(300, 300);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static DefaultMutableTreeNode createTreeNode(JsonObject jsonObject) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(jsonObject);

        for (String key : jsonObject.keySet()) {
            DefaultMutableTreeNode childNode;
            if (jsonObject.get(key).isJsonObject()) {
                childNode = createTreeNode(jsonObject.get(key).getAsJsonObject());
            } else {
                childNode = new DefaultMutableTreeNode(key + ": " + jsonObject.get(key).getAsString());
            }
            node.add(childNode);
        }

        return node;
    }
}
