package TreeBaseGP
import java.util.ArrayList;
import java.util.Random

class Tree {
    Random random = new Random()
    Node root
    Integer size = 0, maxInteger = 11, maxDepth = random.nextInt(11);
    List innerNodes, terminalNodes
    static List arityTwo = ["+", "-","/","*"]
    static List operators = ["sin","cos","tan","log","exp","abs", "+", "-","/","*"]
    
    def makeTree(innerNodes, terminalNodes) {
        this.innerNodes = innerNodes
        this.terminalNodes = terminalNodes
        root = new Node(depth:0)
        this.setValue(root)
    }
    
    private setValue(Node node) {
        if(node.depth != maxDepth){
           if(!innerNodes.isEmpty()){
                node.value = innerNodes.get(random.nextInt(innerNodes.size()))
            }
           else{
               node.value = operators.get(random.nextInt(operators.size()))
           }
           if(arityTwo.contains(node.value)) node.arity = 2
           else node.arity = 1
           
           setValue(node.setLeftChild(new Node(depth:node.depth+1)))
           if(node.arity == 2) setValue(node.setRightChild(new Node(depth:node.depth+1)))
        }
        else{
            
           node.value = random.nextInt(maxInteger)
           if(random.nextInt(2) == 0 && !terminalNodes.isEmpty()){
               node.value = terminalNodes.get(random.nextInt(terminalNodes.size()))
           }
        }
        size++
    }
    
    def evaluate(variables) {
        root.variables = variables
        root.evaluate()
    }
    
    public ArrayList<Node> toList() {
        root.toList()
    }
    
    def size() {
        size
    }
    
    def crossover(Tree treeA, Tree treeB) {
		Node nodeA = findANodeAt(treeA.root, getRandomDepth(treeA))
        Node nodeB = findANodeAt(treeB.root, getRandomDepth(treeB))

        Node parentA = nodeA.parent
        Node parentB = nodeB.parent
		println "First node & depth: " + nodeA + " || " + nodeA.depth
		println "Second node & depth: " + nodeB + " || " + nodeB.depth

        parentA.swapSubTree(nodeA, nodeB)
        parentB.swapSubTree(nodeB, nodeA)
		
		// treeOneNode.changeParent(parentB)
        // treeTwoNode.changeParent(parentA)
        
        // fixDepth(parentA)
        // fixDepth(parentB)
    }
	
	/*
	 * Finds the appropriate tree depth for crossover
	 * Ignores the terminal and root nodes
	 */
	private Integer getRandomDepth(Tree tree) {
		Integer randomDepth = random.nextInt(tree.maxDepth)
		if(randomDepth == 0) {
			randomDepth++
		}		
		randomDepth
	}
    
    def mutuate(Tree tree) {
        Node node = findANodeAt(tree.root, getRandomDepth(tree))
       
    }
    
	/*
	 * Randomly selects node at the given depth
	 */
    private Node findANodeAt(Node node, depth) {
        if(node.depth != depth){
            if(node.arity == 2 && random.nextInt(2) == 1) {
                findANodeAt(node.rightChild, depth)
            }
            else findANodeAt(node.leftChild, depth)
        }
        else node
    }
    
    private def fixDepth(Node node) {
        node.depth = node.parent.depth + 1
        if(node.leftChild != null && node.leftChild.depth != (node.depth+1)) fixDepth(node.leftChild)
        if(node.rightChild != null && node.rightChild.depth != (node.depth+1)) fixDepth(node.rightChild)
    }
    
    
}
