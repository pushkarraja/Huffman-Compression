public class Node implements Comparable<Node> {

    private final int frequency;
    private final Node leftNode;
    private final Node rightNode;

    public Node(Node leftNode, Node rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.frequency = leftNode.getFrequency() + rightNode.getFrequency();
    }

    public Node(int frequency) {
        this.frequency = frequency;
        leftNode = null;
        rightNode = null;
    }


    public int getFrequency() {
        return this.frequency;
    }


    @Override
    public int compareTo(Node node) {
        return Integer.compare(frequency, node.getFrequency());
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }
}
