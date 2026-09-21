package leetcode;

/** 148. Sort List **/
public class Sort_List_148 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(0, null);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(5, node3);
        ListNode node5 = new ListNode(-1, node4);
        ListNode head = node5;

        sortList1_1(head);

        ListNode start = head;
        while(start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//    public static ListNode sortList1(ListNode head) {
//        if(head == null || head.next == null) return head;
//
//        // 1. mid 노드 찾고 2단 분리
//        ListNode mid = findMiddleAndSplit(head);
//
//        // 2. 분할
//        ListNode left = sortList1(head);
//        ListNode right = sortList1(mid);
//
//        // 3. 병합
//        return merge(left, right);
//    }
//
//    /** slow-fast 방식으로 중앙 노드 찾아 반환 */
//    public static ListNode findMiddleAndSplit(ListNode head) {
//        ListNode slow = head, fast = head.next;
//        while(fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        ListNode mid = slow.next;
//        slow.next = null;
//        return mid;
//    }
//
//    public static ListNode merge(ListNode left, ListNode right) {
//        if(left == null) return right;
//        if(right == null) return left;
//
//        ListNode start = new ListNode(-1); // 첫 노드 left,right 중 지정하지 않고 dummy로 두기 (불필요 코드 없애도록)
//        ListNode tail = start;
//
//        while(left != null && right != null) {
//            if(left.val > right.val) {
//                tail.next = right;
//                right = right.next;
//
//            }else {
//                tail.next = left;
//                left = left.next;
//            }
//            tail = tail.next;
//        }
//
//        tail.next = (left == null) ? right : left;
//
//        return start.next;
//    }

    public static ListNode sortList1_1(ListNode head) {
        if(head == null || head.next == null) return head; // 노드가 없거나 하나라면 자신 반환

        // 1) half split and get middle node
        ListNode middle = findMiddleAndSplit1_1(head);

        // 2) middle 왼,오른 리스트 반복 분할
        ListNode left = sortList1_1(head);
        ListNode right = sortList1_1(middle);

        // 3) 병합 정렬 결과 반환
        return merge1_1(left, right);
    }

    public static ListNode findMiddleAndSplit1_1(ListNode head) {
        // slow-fast 중앙값 찾기
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // mid 찾기
        ListNode mid = slow.next;
        slow.next = null; // 연결 끊어주기
        return mid;
    }

    public static ListNode merge1_1(ListNode left, ListNode right) {
        if(left == null) return right;
        if(right == null) return left;

        ListNode start = new ListNode(-1);
        ListNode tail = start;

        while(left != null && right != null) {
            if(left.val < right.val) {
                tail.next = left;
                left = left.next;
            }else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        // 남은거 이어붙이기
        tail.next = (left != null) ? left : right;

        return start.next;
    }

}
