public class Main {
    public static void main(String[] args) {

        CollectionArrayList<Integer> myList = new CollectionArrayList<Integer>(new Integer[]{4,54,6,7});
        for (int i = 0; i < 10; ++i) {
            myList.add(i);
        }
        myList.add(5,5);
        myList.remove(0);
        myList.set(9,5);
        System.out.println(myList.toString());

    }
}