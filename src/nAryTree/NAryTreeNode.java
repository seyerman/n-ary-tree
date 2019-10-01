package nAryTree;

import java.util.ArrayList;
import java.util.List;

public class NAryTreeNode<K,T> {
	private T info;
	private K key;
	private NAryTreeNode<K,T> p;
	private List<NAryTreeNode<K,T>> children;
	
	public NAryTreeNode(K k, T data) {
		info = data;
		key = k;
		children = new ArrayList<NAryTreeNode<K,T>>();
		p = null;
	}
	
	public T getInfo(){
		return info;
	}
	
	public K getKey() {
		return key;
	}
	
	public void setP(NAryTreeNode<K,T> parent) {
		p = parent;
	}
	
	public NAryTreeNode<K,T> getP(){
		return p;
	}
	
	public List<NAryTreeNode<K,T>> getChildren(){
		return children;
	}
}
