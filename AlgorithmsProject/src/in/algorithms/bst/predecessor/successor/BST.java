package in.algorithms.bst.predecessor.successor;

public class BST {
	private BSTNode root = null;
	private BSTNode successor, predecessor;

	public BST(int value) {
		this.root = new BSTNode(value);
	}

	public BST insertValue(int valueToInsert) {
		this.root = insertIntoBST(valueToInsert, root);
		return this;
	}

	public void printInOrder() {
		inOrder(root);
	}

	public void printPostOrder() {
		postOrder(root);
	}

	public void printPreOrder() {
		preOrder(root);
	}

	public SuccPredTuple getPredecessorSuccessor(int value) {
		calculateSuccessorPredecessor(root, value);
		return new SuccPredTuple(predecessor, successor);
	}

	private void calculateSuccessorPredecessor(BSTNode currentNode,
			int valueToFind) {
		if (currentNode == null) {
			successor = predecessor = null;
		}

		else if (currentNode.value == valueToFind) {
			if (currentNode.lchild != null) {
				predecessor = rightMostNode(currentNode);
			}
			if (currentNode.rchild != null) {
				successor = leftMostNode(currentNode);
			}
		}

		else if (currentNode.value > valueToFind) {
			successor = currentNode;
			calculateSuccessorPredecessor(currentNode.lchild, valueToFind);
		} else {
			predecessor = currentNode;
			calculateSuccessorPredecessor(currentNode.rchild, valueToFind);
		}
	}

	private BSTNode leftMostNode(BSTNode currentNode) {
		BSTNode temp = null;
		while (currentNode != null) {
			temp = currentNode;
			currentNode = currentNode.lchild;
		}
		return temp;
	}

	private BSTNode rightMostNode(BSTNode currentNode) {
		BSTNode temp = null;
		while (currentNode != null) {
			temp = currentNode;
			currentNode = currentNode.rchild;
		}
		return temp;
	}

	private BSTNode insertIntoBST(int valueToInsert, BSTNode currentNode) {
		if (currentNode == null)
			return new BSTNode(valueToInsert);
		else if (currentNode.value == valueToInsert)
			return currentNode;
		else if (currentNode.value > valueToInsert)
			currentNode.lchild = insertIntoBST(valueToInsert,
					currentNode.lchild);
		else
			currentNode.rchild = insertIntoBST(valueToInsert,
					currentNode.rchild);
		return currentNode;
	}

	private void inOrder(BSTNode currentNode) {
		if (currentNode == null)
			return;
		else {
			inOrder(currentNode.lchild);
			System.out.print(currentNode.value + " ");
			inOrder(currentNode.rchild);
		}
	}

	private void postOrder(BSTNode currentNode) {
		if (currentNode == null)
			return;
		else {
			postOrder(currentNode.lchild);
			postOrder(currentNode.rchild);
			System.out.print(currentNode.value + " ");
		}
	}

	private void preOrder(BSTNode currentNode) {

		if (currentNode == null)
			return;
		else {
			System.out.print(currentNode.value + " ");
			preOrder(currentNode.lchild);
			preOrder(currentNode.rchild);
		}
	}

}
