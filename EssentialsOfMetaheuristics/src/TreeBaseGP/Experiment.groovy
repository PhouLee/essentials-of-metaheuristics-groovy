package TreeBaseGP

class Experiment {
    static main(args) {
        
         Tree tree = new Tree(maxDepth:1)
        tree.makeTree(["+"],["a", 6])
         println tree.root
         List test = ["+"]
         println tree.root.value == "+"
    }
}
