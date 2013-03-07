package TreeBaseGP

class Node {

    Node parent, leftChild, rightChild
    Integer depth, arity
    def value
    static ArrayList<Node> listOfNodes = new ArrayList<Node>()
    static Map variables
    
    def setLeftChild() {
       this.leftChild = new Node(depth: this.depth + 1, parent: this) 
    }
    
    def setRightChild() {
        this.rightChild = new Node(depth: this.depth + 1, parent: this)
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
    
    private evaluate() {
        switch(value) {
            case "+": evaluate(leftChild) + evaluate(rightChild)
            case "-": evaluate(leftChild) - evaluate(rightChild)
            case "*": evaluate(leftChild) * evaluate(rightChild)
            case "/": evaluate(leftChild) / evaluate(rightChild)
            case "sin": Math.sin(evaluate(leftChild))
            case "cos": Math.cos(evaluate(leftChild))
            case "tan": Math.tan(evaluate(leftChild))
            case "log": Math.sin(evaluate(leftChild))
            case "abs": Math.abs(evaluate(leftChild))
            case "exp": Math.exp(evaluate(leftChild))
            default: if(value.class.toString() == "class java.lang.String"){
                         variables.get(value)
                     }
                     else{
                         value
                     }
        }
    }
    
    
    
}
