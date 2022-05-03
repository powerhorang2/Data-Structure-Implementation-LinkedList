public class LinkedList {
    // 첫번째 노드를 가리키는 필드
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        // 데이터가 저장될 필드
        private Object data;
        // 다음 노드를 가리키는 필드
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }
        // 노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
        public String toString(){
            return String.valueOf(this.data);
        }
    }

    public void addFirst(Object input) {
        // 노드를 생성합니다.
        Node newNode = new Node(input);
        // 새로운 노드의 다음 노드로 헤드를 지정합니다.
        newNode.next = head;
        // 헤드로 새로운 노드를 지정합니다.
        head = newNode;
        size++;
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        // 노드를 생성합니다.
        Node newNode = new Node(input);
        // 리스트의 노드가 없다면 첫번째 노드를 추가하는 메소드를 사용합니다.
        if (size == 0) {
            addFirst(input);
        } else {
            // 마지막 노드의 다음 노드로 생성한 노드를 지정합니다.
            tail.next = newNode;
            // 마지막 노드를 갱신합니다.
            tail = newNode;
            // 엘리먼트의 개수를 1 증가 시킵니다.
            size++;
        }
    }

    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public void add(int k, Object input) {
        // 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst 를 사용합니다.
        if (k == 0) {
            addFirst(input);
        } else {
            // k 번째 이전의 노드를 temp1 로 지정
            Node temp1 = node(k-1);
            // k 번째 노드를 temp2 로 지정
            Node temp2 = temp1.next;
            // 새로운 노드를 생성합니다.
            Node newNode = new Node(input);
            // temp1 의 다음 노드로 새로운 노드를 지정합니다.
            temp1.next = newNode;
            // 새로운 노드의 다음 노드로 temp2 를 지정합니다.
            newNode.next = temp2;
            size++;
            // 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail 로 지정합니다.
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }


    @Override
    public String toString() {
        // 노드가 없다면 []를 리턴합니다.
        if(head == null) {
            return "[]";
        }

        // 탐색을 시작합니다.
        Node temp = head;
        String str = "[";
        // 다음 노드가 없을 때까지 반복문을 실행합니다.
        // 마지막 노드는 다음 노드가 없기 때문에 아래의 구문에서 마지막 노드는 제외됩니다.
        while (temp.next != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }

        // 마지막 노드를 출력 결과에 포함시킵니다.
        str += temp.data;
        return str + "]";
    }

    public Object removeFirst() {
        // 첫번째 노드를 temp 로 지정하고 head 의 값을 두번째 노드로 변경합니다.
        Node temp = head;
        head = temp.next;
        // 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다.
        Object returnData = temp.data;
        temp = null;
        size--;
        return returnData;
    }

    public Object remove(int k) {
        if (k == 0) {
            return removeFirst();
        }
        // k-1번째 노드를 temp 의 값으로 지정합니다.
        Node temp = node(k - 1);
        // 삭제 노드를 todoDeleted 에 기록해 둡니다.
        // 삭제 노드를 지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결할 수 없습니다.
        Node tobeDeleted = temp.next;
        // 삭제 앞 노드의 다음 노드로 삭제 뒤 노드를 지정합니다.
        temp.next = temp.next.next;
        // 삭제된 데이터를 리턴하기 위해서 returnData 에 데이터를 저장합니다.
        Object returnData = tobeDeleted.data;
        if (tobeDeleted == tail) {
            tail = temp;
        }

        // cur.next 를 삭제합니다.
        tobeDeleted = null;
        size--;

        return returnData;
    }

    public int size() {
        return size;
    }
}
