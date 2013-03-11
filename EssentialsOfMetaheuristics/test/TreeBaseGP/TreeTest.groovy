package TreeBaseGP
import spock.lang.Specification

class TreeTest extends Specification{
    def "should be able to create a tree class"() {
        Tree tree = new Tree()
        expect:
        tree.class.toString() == "class TreeBaseGP.Tree"
    }
    def "should be able to make a tree"() {
        Tree tree = new Tree(maxDepth:1)
        tree.makeTree([],[])
        expect:
        tree.size() == 3 | tree.size() == 2
    }
    def "should be able to make a tree with given arguments"() {
        List inner = ["+"]
        List outer = ["a", 6]
        Tree tree = new Tree(maxDepth:1)
        tree.makeTree(["+"],["a", 6])
        expect:
        tree.root.toString() == inner.get(0)
        tree.root.leftChild.toString() == "a" | tree.root.leftChild.value == 6
        tree.root.rightChild.toString() == "a" | tree.root.rightChild.value == 6
    }
    
}
