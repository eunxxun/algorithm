package basic;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CompTest {
    public static void main(String[] args) {
        String[] arr = {"92345","43","90"};

        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()){
                    return s2.compareTo(s1);
                }

                String sum = s1 + s2;
                String reverse = s2 + s1;

                return reverse.compareTo(sum);
            }
        });

        for (String a : arr) {
            System.out.println(a);
        }
    }
}
