package Learn;

public class ArrayTraversal {
    public static void main(String[] args) {
        int[] a = new int[4];
        for (int i = 0; i < a.length; i++) {
            a[i] = 100 * i;
        }

//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
        //foreach循环遍历
        for(int m:a){
            System.out.println(m);
        }
    }
}
