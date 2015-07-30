package in.algorithms.bst.predecessor.successor;

public class SuccessorAndPredecessor {
	public static void main(String[] args) {
		BST bst = new BST(10);
		bst.insertValue(4).insertValue(17).insertValue(15).insertValue(13).insertValue(16).insertValue(18);
		bst.printInOrder();System.out.println();
		bst.printPreOrder();System.out.println();
		bst.printPostOrder();System.out.println();
		SuccPredTuple predecessorSuccessor = bst.getPredecessorSuccessor(13);
		System.out.println("Predcessor of 13 is " + predecessorSuccessor.predecessor.value );
		System.out.println("Successor of 13 is " + predecessorSuccessor.successor.value );
		predecessorSuccessor = bst.getPredecessorSuccessor(16);
		System.out.println("Predcessor of 16 is " + predecessorSuccessor.predecessor.value );
		System.out.println("Successor of 16 is " + predecessorSuccessor.successor.value );
	}
}
