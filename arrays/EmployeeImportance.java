/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
// https://leetcode.com/problems/employee-importance
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> imp = new HashMap<>();
        Map<Integer, Employee> empMap = new HashMap<>();
        for (Employee e: employees) empMap.put(e.id, e);
        for (Employee e: employees) fill(e, imp, empMap);
        return imp.get(id);
    }

    int fill(Employee e, Map<Integer, Integer> imp, Map<Integer, Employee> empMap) {
        int total = e.importance;
        if (e.subordinates != null) {
            for (int emp: e.subordinates) {
                total += fill(empMap.get(emp), imp, empMap);
            }
        }

        imp.put(e.id, total);
        return total;
    }
}