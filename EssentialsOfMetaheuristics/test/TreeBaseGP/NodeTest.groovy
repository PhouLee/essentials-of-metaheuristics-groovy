package TreeBaseGP
import spock.lang.Specification

class NodeTest extends Specification {
    def "should be able to create a Node with children"() {
        def root = new Node(arity: 1, depth:0, value:"+")
        def rootLeft = root.setLeftChild(6,0)
        def rootRight = root.setRightChild(6,0)
        expect:
        root != null
        rootLeft != null
        rootRight != null
        }
    def "should be able to find the root from a linked node"() {
        def root = new Node(arity: 1, depth:0, value:"+")
        def rootRight = root.setRightChild("*",0)
        def nodeAt = rootRight.setRightChild(6, 0)
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
        def rootLeft = root.setLeftChild(1,0)
        def rootRight = root.setRightChild(2,0)
        ArrayList<Node> list = root.makeList()
        ArrayList<Node> expected = new ArrayList<Node>()
        expected.add(rootLeft)
        expected.add(rootRight)
        expected.add(root)    
        expect:
        list != null
        list == expected
    }
    
}