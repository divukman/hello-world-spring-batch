package tech.dimitar.hello.sspringbatch.reader;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.AbstractItemStreamItemReader;

import java.util.Arrays;
import java.util.List;

public class InMemoryReader extends AbstractItemStreamItemReader<Integer> {

    private List<Integer> lst = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
    private int index = 0;

    @Override
    public Integer read() throws UnexpectedInputException, ParseException, NonTransientResourceException {
        Integer nextItem = null;

        if (index < lst.size()) {
            nextItem = lst.get(index);
            index++;
        } else {
            index = 0;
        }

        return nextItem;
    }
}
