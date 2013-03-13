package TreeBaseGP
import java.util.ArrayList;
import java.util.Random

//TODO:
//powers

class Tree {
    Random random = new Random()
    Node root
    Integer size = 0, maxInteger = 11, maxDepth = random.nextInt(11), crossoverDepth;
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
            //inner nodes, +, -, /, *, log, cos, sin, tan, exp, pow, abs, 
            if(!innerNodes.isEmpty()){
                node.value = innerNodes.remove(random.nextInt(innerNodes.size()))
            }
            //create random inner node
            else {
                node.value = operators.get(random.nextInt(operators.size()))
            }
            
            if(arityTwo.contains(node.value)) node.arity = 2
            else node.arity = 1
            
            setValue(node.setLeftChild())
            if(node.arity == 2) setValue(node.setRightChild())
        }
        else {
            //terminal nodes, constants or variables
            node.arity = 0
            if(!terminalNodes.isEmpty()){
               node.value = terminalNodes.remove(random.nextInt(terminalNodes.size()))
            }
            //create random terminal node
            else{
               node.value = random.nextInt(maxInteger)         
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
    
    def crossover(Tree treeOne, Tree treeTwo) {
        // never selects a terminal node
        crossoverDepth = random.nextInt(treeOne.maxDepth-1)
        Node treeOneNode = findANodeAt(treeOne.root, crossoverDepth)
        crossoverDepth = random.nextInt(treeTwo.maxDepth-1)
        Node treeTwoNode = findANodeAt(treeTwo.root, crossoverDepth)
        
        Node parentA = treeOneNode.parent
        Node parentB = treeTwoNode.parent
        
        parentA.changeChild(treeOneNode, treeTwoNode)
        parentB.changeChild(treeTwoNode, treeOneNode)
        treeOneNode.changeParent(parentB)
        treeTwoNode.changeParent(parentA)
        
        fixDepth(parentA)
        fixDepth(parentB)
    }
    
    def findANodeAt(Node node, depth){
        if(node.depth != depth){
            if(node.arity == 2 && random.nextInt(2) == 1){
                findANodeAt(node.rightChild, depth)
            }
            else findANodeAt(node.leftChild, depth)
        }
        else node
    }
    
    private def fixDepth(Node node){
        node.depth = node.parent.depth + 1
        if(node.leftChild != null && node.leftChild.depth != (node.depth+1)) fixDepth(node.leftChild)
        if(node.rightChild != null && node.rightChild.depth != (node.depth+1)) fixDepth(node.rightChild)
    }
    
    
}
