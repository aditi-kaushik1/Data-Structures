package com.codewithaditi;

import java.util.*;

public class HashTable {
	private class Entry {
		int key;
		String value;
		
		private Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private LinkedList<Entry>[] entries = new LinkedList[5];
	
	public void put(int key, String value) {
		Entry entry = getEntry(key);
		if(entry != null) {
			entry.value = value;
			return;
		}
		
		getOrCreateBucket(key).addLast(new Entry(key,value));
	}
	
	public String get(int key) {
		Entry entry = getEntry(key);
		return entry == null ? null : entry.value;
//		int index = hash(key);
//		LinkedList<Entry> bucket = entries[index];
//		if(bucket != null) {
//			for(var entry : bucket) {
//				if(entry.key == key)
//					return entry.value;
//			}
//		}
//		return null;
	}
	
	public void remove(int key) {
		Entry entry = getEntry(key);
		if(entry == null)
			throw new IllegalStateException();
		getBucket(key).remove(entry);
		
//		int index = hash(key);
//		
//		LinkedList<Entry> bucket = entries[index];
//		if(entries[index] == null)
//			throw new IllegalStateException();
//			for(var entry : entries[index]) {
//				if(entry.key == key) {
//					bucket.remove(entry);
//					return;
//				}
//			}
//		throw new IllegalStateException();
	}
	
	private LinkedList<Entry> getBucket(int key) {
		return entries[hash(key)];
	}
	
	private LinkedList<Entry> getOrCreateBucket(int key) {
		int index = hash(key);
		if(entries[index] == null)
			entries[index] = new LinkedList<>();
		return entries[index];
	}
	
	private Entry getEntry(int key) {
		LinkedList<Entry> bucket = getBucket(key);
		if(bucket != null) {
			for(Entry entry : bucket) {
				if(entry.key == key)
					return entry;
			}
		}
		
		return null;
	}
	
	public int hash(int key) {
		return Math.abs(key) % entries.length;
	}
}

//---------------------------------------------------------------------

package com.codewithaditi;

public class Main {
	public static void main(String[] args) {
		HashTable table = new HashTable();
		table.put(6,"A");
		table.put(8,"B");
		table.put(11, "C");
		table.put(6, "A+"); 
		System.out.println(table.get(11));
		//table.remove(6);
		System.out.println(table.get(60));
		table.remove(60);
	}
}
