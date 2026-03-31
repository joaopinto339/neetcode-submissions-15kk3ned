/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> createdNodes = new HashMap<>();
        Node init = new Node(node.val);
        createdNodes.put(node.val, init);


        Queue<Node[]> q = new LinkedList<>();
        q.offer(new Node[]{node, init});

        while(!q.isEmpty()){
            Node[] pair = q.poll();
            Node oldNode = pair[0];
            Node newNode = pair[1];
            for(Node oldNeighbor : oldNode.neighbors){
                Node newNeighbor = null;
                if(!createdNodes.containsKey(oldNeighbor.val)){
                    newNeighbor = new Node(oldNeighbor.val);
                    createdNodes.put(newNeighbor.val, newNeighbor);
                    q.offer(new Node[]{oldNeighbor, newNeighbor});
                }
                else{
                    newNeighbor = createdNodes.get(oldNeighbor.val);
                }
                newNode.neighbors.add(newNeighbor);
            }
        }
        return init;
    }



}