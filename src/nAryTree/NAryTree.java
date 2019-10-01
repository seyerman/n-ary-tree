package nAryTree;

import java.util.List;

public class NAryTree <K,T>{
	private NAryTreeNode<K,T> root;
	
	public NAryTree() {
		root = null;
	}
	
	//key!=null
	public T search(K key) {
		NAryTreeNode<K, T> node = search(key,root);
		if(node!=null) {
			return node.getInfo();
		}else {
			return null;
		}
	}
	
	//key!=null
	private NAryTreeNode<K, T> search(K key, NAryTreeNode<K, T> rnode) {
		if(rnode==null || rnode.getKey().equals(key)) {
			return rnode;
		}else {
			NAryTreeNode<K, T> value = null;
			List<NAryTreeNode<K, T>> children = rnode.getChildren();
			for (int i = 0; i < children.size() && value==null; i++) {
				value = search(key,children.get(i));
			}
			return value;
		}
	}
	
	public boolean add(K pk, K k, T v) {
		boolean added = false;
		
		NAryTreeNode<K, T> newNode = new NAryTreeNode<K, T>(k, v);
		
		if(pk==null && root==null) {
			root = newNode;
			added = true;
		}else{
			NAryTreeNode<K, T> parent = search(pk,root);
			NAryTreeNode<K, T> node = search(k,root);
			if(parent!=null && node==null) {
				parent.getChildren().add(newNode);
				added = true;
			}
		}
		
		return added;
	}
	
	//k!=null
	public boolean isLeaf(K k) {
		boolean leaf = false;
		NAryTreeNode<K, T> node = search(k,root);
		if(node!=null && node.getChildren().size()==0) {
			 leaf = true;
		}
		return leaf;
	}
	
	public int leafsAmount() {
		return leafsAmount(root);
	}
	
	private int leafsAmount(NAryTreeNode<K, T> rnode) {
		if(rnode==null) {
			return 0;
		}else if(rnode.getChildren().size()==0){
			return 1;
		}else{
			int leafsAmount = 0;
			List<NAryTreeNode<K, T>> children = rnode.getChildren();
			for(int i=0;i<children.size();i++) {
				leafsAmount += leafsAmount(children.get(i));
			}
			return leafsAmount;
		}
	}
}
