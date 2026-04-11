class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visit = new HashSet<>();
    Set<Integer> cycle = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int[] prereq : prerequisites){
            map.computeIfAbsent(prereq[0], k -> new ArrayList<>()).add(prereq[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!visit.contains(i) && !dfs(i)){
                return new int[]{};
            }
        }
        int[] order = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            order[i] = res.get(i);
        }
        return order;
    }

    private boolean dfs(int course){
        if(cycle.contains(course)){
            return false;
        }
        if(visit.contains(course)){
            return true;
        }
        cycle.add(course);
        for(int c : map.getOrDefault(course, new ArrayList<>())){
            if(!dfs(c)){
                return false;
            }
        }
        cycle.remove(course);
        res.add(course);
        visit.add(course);
        return true;
    }
}
