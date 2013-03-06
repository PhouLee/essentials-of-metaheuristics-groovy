package TreeBaseGP

class Experiment {
    static main(args) {
        def root = new Node(arity: 1, depth:0, value:"+")
        def rootLeft = root.setLeftChild("*",0)
        root.setRightChild(2,0)
        rootLeft.setLeftChild(3,0)
        rootLeft.setRightChild(4,0)
        
        println rootLeft.leftChild.root()
        println root.toList()
        println root.toList()
        
        List abc = [1]
        println abc.size()
        println abc.remove(0)
        print "yolo^2/3".replaceAll("[]", "");
        
    }
}
