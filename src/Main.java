public class Main {

    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addLast(40);
        System.out.println("numbers = " + numbers);
        
        LinkedList.ListIterator li = numbers.listIterator();

        while (li.hasNext()) {
            if((int)li.next() == 30) li.remove();
        }

        System.out.println("numbers = " + numbers);

    }
}
