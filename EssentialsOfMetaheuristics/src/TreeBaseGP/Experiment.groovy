package TreeBaseGP

class Experiment {
    static main(args) {
        def root = new Node(arity: 1, depth:0, value:"+")
        def rootLeft = root.setLeftChild()
        root.setRightChild()
        rootLeft.setLeftChild()
        rootLeft.setRightChild()
        
        println rootLeft.leftChild.root()
        println root.toList()
        println root.toList()
        
        List abc = [1]
        println abc.size()
        println abc.remove(0)
        Integer z = 0
        
        println z.class.toString()
    }
}
