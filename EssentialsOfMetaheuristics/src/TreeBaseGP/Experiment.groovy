package TreeBaseGP

class Experiment {
    static main(args) {
        
        Tree treeOne = new Tree(crossoverDepth: 1, maxDepth: 2)
        Tree treeTwo = new Tree(crossoverDepth: 1, maxDepth: 2)
        
        treeOne.root = new Node(arity: 2, depth:0, value:"+")
        treeOne.root.leftChild = new Node(arity:2, depth:1, value:"+")
        treeOne.root.rightChild = new Node(arity:2, depth:1, value:"+")
        treeOne.root.leftChild.leftChild = new Node(arity:0, depth:2, value:1)
        treeOne.root.leftChild.rightChild = new Node(arity:0, depth:2, value:2)
        treeOne.root.rightChild.leftChild = new Node(arity:0, depth:2, value:3)
        treeOne.root.rightChild.rightChild = new Node(arity:0, depth:2, value:4)
        
        treeTwo.root = new Node(arity: 2, depth:0, value:"-")
        treeTwo.root.leftChild = new Node(arity:2, depth:1, value:"-")
        treeTwo.root.rightChild = new Node(arity:2, depth:1, value:"-")
        treeTwo.root.leftChild.leftChild = new Node(arity:0, depth:2, value:5)
        treeTwo.root.leftChild.rightChild = new Node(arity:0, depth:2, value:6)
        treeTwo.root.rightChild.leftChild = new Node(arity:0, depth:2, value:7)
        treeTwo.root.rightChild.rightChild = new Node(arity:0, depth:2, value:8)
        
        println treeOne.toList()
        println treeTwo.toList()
        println treeOne.crossover(treeOne, treeTwo)
        println treeOne.findANodeAt(treeOne.root, 2)
    }
}
