import java.util.*;

public class MultipleWordSearch {

    public static int[] counter;
    public static int[][] index;
    public static int[][] indexReverse;
    //public static void Print(ArrayList<String> al, String tag) {
        //System.out.println(tag + "-----------");
//         for( String a : al ) {
//         System.out.print(a);
//         }
//        System.out.println();
//    }
//    public static void Print(LinkedList<String> al, String tag) {
//        System.out.println(tag + "-----------");
//        for( String a : al ) {
//            System.out.print(a);
//        }
//        System.out.println();
//    }
    public static void main(String[] args) {
        ArrayList<String> search1 = new ArrayList<>();
        ST<String,Integer> st= new ST<String, Integer>();
        for (int i=0; i< args.length; i++){
            st.put(args[i], 1);
        }
        for (String s : st.keys()){
            search1.add(s);
        }
        String[]s=StdIn.readAllStrings();
        ArrayList<String> search2 = new ArrayList<>();
        for(int i = 0; i < s.length; i ++) {
            search2.add(s[i]);
        }
//        Print(search1, "search1");
//        Print(search2, "search2");
        counter = new int[search1.size()];


        for(int i = 0; i < search1.size(); i++) {
            for(int j = 0; j < search2.size(); j++) {
                if(search2.get(j).equals(search1.get(i))) {
                    counter[i]++;

                }
            }
        }

        for(int i = 0; i < counter.length; i++) {
            if(counter[i] == 0) {
                System.out.println("");
                return;
            }
        }

        LinkedList<String> temp = new LinkedList<>();
        Map<String, Integer> index = new HashMap<String, Integer>();
        int minValue = 65535;
        int start = 0;
        int end = 0;

        for(int i = 0; i < search2.size(); i++) {
            String str = search2.get(i);
            if(search1.contains(str)) {
                temp.addFirst(str);
                search1.remove(str);
                index.put(str, i);
            }else if(temp.contains(str)) {
                index.put(str, i);
//                Print(temp, "temp_pre");
                temp.remove(str);
//                Print(temp, "temp_after remove " + str);
                temp.addFirst(str);
//                Print(temp, "temp_after add " + str);
            }
            if(temp.size() == st.size()) {
                if(i - index.get(temp.getLast()) < minValue) {
                    minValue = i - index.get(temp.getLast());
                    start = index.get(temp.getLast());
                    end = i;
//                    System.out.println(start + "start end" + end);
                }

                    search1.add(temp.removeLast());

//                    Print(search1, "search1 here");

//                    Print(temp, "temp here");

            }
        }
        for(int i = start; i <= end; i++) {
            System.out.print(search2.get(i) + " ");
        }
    }

}
