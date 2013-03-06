package TreeBaseGP

class Node {

    Node parent, leftChild, rightChild
    Integer depth, arity
    def value
    static ArrayList<Node> listOfNodes = new ArrayList<Node>()
    
    def setLeftChild(value, arity) {
       this.leftChild = new Node(value: value, arity: arity, depth: this.depth + 1, parent: this) 
    }
    
    def setRightChild(value, arity) {
        this.rightChild = new Node(value: value, arity: arity, depth: this.depth + 1, parent: this)
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
    
}
