package TreeBaseGP
import java.util.Random

//TODO:
//powers

class Tree {
    Random random = new Random()
    Node root
    Integer size, maxDepth = random.nextInt(11);
    List innerNodes, terminalNodes
    List arityTwo = ["+", "-","/","*"]
    def makeTree(innerNodes, terminalNodes) {
        this.innerNodes = innerNodes
        this.terminalNodes = terminalNodes
        if(root == null) root = new Node(depth:0)
        this.setValue(root)
    }
    
    def setValue(Node node) {
        if(node.depth != maxDepth){
            //inner nodes, +, -, /, *, log, cos, sin, tan, exp, pow, abs, 
            if(!innerNodes.isEmpty()){
                node.value = innerNodes.remove(random.nextInt(innerNodes.size()))
                if(arityTwo.contains(node.value)) node.arity = 2
                else node.arity = 1
            }
            //create random inner node
            else {
                
            }
            
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
                
            }
        }
        
    }
    
    

}
