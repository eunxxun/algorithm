package basic;

import java.util.LinkedList;

class HashTable {
    class Node{
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
        String value() {
            return value;
        }

        void value(String value) {
            this.value = value;
        }
    }

    LinkedList<Node>[] data;

    HashTable(int size) {
        this.data = new LinkedList[size];
    }

    int getHashCode(String key) {
        int hashcode = 0;
        for (char c : key.toCharArray()) {
            hashcode += c; //askii 값 더하기
        }
        return hashcode;
    }

    //배열방에 인덱스로 변환해주는 함수
    int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }

    //배열방에 노드가 여러개 있으면 검색키를 가지고 해당 노드를 찾아오는 함수
    Node searchKey(LinkedList<Node> list, String key) {
        if(list == null) return null;
        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    void put(String key, String value) {
        int hashcode = getHashCode(key); //해시코드를 받아옴
        int index = convertToIndex(hashcode); //해시코드로 저장할 배열방 번호를 받아옴
        System.out.println(key + ", hashCode(" + hashcode + "), index(" + index + ")");
        LinkedList<Node> list = data[index];
        if (list == null) {
            list = new LinkedList<>();
            data[index] = list;
        }
        Node node = searchKey(list, key); //이미 있는지 확인
        if (node == null) {
            list.addLast(new Node(key, value));
        } else {
            node.value(value);//값 대체
        }
    }

    String get(String key) {
        int hashcode = getHashCode(key); //해시코드를 받아옴
        int index = convertToIndex(hashcode); //해시코드로 저장할 배열방 번호를 받아옴
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null ? "Not found" : node.value();
    }
}

public class HashTableTest {

    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("sung" , "she is pretty");
        h.put("jin" , "she is a model");
        h.put("hee" , "she is an angel");
        h.put("min" , "she is cute");
        h.put("sung" , "change!");
        System.out.println(h.get("sung"));
        System.out.println(h.get("jin"));
        System. out.println(h.get ("hee"));
        System. out.println(h.get("min"));
        System. out.println(h.get("aa"));
    }
}
