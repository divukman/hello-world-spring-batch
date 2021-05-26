package tech.dimitar.hello.sspringbatch.writer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.support.AbstractItemStreamItemWriter;

import java.util.List;

@Slf4j
public class ConsoleItemWriter extends AbstractItemStreamItemWriter<Integer> {
    @Override
    public void write(List<? extends Integer> list) throws Exception {
        log.info("Writing item: " + list);
        list.forEach(System.out::println);
        System.out.println(" *** writing chunk ***");
    }
}
