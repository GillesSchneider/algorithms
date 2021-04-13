
public class BST {

	Node root;
	
	public BST()
	{
		this.root = null;
	}
	
	//Insert a new node with given key
	public Node insert(int key, Node root)
	{	
		if (root == null)
		{
			return new Node(key);
		}
		else if (root.key < key)
		{
			root.right = insert(key, root.right);
			root.right.parent = root; //Update parent
		}
		else if (root.key <= key)
		{
			root.left = insert(key, root.left);
			root.right.parent = root; //Update parent
		}
		else //Do not allow duplicated values
		{
			return root;
		}
		
		//Update height
		root.height = 1 + Math.max(root.right.height, root.left.height); 
		return root;
	}
	
	//Find a node in BST
	//Returns null if not present
	public static Node find(int value, Node node)
	{
		while (node != null && node.key != value)
		{
			if (value < node.key)
			{
				node = node.left;
			}
			else
			{
				node = node.right;
			}
		}
		return node;
	}
	
	//Remove a node from BST
	public static Node remove(int value, Node root)
	{
		
		Node curr = find(value, root);
		
		if (curr == null)
		{
			return root;
		}
		
		Node parent = curr.parent;
		
		//The node is a leaf
		if (curr.left == null && curr.right == null)
		{
			if (!curr.equals(root))
			{
				if (curr.equals(parent.left))
				{
					parent.left = null;
				}
				else
				{
					parent.right = null;
				}
			}
			else
			{
				root = null;
			}
		}
		
		//The node has two children
		else if (curr.left != null && curr.right != null)
		{
			Node successor = curr.right;
			
			while (successor.left != null)
			{
				successor = successor.left;
			}
			
			int val = successor.key;
			
			remove(val, root);
			
			curr.key = val;
			
		}
		
		//The node has one child
		else
		{
			Node child = (curr.left != null)? curr.left: curr.right;
			child.parent = parent;
			if (!curr.equals(root))
			{
				if (curr.equals(parent.left))
				{
					parent.left = child;
				}
				else
				{
					parent.right = child;
				}
			}
			else
			{
				root = child;
			}
		}
		
		return root;
	}
	
	//Verify if a binary tree is a valid binary search tree
	public boolean isValid(Node root)
	{
		if (root == null)
		{
			return true;
		}
		
		if ((getKeyInt(root.left) < root.key && getKeyInt(root.right) >= root.key) && isValid(root.left) && isValid(root.right))
		{
			return true;
		}
		
		return false;
		
	}
	
	//Get integer value of node key
	public int getKeyInt(Node node)
	{
		if (node == null)
		{
			return 0;
		}
		return node.key;
	}
	
	//Preorder traversal
	public void preOrder(Node root)
	{
		if (root == null)
		{
			return;
		}
		
		System.out.println(root);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	//Postorder traversal
	public void postOrder(Node root)
	{
		if (root == null)
		{
			return;
		}
		
		preOrder(root.left);
		preOrder(root.right);
		System.out.println(root);
	}
	
	//Inorder traversal
	public void inOrder(Node root)
	{
		if (root == null)
		{
			return;
		}
		
		preOrder(root.left);
		System.out.println(root);
		preOrder(root.right);
	}
}
