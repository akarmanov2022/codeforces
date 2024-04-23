import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NodeMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> paths = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            paths.add(br.readLine());
        }

        Node root = buildTree(paths);

        printTree(root);
    }

    private static void printTree(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        for (Node value : node.getChildren().values()) {
            printTree(value);
        }
    }

    private static Node buildTree(List<String> paths) {
        Node root = new Node();
        for (String path : paths) {
            String[] parts = path.split("/");
            root.setPath(parts[0]);
            Node current = root;
            String prefix = "  ";
            for (int i = 1; i < parts.length; i++) {
                String part = parts[i];
                if (!current.getChildren().containsKey(part)) {
                    current.addChild(part, new Node(part));
                }
                current = current.getChildren().get(part);
                current.setSpaces(prefix);
                prefix += "  ";
            }
            current.setPath(parts[parts.length - 1]);
        }
        return root;
    }

    private static class Node implements Comparable<Node> {
        private String path;
        private String prefix = "";
        private final Map<String, Node> children = new TreeMap<>();


        private Node() {}

        public Node(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }

        public Map<String, Node> getChildren() {
            return children;
        }

        public void addChild(String path, Node child) {
            children.put(path, child);
        }

        public void setPath(String path) {
            this.path = path;
        }

        @Override
        public String toString() {
            return prefix + path;
        }

        public String getSpaces() {
            return prefix;
        }

        public void setSpaces(String prefix) {
            this.prefix = prefix;
        }

        @Override
        public int compareTo(Node o) {
            return path.compareTo(o.path);
        }
    }
}
