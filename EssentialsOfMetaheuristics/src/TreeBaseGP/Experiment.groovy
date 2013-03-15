package TreeBaseGP

class Experiment {
    static main(args) {
        Tree treeOne = new Tree(maxDepth: 2)
        Tree treeTwo = new Tree(maxDepth: 2)
        
        treeOne.root = new Node(arity: 2, depth:0, value:"+")
		treeOne.root.setLeftChild(new Node(arity:2, depth:1, value:"*"))
        treeOne.root.setRightChild(new Node(arity:2, depth:1, value:"/"))
		treeOne.root.leftChild.setLeftChild(new Node(arity:0, depth:2, value:1))
        treeOne.root.leftChild.setRightChild(new Node(arity:0, depth:2, value:2))
        treeOne.root.rightChild.setLeftChild(new Node(arity:0, depth:2, value:3))
        treeOne.root.rightChild.setRightChild(new Node(arity:0, depth:2, value:4))
        
        treeTwo.root = new Node(arity: 2, depth:0, value:"+")
        treeTwo.root.setLeftChild(new Node(arity:2, depth:1, value:"-"))
        treeTwo.root.setRightChild(new Node(arity:2, depth:1, value:"+"))
        treeTwo.root.leftChild.setLeftChild(new Node(arity:0, depth:2, value:5))
        treeTwo.root.leftChild.setRightChild(new Node(arity:0, depth:2, value:6))
        treeTwo.root.rightChild.setLeftChild(new Node(arity:0, depth:2, value:7))
        treeTwo.root.rightChild.setRightChild(new Node(arity:2, depth:2, value:8))
		
       /* println "TreeOne before CO: " + treeOne.toList()
        println "TreeTwo before CO: " + treeTwo.toList()
        treeOne.crossover(treeOne, treeTwo)		
		println "TreeOne after CO: " + treeOne.toList()
        println "TreeTwo after CO: " + treeTwo.toList()
		*/
		Tree largerTree = new Tree(maxDepth: 3)
		largerTree.root = new Node(arity: 2, depth:0, value:"+")
		largerTree.root.setLeftChild(new Node(arity:2, depth:1, value:"*"))
		largerTree.root.setRightChild(new Node(arity:2, depth:1, value:"/"))
		largerTree.root.leftChild.setLeftChild(new Node(arity:2, depth:2, value:"-"))
		largerTree.root.leftChild.setRightChild(new Node(arity:2, depth:2, value:"+"))
		largerTree.root.rightChild.setLeftChild(new Node(arity:2, depth:2, value:"*"))
		largerTree.root.rightChild.setRightChild(new Node(arity:2, depth:2, value:"/"))
		largerTree.root.leftChild.leftChild.setLeftChild(new Node(arity:0, depth:3, value:1))
		largerTree.root.leftChild.leftChild.setRightChild(new Node(arity:0, depth:3, value:2))
		largerTree.root.leftChild.rightChild.setLeftChild(new Node(arity:0, depth:3, value:3))
		largerTree.root.leftChild.rightChild.setRightChild(new Node(arity:0, depth:3, value:4))
		largerTree.root.rightChild.leftChild.setLeftChild(new Node(arity:0, depth:3, value:5))
		largerTree.root.rightChild.leftChild.setRightChild(new Node(arity:0, depth:3, value:6))
		largerTree.root.rightChild.rightChild.setLeftChild(new Node(arity:0, depth:3, value:7))
		largerTree.root.rightChild.rightChild.setRightChild(new Node(arity:0, depth:3, value:8))
		
		
		Tree largerTree2 = new Tree(maxDepth: 3)
		largerTree2.root = new Node(arity: 2, depth:0, value:"+")
		largerTree2.root.setLeftChild(new Node(arity:2, depth:1, value:"*"))
		largerTree2.root.setRightChild(new Node(arity:2, depth:1, value:"/"))
		largerTree2.root.leftChild.setLeftChild(new Node(arity:2, depth:2, value:"-"))
		largerTree2.root.leftChild.setRightChild(new Node(arity:2, depth:2, value:"+"))
		largerTree2.root.rightChild.setLeftChild(new Node(arity:2, depth:2, value:"*"))
		largerTree2.root.rightChild.setRightChild(new Node(arity:2, depth:2, value:"/"))
		largerTree2.root.leftChild.leftChild.setLeftChild(new Node(arity:0, depth:3, value:11))
		largerTree2.root.leftChild.leftChild.setRightChild(new Node(arity:0, depth:3, value:12))
		largerTree2.root.leftChild.rightChild.setLeftChild(new Node(arity:0, depth:3, value:13))
		largerTree2.root.leftChild.rightChild.setRightChild(new Node(arity:0, depth:3, value:14))
		largerTree2.root.rightChild.leftChild.setLeftChild(new Node(arity:0, depth:3, value:15))
		largerTree2.root.rightChild.leftChild.setRightChild(new Node(arity:0, depth:3, value:16))
		largerTree2.root.rightChild.rightChild.setLeftChild(new Node(arity:0, depth:3, value:17))
		largerTree2.root.rightChild.rightChild.setRightChild(new Node(arity:0, depth:3, value:18))
		println "\n"
		
		println "largerTree2 before CO: " + largerTree2.toList()
		println "largetree before CO: " + largerTree.toList()
		largerTree2.crossover(largerTree2, largerTree)
		println "TreeOne after CO: " + largerTree2.toList()
		println "largetree after CO: " + largerTree.toList()
		
		
    }
}
