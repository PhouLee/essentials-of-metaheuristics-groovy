package TreeBaseGP

class Node {
	Node parent, leftChild, rightChild
	Integer depth, arity
	def value
	static ArrayList<Node> listOfNodes = new ArrayList<Node>()
	static Map variables

	def setLeftChild(Node node) {
		this.leftChild = node
		node.parent = this
	}

	def setRightChild(Node node) {
		this.rightChild = node
		node.parent = this
	}

	String toString() {
		value
	}

	def root(){
		if(this.parent != null){
			this.parent.root()
		}
		else this
	}

	public ArrayList<Node> toList() {
		if(listOfNodes.empty == false){
			listOfNodes = new ArrayList<Node>()
		}
		this.makeList()
	}

	private ArrayList<Node> makeList() {
		if(this.leftChild != null){
			this.leftChild.makeList()
		}
		if(this.rightChild != null){
			this.rightChild.makeList()
		}
		listOfNodes.add(this)
		listOfNodes
	}

	def swapSubTree(Node oldChild, Node newChild) {
		if(leftChild == oldChild) {
			this.setLeftChild(newChild)
		}
		else this.setRightChild(newChild)
	}

	private evaluate() {
		switch(value) {
			case "+": this.leftChild.evaluate() + this.rightChild.evaluate()
				break
			case "-": leftChild.evaluate() - rightChild.evaluate()
				break
			case "*": leftChild.evaluate() * rightChild.evaluate()
				break
			case "/": leftChild.evaluate() / rightChild.evaluate()
				break
			case "sin": Math.sin(leftChild.evaluate())
				break
			case "cos": Math.cos(leftChild.evaluate())
				break
			case "tan": Math.tan(leftChild.evaluate())
				break
			case "log": Math.sin(leftChild.evaluate())
				break
			case "abs": Math.abs(leftChild.evaluate())
				break
			case "exp": Math.exp(leftChild.evaluate())
				break
			default: if(value.class.toString() == "class java.lang.String"){
				variables.get(value)
			} else {
				value
			}
				break
		}
	}
}
