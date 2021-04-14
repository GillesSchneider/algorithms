
/**
* Double Linked List Map
* Free to use
* @author Gilles Schneider
*/

class Node
{ 
	Node next;
	Node prev;
	int key; //Keys are integers here
	int value; //Values are integers here
	
	public Node(int key, int value)
	{
		this.next = null;
		this.prev = null;
		this.key = key;
		this.value = value;
	}
	
	public Node(Node node)
	{
		this.next = node.next;
		this.prev = node.prev;
		this.key = node.key;
		this.value = node.value;
	}
	
	@Override
	public String toString()
	{
		return "(prev: " + getKey(prev) + ", key: " + getKey(this) + ", value: " + getValue(this) + ", next: " + getKey(next) + ")";  
	}
	
	/**
	* Get the value of a node:
	* if the node is not null, return value (string, debug purpose)
	* otherwise, return null
	*/
	public String getValue(Node node)
	{
		if (node == null)
		{
			return null;
		}
		return "" + node.value;
	}
	
	/**
	* Get the key of a node:
	* if the node is not null, return value (string, debug purpose)
	* otherwise, return null
	*/
	public String getKey(Node node)
	{
		if (node == null)
		{
			return null;
		}
		return "" + node.key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		return result;
	}

	/**
	* Two nodes are equal if they have the same key
	*/

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


public class SimpleDoubleLinkedListMap 
{
	/**
	* The simple list based map is unordered
	*/
	Node header;
	int n; //Number of entries
	
	public SimpleDoubleLinkedListMap()
	{
		this.header = null;		
	}
	
	/**
	* Get the Node with given key:
	* if Node with key in list, return it
	* otherwise, return null
	*/
	public Node get(int key)
	{
		if (header == null) //List is empty
		{
			return null;
		}
		
		Node current = header;
		
		while (current != null)
		{
			if (current.key == key)
			{
				return current; //Node found
			}
			
			else if (current.next == null)
			{
				return null;
			}
			
			current = current.next;
		}
		return null; //Node not found
	}
	
	/**
	* Put a node with given key and value:
	* if Node with key already in the list, change value and return old node
	* otherwise, add it to the end of the list and return null
	*/
	public Node insert(int key, int value)
	{
		Node target = get(key);
		
		if (header == null)
		{
			header = new Node(key, value);
			n ++;
			return null;
		}
		
		if (target != null) //Node in the list
		{
			Node old = new Node(target);
			target.value = value;
			target.key = key;
			n ++; //Increment the number of entries
			return old;
		}
		
		else //Node not in the list
		{
			Node current = header; //Start at the header
			
			while (current.next != null) //Find the trailer
			{
				current = current.next;
			}
			
			Node newNode = new Node(key, value);
			newNode.prev = current;
			current.next = newNode; //The previous trailer points to the new trailer
			n ++; //Increment the number of entries
			return null;
		}
	}
	
	public Node remove(int key)
	{
		Node target = get(key);
		if (target != null) //Node in the list
		{
			Node old = new Node(target);
			
			if (target.equals(header))
			{
				if (target.next != null)
				{
					header = target.next;
					header.prev = null;
				}
				
				else
				{
					header = null;
				}
			}
			else
			{
				if (target.next != null)
				{
					target.prev.next = target.next;
					target.next.prev = target.prev;
				}
				else
				{
					target.prev.next = null;
				}
			}
			n --; //Decrement the number of entries
			return old;
		}
		
		else //Node in the list
		{
			return null;
		}
	}
	
	@Override
	public String toString()
	{
		Node current = header;
		String print = "header: ";
		
		if (header == null)
		{
			return null;
		}
		
		while (current.next != null)
		{
			print += current.toString() + " <=> ";
			current = current.next;
		}
		
		return print + current.toString() + " :trailer";
	}
}
