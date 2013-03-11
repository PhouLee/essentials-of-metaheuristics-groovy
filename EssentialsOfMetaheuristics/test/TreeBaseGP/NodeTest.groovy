package TreeBaseGP
import spock.lang.Specification

class NodeTest extends Specification {
    def "should be able to create a Node with children"() {
        def root = new Node(arity: 1, depth:0, value:"+")
        def rootLeft = root.setLeftChild()
        def rootRight = root.setRightChild()
        expect:
        root != null
        rootLeft != null
        rootRight != null
        }
    def "should be able to find the root from a linked node"() {
        def root = new Node(arity: 1, depth:0, value:"+")
        def rootRight = root.setRightChild()
        def nodeAt = rootRight.setRightChild()
        expect:
        nodeAt.root() == root
    }
    def "toString method for calling purposes"() {
        def root = new Node(arity: 1, depth:0, value:"+")
        expect:
        root.toString() == "+"
    }
    def "should be able to make an ArrayList out of the current node"() {
        def root = new Node(arity: 1, depth:0, value:"+")
        def rootLeft = root.setLeftChild()
        def rootRight = root.setRightChild()
        ArrayList<Node> list = root.makeList()
        ArrayList<Node> expected = new ArrayList<Node>()
        expected.add(rootLeft)
        expected.add(rootRight)
        expected.add(root)    
        expect:
        list != null
        list == expected
    }
    def "should be able to evaluate nodes"() {
        def root = new Node(arity: 1, depth:0, value:"+")
        root.leftChild = new Node(arity:0, depth:1, value:6)
        root.rightChild = new Node(arity:0, depth:1, value:4)
        expect:
        root.evaluate() == 10
    }
    def "should be able to evaluate nodes with variables"() {
        def root = new Node(arity: 1, depth:0, value:"+")
        root.leftChild = new Node(arity:0, depth:1, value:"w")
        root.rightChild = new Node(arity:0, depth:1, value:4)
        root.variables = ["w":6]
        expect:
        root.evaluate() == 10
    }
}