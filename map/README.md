# Map
> Useful methods

## Single Double Linked Map
### Example

```sh
public class Main {

	public static void main(String args[])
	{
		SimpleDoubleLinkedListMap map = new SimpleDoubleLinkedListMap();
		
		map.insert(0, 1);
		map.insert(1, 3);
		map.insert(2, 54);
		map.insert(2, 45);
		map.insert(0, 2);
		map.insert(4, 231);
		System.out.println(map);
		map.remove(0);
		System.out.println(map);
		map.remove(2);
		System.out.println(map);
		map.remove(4);
		System.out.println(map);
		map.remove(1);
		System.out.println(map);
		map.remove(2);
        ...
	}
}
```

Output:


### Methods

- Get(k): if the map M has Node with key k, return the node; else, return null
```sh
get(int key)
```
- Insert(k, v): insert Node(k, v) into the map M; if node with key k is already in M, replace the value with v and return old node; else, add the new node to the end of the list and return null; note that adding the new node to the beginning of the list is more efficient.
 ```sh
 insert(int key, int value)
```
- Remove(k): if the map M has a node with key k, remove it from M and return it; else, return null;
 ```sh
 remove(int key)
```
