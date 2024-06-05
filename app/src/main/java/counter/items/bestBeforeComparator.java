package counter.items;

import com.google.common.collect.Comparators;

import java.time.LocalDate;
import java.util.Comparator;

public class bestBeforeComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple a1, Apple a2) {
        return a1.bestBefore().compareTo(a2.bestBefore());
    }
}
