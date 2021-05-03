package com.codewithaditi;

public class HashTable {
	String[] keys;
	String[] values;
	int currentLen;
	int maxLength;
	
	HashTable(int maxLength) {
		this.maxLength = maxLength;
		keys = new String[maxLength];
		values = new String[maxLength];
		currentLen = 0;
	}
	
	public void put(String key, String value) {
		int index = hash(key);
		int temp = index;
		do {
			if(keys[index] == null) {
				keys[index] = key;
				values[index] = value;
				currentLen++;
			}
			
			if(keys[index] == key) {
				values[index] = value;
				return;
			}
			
			index = (index+1) % maxLength;
		} while(index != temp);
	}
	
	public int hash(String key) {
		int x = 0; 
		for(char c : key.toCharArray())
			x += c;
		return x % maxLength;
	}
	
	public void remove(String key) {
		if(!contains(key))
			return;
		
		int i = hash(key);
		while(!keys[i].equals(key))
			i = (i+1) % maxLength;
		
		keys[i] = values[i] = null;
		
		for(i = (i+1) % maxLength; keys[i] != null; i = (i+1) % maxLength) {
			String x = keys[i];
			String y = values[i];
			keys[i] = values[i] = null;
			currentLen--;
			put(x,y);
		}
		
		currentLen--;
	}
	
	public boolean contains(String key) {
		return get(key) != null;
	}
	
	public int size() {
		return currentLen;
	}
	
	public String get(String key) {
		int i = hash(key);
		while(keys[i] != null) {
			if(key.equals(keys[i]))
				return values[i];
			i = (i+1) % maxLength;
		}
		return null;
	}
	
	public void printHashTable() {
		for(int i = 0; i < maxLength; i++) {
			if(keys[i] != null) {
				System.out.println("Key: " + keys[i] + ", Value: " + values[i]);
			}
		}
	}
	
	public boolean isEmpty() {
		return currentLen == 0;
	}
	
	public boolean isFull() {
		return currentLen == maxLength;
	}
	
	public void makeEmpty() {
		keys = new String[maxLength];
		values = new String[maxLength];
		currentLen = 0;
	}
}

//----------------------------------------------------------------------------------------------------------------

package com.codewithaditi;

public class Main {
	public static void main(String[] args) {
		HashTable table = new HashTable(5);
		table.put("6","A");
		table.put("8","B");
		table.put("11", "C");
		table.put("6", "A+"); 
		System.out.println(table.get("8"));
		//table.remove(6);
		System.out.println(table.get("60"));
		table.remove("60");
		table.printHashTable();
		//System.out.println(Arrays.toString(table.entries));
	}
}
