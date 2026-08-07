class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
       Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offer(student);
        }

        int unableToEat = 0;
        int sandwichIndex = 0;

        while (!queue.isEmpty() && sandwichIndex < sandwiches.length) {
            int frontStudent = queue.poll();
            if (frontStudent == sandwiches[sandwichIndex]) {
                sandwichIndex++;
                unableToEat = 0; 
            } else {
                queue.offer(frontStudent);
                unableToEat++;
                if (unableToEat == queue.size()) {
                    
                    break;
                }
            }
        }

        return queue.size();
    }
}