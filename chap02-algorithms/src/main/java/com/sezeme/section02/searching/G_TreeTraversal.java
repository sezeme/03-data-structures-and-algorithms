package com.sezeme.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class G_TreeTraversal {

    static int N;
    static Node root;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        String value;
        Node left, right;

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        root = new Node("A", null, null);


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            String lvalue = st.nextToken();
            String rvalue = st.nextToken();
            Node left = lvalue.equals(".") ? null : new Node(lvalue, null, null);
            Node right = rvalue.equals(".") ? null : new Node(rvalue, null, null);

            Node target = search(value);
            target.left = left;
            target.right = right;
        }

        preOrder();
        sb.append("\n");
        inOrder();
        sb.append("\n");
        postOrder();

        return sb.toString();
    }

    /* 전위 순회 */
    static void preOrder() {
        preOrderRec(root);
    }

    static private void preOrderRec(Node node) {
        if (node != null) {
            sb.append(node.value);
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    /* 중위 순회 */
    static public void inOrder() {
        inOrderRec(root);
    }

    static private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            sb.append(node.value);
            inOrderRec(node.right);
        }
    }

    /* 후위 순회 */
    static public void postOrder() {
        postOrderRec(root);
    }

    static private void postOrderRec(Node node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            sb.append(node.value);
        }
    }
    
    /* 검색 */
    static private Node search(String value) {
        return searchRec(root, value);
    }

    static private Node searchRec(Node node, String data) {
        if(node == null) return null;
        if(data.compareTo(node.value) == 0) return node;
        Node result = searchRec(node.left, data);
        return result == null ? searchRec(node.right, data) : result;
    }
}
