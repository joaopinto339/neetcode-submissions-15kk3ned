class Solution {
    Map<Integer, List<Integer>> preMap;
    Set<Integer> visitedCourse;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visitedCourse = new HashSet<>();
        preMap = new HashMap<>();
        
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }
        for(int[] prereq : prerequisites){
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for(int c = 0; c < numCourses; c++){
            if(!dfs(c)){
                return false;
            }
        }
        return true;

    }

    private boolean dfs(int c){
        if(visitedCourse.contains(c)) return false;

        if(preMap.get(c).isEmpty()) return true;

        visitedCourse.add(c);
        for(int pre : preMap.get(c)){
            if(!dfs(pre)) return false;
        }
        visitedCourse.remove(c);
        preMap.put(c, new ArrayList<>());
        return true;
    }

}
