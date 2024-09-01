import java.util.ArrayList;
import java.util.List;

/*
given a set of random numbers. Write a code to shift all the zeros to the left.
no change in the order of non-zero numbers other than shifting them.
Do it in-place.
 */
public class setAllZerosToLeft {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(0);
        nums.add(8);
        nums.add(0);


        System.out.println("Given list: " + nums + " Size: " + nums.size());


        boolean first = true;

        for (int i=0; i<nums.size(); i++) {
            if (nums.get(i) == 0) {
                for (int j=i; j>0; j--) {

                    nums.remove(j);
                    nums.add(j, nums.get(j-1));
                }
                if (first) {
                    nums.remove(0);
                    nums.add(0, 0);
                    first = false;
                }
            }
        }


        System.out.println("Reord list: " + nums + " Size: " + nums.size());
    }

}
