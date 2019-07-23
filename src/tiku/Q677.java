package tiku;

import java.util.TreeMap;

/**
 * className Q677
 * description TODO
 *
 * @author ln
 * @version 1.0
 * @date 2019/6/30 13:45
 */
public class Q677 {

    class MapSum {

        private class Node {

            public int value;
            public TreeMap<Character, Node> next;

            public Node(int value) {
                this.value = value;
                next = new TreeMap<>();
            }

            public Node() {
                this(0);
            }
        }

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {

            root = new Node();
        }

        public void insert(String key, int val) {
            Node cur = root;
            for (int i = 0; i < key.length(); i++) {
                char c = key.charAt(i);
                if (cur.next.get(c) == null) {
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            cur.value = val;
        }

        public int sum(String prefix) {

            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.next.get(c) == null) {
                    return 0;
                }
                cur = cur.next.get(c);
            }
            return sum(cur);
        }

        /**
         * 递归求出以当前节点为根所有子树的value和
         *
         * @param node
         * @return
         */
        private int sum(Node node) {

            int res = node.value;
            for (char c : node.next.keySet()) {
                res += sum(node.next.get(c));
            }
            return res;
        }
    }
}
