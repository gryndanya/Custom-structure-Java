import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomList {
    public static void main(String[] args) throws IOException {

        class Node {

            private String data;
            private Node nextNode;

            public Node(String data){
                this.data = data;
            }

            public String getData() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }

            public Node getNextNode() {
                return nextNode;
            }

            public void setNextNode(Node nextNode) {
                this.nextNode = nextNode;
            }
        }
        class CustomLinkedList {

            private Node head;

            public CustomLinkedList(){
            }

            public void insert(String data){
                Node newNode = new Node(data);
                if(this.head == null){
                    head = newNode;
                }else {
                    Node currentNode = head;
                    while(currentNode.getNextNode() != null){
                        currentNode = currentNode.getNextNode();
                    }
                    currentNode.setNextNode(newNode);
                }
            }
            public void insertAt(int index, String data){
                Node nodeToBeInserted = new Node(data);
                Node node = head;
                for(int i = 0; i< index -1; i++){
                    node = node.getNextNode();
                }
                nodeToBeInserted.setNextNode(node.getNextNode());
                node.setNextNode(nodeToBeInserted);
            }
            public void deleteNodeAt(int index){
                Node node = head;
                for(int i = 0; i< index -1; i++){
                    node = node.getNextNode();
                }
                node.setNextNode(node.getNextNode().getNextNode());
            }
            public void display(){
                if(head != null){
                    Node currentNode = head;
                    while(currentNode.getNextNode() != null){
                        System.out.println(currentNode.getData());
                        currentNode = currentNode.getNextNode();
                    }
                    System.out.println(currentNode.getData());
                }
            }
            public Node reverse(){
                Node previous = null;
                Node current = head;
                Node next;
                while (current != null){
                    next = current.getNextNode();
                    current.setNextNode(previous);
                    previous = current;
                    current = next;
                }
                return previous;
            }
        }

        CustomLinkedList list = new CustomLinkedList();
        String fileName = "src/names.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            list.insert(line);
        }
        // delete the last new line separator
        reader.close();
        list.display();
    }
}