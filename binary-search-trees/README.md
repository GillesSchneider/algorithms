# Binary Search Trees
> Useful methods

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

- Insert node by its key

```sh
insert(int key, Node root): returns Node
```
- Remove node by its key
 ```sh
remove(int key, Node root): returns Node
```
- Find node by its key
 ```sh
find(int key, Node root): returns Node or null
```
- Check if a tree is a valid BST
 ```sh
isValid(Node root): returns True or False
```
- Pre-order traversal
 ```sh
preOrder(Node root): void
```
- Post-order traversal
 ```sh
postOrder(Node root): void
```
- In-order traversal
 ```sh
inOrder(Node root): void
```
