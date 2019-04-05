class BSTNode<Item>
{
    Comparable data;
    BSTNode right;
    BSTNode left;

    //constructor
    public BSTNode(Comparable data)
    {
        this.data = data;
        right = null;
        left = null;
    }

    //getters and setters
    public void setRight(BSTNode right)
    {
        this.right = right;
    }

    public BSTNode getRight()
    {
        return right;
    }

    public void setLeft(BSTNode left)
    {
        this.left = left;
    }

    public BSTNode getLeft()
    {
        return left;
    }

    public void setData(Comparable data)
    {
        this.data = data;
    }

    public Comparable getData()
    {
        return data;
    }
}

public class BST<Item>
{
    BSTNode root;

    //find node in tree
    public boolean find(Comparable item)
    {
        return find(root, item);
    }

    private boolean find(BSTNode node, Comparable item)
    {
        if (node == null)
        {
            return false;
        }
        if (node.getData().compareTo(item) == 0)
        {
            return true;
        }
        else if (node.getData().compareTo(item) < 0)
        {
            return find(node.getRight(), item);
        }
        else
        {
            return find(node.getLeft(), item);
        }
    }

    //insert node into tree
    public void insert(Comparable item)
    {
        root = insert(root, item);
    }

    private BSTNode insert(BSTNode node, Comparable item)
    {
        if (node == null)
        {
            BSTNode nodeNode = new BSTNode(item);
            return nodeNode;
        }
        else if (node.getData().compareTo(item) < 0)
        {
            BSTNode nodeNode = insert(node.getRight(), item);
            node.setRight(nodeNode);
        }
        else 
        {
            BSTNode nodeNode = insert(node.getLeft(), item);
            node.setLeft(nodeNode);
        }
        return node;
    }

    //delete node from tree
    public void delete(Comparable item)
    {
        root = delete (root, item);
    }

    private BSTNode delete(BSTNode node, Comparable item)
    {
        if (node == null)
        {
            return null;
        }
        if (node.getData().compareTo(item) == 0)
        {
            if (node.getLeft() == null)
            {
                return node.getRight();
            }
            else if (node.getRight() == null)
            {
                return node.getLeft();
            }
            else
            {
                if (node.getRight().getLeft() == null)
                {
                    node.setData(node.getRight().getData());
                    node.setRight(node.getRight().getRight());
                    return node;
                }
                else 
                {
                    node.setData(removeSmallest(node.getRight()));
                    return node;
                }
            }
        }
        else if(node.getData().compareTo(item) > 0)
        {
            node.setRight(delete(node.getRight(), item));
        }
        else
        {
            node.setLeft(delete(node.getLeft(), item));
        }
        return node;
    }

    public Comparable removeSmallest(BSTNode node)
    {
        if (node.getLeft().getLeft() == null)
        {
            Comparable smallest = node.getLeft().getData();
            node.setLeft(node.getLeft().getRight());
            return smallest;
        }
        else
        {
            return removeSmallest(node.getLeft());
        }
    }

    //print tree
    public void print()
    {
        print(root);
    }

    private void print(BSTNode node)
    {
        if (node != null)
        {
            print(node.getLeft());
            System.out.println(node.getData());
            print(node.getRight());
        } 
    }
}