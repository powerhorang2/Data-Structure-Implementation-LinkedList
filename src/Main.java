public class Main {

    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addFirst(5);
        numbers.add(3, 25);
        System.out.println("numbers = " + numbers);
        System.out.println(numbers.removeFirst());
        System.out.println("numbers = " + numbers);
    }
}
