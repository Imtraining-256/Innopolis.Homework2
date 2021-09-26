import lists.BicycleArrayList;
import lists.BicycleLinkedList;

public class Main {
    public static void main(String[] args) {

        BicycleArrayList<Integer> bicycleArrayList = new BicycleArrayList<>();
        BicycleLinkedList<Integer> bicycleLinkedList = new BicycleLinkedList<>();
        for (int i = 0; i <= 11; i++) {
            bicycleArrayList.add(i);
            bicycleLinkedList.add(i);
        }

        bicycleArrayList.remove(5);
        bicycleLinkedList.remove(5);

        for (Integer integer : bicycleLinkedList) {
            System.out.println(integer);
        }

        for (Integer integer : bicycleArrayList) {
            System.out.println(integer);
        }
    }
}
