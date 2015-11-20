package ua.luckydev.zadachki;

/**
 * Created by Lucky on 17.09.2015.
 */
public class BinaryTree
{

    Node root;

    public BinaryTree()
    {
        this.root = null;
    }

    public static void main(String[] args)
    {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(50, "Boss");
        binaryTree.addNode(25, "Vice President");
        binaryTree.addNode(15, "Office Manager");
        binaryTree.addNode(30, "Secretary");
        binaryTree.addNode(75, "Sales Manager");
        binaryTree.addNode(85, "Salesman 1");
        binaryTree.addNode(2, "Salesman 2");
        binaryTree.addNode(60, "Salesman 1");
        binaryTree.addNode(10, "Salesman 1");
        binaryTree.addNode(3, "Salesman 1");
        binaryTree.addNode(1, "Salesman 1");

        binaryTree.preorderTraverse(binaryTree.root);

    }

    public void addNode(int key, String name)
    {
        Node newNode = new Node(key, name);
        if (root == null)
        {
            root = newNode;
            return;
        }
        else
        {
            Node currentNode = root;
            while(true)
            {
                if (key < currentNode.key)
                {
                    if (currentNode.leftChild == null)
                    {
                        currentNode.leftChild = newNode;
                        return;
                    }
                    currentNode = currentNode.leftChild;
                }
                else
                {
                    if (currentNode.rightChild == null)
                    {
                        currentNode.rightChild = newNode;
                        return;
                    }
                    currentNode = currentNode.rightChild;
                }
            }
        }
    }

    public void preorderTraverse(Node currentNode)
    {
        if(currentNode!=null)
        {
            System.out.println(currentNode);
            preorderTraverse(currentNode.leftChild);
            preorderTraverse(currentNode.rightChild);
        }
    }

    class Node
    {
        int key;
        String name;
        Node leftChild;
        Node rightChild;

        public Node(int key, String name)
        {
            this.key = key;
            this.name = name;
            this.leftChild = null;
            this.rightChild = null;
        }

        @Override
        public String toString()
        {
            return name + " has the key "+key;
        }
    }
}
