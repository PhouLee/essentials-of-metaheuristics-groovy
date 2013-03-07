package TreeBaseGP
import java.util.ArrayList;
import java.util.Random

//TODO:
//powers

class Tree {
    Random random = new Random()
    Node root
    Integer size, maxInteger = 11, maxDepth = random.nextInt(11);
    List innerNodes, terminalNodes
    List arityTwo = ["+", "-","/","*"]
    List operators = ["sin","cos","tan","log","exp","abs", "+", "-","/","*"]
    
    def makeTree(innerNodes, terminalNodes) {
        this.innerNodes = innerNodes
        this.terminalNodes = terminalNodes
        root = new Node(depth:0)
        this.setValue(root)
    }
    
    def setValue(Node node) {
        if(node.depth != maxDepth){
            //inner nodes, +, -, /, *, log, cos, sin, tan, exp, pow, abs, 
            if(!innerNodes.isEmpty()){
                node.value = innerNodes.remove(random.nextInt(innerNodes.size()))
            }
            //create random inner node
            else {
                node.value = operators.get(random.nextInt(innerNodes.size()))
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
    }
    
    def evaluate(variables) {
        root.variables = variables
        root.evaluate()
    }
    
    public ArrayList<Node> toList() {
        root.toList()
    }
    
    

}
