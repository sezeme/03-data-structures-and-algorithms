package com.sezeme.section06.tree;

import java.util.ArrayList;
import java.util.List;

/* 이진 트리
 * 각 노드가 최대 두 개의 자식을 가지며 왼쪽 자식과 오른쪽 자식으로 구분 된다.
 *
 * 이진 탐색 트리
 * 이진 트리의 구조를 가지면서 추가로 왼쪽 서브트리의 모든 노드는 현재 노드 값 보다 작고,
 * 오른쪽 서브 트리의 모든 노드는 현재 노드 값보다 크다는 규칙(정렬 속성)을 만족한다.
 *
 * => 제한 된 자식의 수와 정렬 속성 덕분에 트리 순회, 탐색, 삽입, 삭제 등의 알고리즘을
 * 보다 효율적이고 단순하게 구현할 수 있다. */
public class BinarySearchTree<T extends Comparable<T>> {
    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T data) {
        root = insertRec(root, data);
    }
    /* 노드 삽입을 위한 재귀 메소드 */
    private Node<T> insertRec(Node<T> node, T data) {
        if(node == null) { return new Node<>(data); }
        //data가 현재 노드의 data보다 작으면 => 왼쪽 서브트리에 삽입
        if(data.compareTo(node.data) < 0) {
            node.left = insertRec(node.left, data);
        }
        //data가 현재 노드의 data보다 크면 => 오른쪽 서브트리에 삽입
        else if(data.compareTo(node.data) > 0) {
            node.right = insertRec(node.right, data);
        }
        //data가 동일하면 중복이므로 삽입 x
        return node;
    }

    /* 전위 순회 */
    public List<T> preOrder() {
        List<T> result = new ArrayList<>();
        preOrderRec(root, result);
        return result;
    }

    private void preOrderRec(Node<T> node, List<T> result) {
        if(node != null) {
            result.add(node.data);
            preOrderRec(node.left, result);
            preOrderRec(node.right, result);
        }
    }

    /* 중위 순회 */
    public List<T> inOrder() {
        List<T> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(Node<T> node, List<T> result) {
        if(node != null) {
            inOrderRec(node.left, result);
            result.add(node.data);
            inOrderRec(node.right, result);
        }
    }

    /* 후위 순회 */
    public List<T> postOrder() {
        List<T> result = new ArrayList<>();
        postOrderRec(root, result);
        return result;
    }

    private void postOrderRec(Node<T> node, List<T> result) {
        if(node != null) {
            postOrderRec(node.left, result);
            postOrderRec(node.right, result);
            result.add(node.data);
        }
    }

    /* 검색 */
    public boolean search(T data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node<T> node, T data) {
        if(node == null) return false;
        if(data.compareTo(node.data) == 0) return true;
        return (data.compareTo(node.data) < 0) ?
                searchRec(node.left, data) :
                searchRec(node.right, data);
    }

    /* 노드 삭제 */
    public void delete(T data) {
        root = deleteRec(root, data);
    }

    private Node<T> deleteRec(Node<T> node, T data) {
        if(node == null) return node;
        if(data.compareTo(node.data) < 0){
            node.left = deleteRec(node.left, data);
        } else if(data.compareTo(node.data) > 0) {
            node.right = deleteRec(node.right, data);
        } else {
            // 현재 노드가 삭제 대상인 경우

            // 자식이 한개 또는 없는 경우
            if(node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;
            // 두 자식이 있는 경우 : 오른쪽 서브트리의 최고 값을 찾아 오고 기존 위치에서는 삭제
            node.data = minValue(node.right);
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    private T minValue(Node<T> node) {
        T minVal = node.data;
        while(node.left != null) {
            node = node.left;
            minVal = node.data;
        }
        return minVal;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        /* 트리 구조
        *                 50
        *                /   \
        *              30     70
        *             /  \   /  \
        *            20  40 60  80
        * */

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("전위 순회 : " + bst.preOrder());
        System.out.println("중위 순회 : " + bst.inOrder());
        System.out.println("후위 순회 : " + bst.postOrder());

        // 검색
        System.out.println("40 검색 : " + bst.search(40));
        System.out.println("90 검색 : " + bst.search(90));

        // 삭제
        bst.delete(20);
        System.out.println("삭제 후 중위 순회 : " + bst.inOrder());
        bst.delete(50);
        System.out.println("삭제 후 중위 순회 : " + bst.inOrder());

    }


}
