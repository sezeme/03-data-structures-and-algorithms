package com.sezeme.section02.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Java Collection Framework에는 ArrayList, LinkedList 등이 구현 되어 있다. */
/*
 * 배열 기반
 * - 인덱스를 이용해 O(1) 시간 복잡도로 빠르게 접근
 * - 연속된 메모리 공간을 사용하므로 캐시 히트율이 높아 성능이 좋음
 * - 처음 할당된 크기를 변경하기 어렵고, 크기를 늘리려면 새로운 배열을 만들어야 함
 * - 중간에 데이터를 추가하거나 삭제할 때 데이터 이동이 필요해 O(n) 시간이 걸림
 * 연결 리스트
 * - 동적으로 노드를 추가/삭제할 수 있어 메모리를 효율적으로 사용 가능
 * - 중간에 데이터를 추가하거나 삭제할 때 이동할 필요 없이 포인터만 변경하면 됨 (O(1) 또는 O(n) – 위치 찾기 필요)
 * - 원하는 데이터를 찾으려면 처음부터 순차적으로 탐색해야 하므로 O(n) 시간이 걸림
 * - 각 노드가 데이터 외에도 다음 노드를 가리키는 포인터를 저장해야 하므로 메모리 오버헤드가 발생함
 */
public class Application {
    public static void main(String[] args) {
        /* ArrayList */
        List<Integer> list = new ArrayList<>();

        // 요소 추가
        list.add(1);
        list.add(2);
        list.add(3);

        // 요소 조회
        System.out.println(list.get(1));

        // 요소 제거
        list.remove(2);
        System.out.println(list);

        // 리스트 크기
        System.out.println(list.size());

        /* LinkedList */
        List<Integer> list2 = new LinkedList<>();

        // 요소 추가
        list2.add(1);
        list2.add(2);
        list2.add(3);

        // 요소 조회
        System.out.println(list2.get(1));

        // 요소 제거
        list2.remove(2);
        System.out.println(list2);

        // 리스트 크기
        System.out.println(list2.size());
    }
}
