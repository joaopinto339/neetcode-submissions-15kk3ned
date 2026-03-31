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
    public Map<Node, Node> createdNodes;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        createdNodes = new HashMap<>();
        createdNodes.put(node, new Node(node.val));
        bfs(node);
        
        return createdNodes.get(node);
    }

    private void bfs(Node node){
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node curr = q.poll();

            for(Node nei : curr.neighbors){
                if(!createdNodes.containsKey(nei)){
                    createdNodes.put(nei, new Node(nei.val));
                    q.offer(nei);
                }
                createdNodes.get(curr).neighbors.add(createdNodes.get(nei));
            }
        }
    }



}