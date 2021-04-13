
public class Node {

	int key;
	int height;
	Node left;
	Node right;
	Node parent;
	
	public Node(int key)
	{
		this.key = key;
		this.height = 1;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	@Override
	public String toString()
	{
		return "(key: " + key + "parent :" + getKey(parent) + "left: " + getKey(left) + "right: " + getKey(right) + "height: " + height +  ")"; 
	}
	
	public String getKey(Node N)
	{
		if (N == null)
		{
			return "null";
		}
		return String.valueOf(N.key);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Node))
			return false;
		Node other = (Node) obj;
		if (key != other.key)
			return false;
		return true;
	}
	
	
}
