package com.adminsys.code.员工的重要性;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

 class Solution {
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        return dfs(id);
    }

    private int dfs(int id) {
        Employee employee = map.get(id);
        int ans = employee.importance;
        for (Integer e : employee.subordinates) {
            ans += dfs(e);
        }
        return ans;
    }
}