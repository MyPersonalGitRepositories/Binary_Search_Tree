import exceptions.NullPointerException;
import trees.ListTree;

public class Main {

    public static void main(String[] args) {

        System.out.println("LINKED TREE");
        ListTree<Integer> lt = new ListTree<>(30);

        try {
            lt.add(1);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            lt.add(0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            lt.add(6);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            lt.add(5);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            lt.add(3);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            lt.add(2);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            lt.add(32);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            lt.add(29);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            lt.add(4);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            lt.add(31);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            lt.add(null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(lt.isEmpty());
        System.out.println();

        System.out.println(lt.toString());
        System.out.println();


        try {
            System.out.println(lt.contains(4));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(lt.contains(null));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }



        try {
            lt.removeValue(4);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println();

        System.out.println(lt.toString());
        System.out.println();

        try {
            System.out.println(lt.contains(4));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}
