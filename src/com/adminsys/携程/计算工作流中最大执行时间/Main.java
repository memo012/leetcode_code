package com.adminsys.携程.计算工作流中最大执行时间;

/**
 * @author Qiang
 * @version 1.0
 * @description TODO
 * @date 2020/8/15 下午7:29
 **/

import java.util.*;
import java.util.stream.Collectors;

class WorkflowNode {
    String nodeId;
    int timeoutMillis;
    List<WorkflowNode> nextNodes;
    boolean initialised;

    public static WorkflowNode load(String value) {
        // Create head node;
        Map<String, WorkflowNode> map = new HashMap<>();
        WorkflowNode head = new WorkflowNode("HEAD", 0, null);
        map.put(head.nodeId, head);

        for (String nodeValue : value.split("\\|")) {
            String[] properties = nodeValue.split("\\`");
            WorkflowNode node = map.get(properties[0]);

            node.timeoutMillis = Integer.parseInt(properties[1]);
            node.initialised = true;

            // Check next nodes
            if (properties[2].equals("END")) {
                continue;
            }
            node.nextNodes = Arrays.stream(properties[2].split(","))
                    .map(p -> new WorkflowNode(p, 0, null))
                    .collect(Collectors.toList());
            node.nextNodes.forEach(p -> map.put(p.nodeId, p));

            map.put(node.nodeId, node);
        }

        return head;
    }

    public WorkflowNode(String nodeId, int timeoutMillis, List<WorkflowNode> nextNodes) {
        this.nodeId = nodeId;
        this.timeoutMillis = timeoutMillis;
        this.nextNodes = nextNodes;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            WorkflowNode node = WorkflowNode.load(cin.next());

            Queue<WorkflowNode> queue = new LinkedList<>();
            queue.add(node);
            int sum = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                WorkflowNode child = queue.poll();
                int time = child.timeoutMillis;
                sum = Math.max(sum, time);
                List<WorkflowNode> ch = child.nextNodes;
                if (ch == null) continue;
                for (int i = 0; i < ch.size(); i++) {
                    WorkflowNode wfn = ch.get(i);
                    wfn.timeoutMillis += time;
                    queue.add(wfn);
                }
            }
            System.out.println(sum);
        }
    }
}
