# Binary Search Trees
> Useful methods/classes for Binary Search Tree (BST)

## Node Class

## BST Class
### Example

```sh
public class MyClass()
{
    public static void main(String args[])
    {
        BST tree = new BST();
        int[] values = new int[] {10, 20, 50, 2, 40};
        for (int v: values)
        {
             tree.root = tree.insert(v, tree.root)
        }
        
        tree.root = tree.remove(values[0], tree.root)
        tree.preOrder(tree.root)
        ...
        
    }
}
```

### Methods

- Insert node

```sh
public Node insert(int key, Node root)
```
- Remove node
 ```sh
public Node remove(int key, Node root) 
```
- Find node
 ```sh
piblic void find(int key, Node root)
```
- Check if a tree is a valid BST
 ```sh
public boolean isValid(Node root)
```
- Pre-order traversal
 ```sh
public void preOrder(Node root)
```
- Post-order traversal
 ```sh
public void postOrder(Node root)
```
- In-order traversal
 ```sh
public void inOrder(Node root)
```
