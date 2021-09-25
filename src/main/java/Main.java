import lists.BicycleArrayList;

public class Main {
    public static void main(String[] args) {

        BicycleArrayList<Integer> bicycleArrayList = new BicycleArrayList<>();

        for (int i = 1; i <= 11; i++) {
            bicycleArrayList.add(i);
        }

        bicycleArrayList.remove(5);

        for (Integer integer : bicycleArrayList) {
            System.out.println(integer);
        }
    }
}
