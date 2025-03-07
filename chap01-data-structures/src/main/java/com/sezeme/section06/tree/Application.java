package com.sezeme.section06.tree;

import java.util.TreeMap;

/* 편향(한쪽으로 치우친) 이진 트리
 * : 사실상 연결 리스트처럼 동작하여 최악의 경우 O(n)의 시간 복잡도
 * 균형 이진 트리
 * : 트리의 높이가 최소화 되어 모든 연산이 평균적으로 O(log n)의 시간 복잡도
 *
 * Java Collection Framework에서는 TreeSet, TreeMap 등에서 트리 구조를 활용하고 있는데
 * 내부적으로 레드-블랙 트리로 관리되고 있다.
 *
 * */
public class Application {

    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("first", "black");
        treeMap.put("second", "red");
    }

}
