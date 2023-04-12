// https://leetcode.com/problems/sort-the-students-by-their-kth-score/
class Solution {
    public int[][] sortTheStudents(int[][] scores, int k) {
        List<Student> list = new ArrayList<>();
        for (int[] score: scores) {
            list.add(new Student(score, k));
        }

        Collections.sort(list);

        for (int i = 0; i < scores.length; i++) {
            scores[i] = list.get(i).score;
        }

        return scores;
    }

    class Student implements Comparable<Student> {
        int[] score;
        int k;

        Student(int[] score, int k) {
            this.score = score;
            this.k = k;
        }

        public int compareTo(Student other) {
            return other.score[k] - this.score[k];
        }
    }
}