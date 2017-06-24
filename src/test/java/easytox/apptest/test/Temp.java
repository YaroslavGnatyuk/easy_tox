package easytox.apptest.test;

import edu.emory.mathcs.backport.java.util.Arrays;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;


public class Temp {
    List<String> ex = Arrays.asList(new String[]{"hhh","aaa","sss","ggg"});
    @Test
    public void checkSorting(){
        System.out.println(ex);
        ex.sort(Comparator.naturalOrder());
        System.out.println(ex);
    }
}

class DescendComprator implements Comparable<String>{
    @Override
    public int compareTo(String o) {
        return this.compareTo(o);
    }
}