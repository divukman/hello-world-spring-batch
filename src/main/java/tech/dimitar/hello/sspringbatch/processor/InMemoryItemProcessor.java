package tech.dimitar.hello.sspringbatch.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class InMemoryItemProcessor implements ItemProcessor<Integer, Integer> {

    @Override
    public Integer process(Integer integer) throws Exception {
        log.info("Item processor, processing item: " + integer);
        return integer + 10;
    }
}
