public class Main {

    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addFirst(5);
        numbers.add(3, 25);
        System.out.println("numbers = " + numbers);
        System.out.println(numbers.remove(1));
        System.out.println("numbers = " + numbers);

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("index : " + i + " = " + numbers.get(i));
        }
        
    }
}
