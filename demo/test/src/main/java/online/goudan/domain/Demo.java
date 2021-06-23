package online.goudan.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘成龙
 * @date 2021/6/17 17:51
 * @desc Demo
 */
public class Demo {
    public static void main(String[] args) throws JsonProcessingException {
        Node rootNode = new Node(1, null, "a");
        Node node1 = new Node(2, 1, "b");
        Node node2 = new Node(3, 2, "b");
        Node node3 = new Node(4, 3, "b");
        Node node4 = new Node(5, 3, "b");
        Node node5 = new Node(6, 5, "b");
        Node node6 = new Node(7, 1, "b");
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);
        nodeList.add(node5);
        nodeList.add(node6);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(rootNode));
        rootNode.findChild(nodeList);
        System.out.println(objectMapper.writeValueAsString(rootNode));
    }

    public static class Node {
        private Integer id;
        private Integer parentId;
        private String val;
        private List<Node> childList = new ArrayList<>();

        public Node(Integer id, Integer parentId, String val) {
            this.id = id;
            this.parentId = parentId;
            this.val = val;
        }

        public List<Node> getChildList() {
            return childList;
        }

        public void setChildList(List<Node> childList) {
            this.childList = childList;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", parentId=" + parentId +
                    ", val='" + val + '\'' +
                    ", childList=" + childList +
                    '}';
        }

        public void findChild(List<Node> list) {
            for (Node node : list) {
                if (id.equals(node.getParentId())) {
                    node.findChild(list);
                    childList.add(node);
                }
            }
        }
    }
}
