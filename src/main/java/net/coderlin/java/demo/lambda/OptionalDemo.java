package net.coderlin.java.demo.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Title: OptionalDemo
 * Description:
 *
 * @author Lin Hui
 * Created on 2020-1-30 12:06
 */
public class OptionalDemo {
    @Test
    public void testCase() {
        Optional<String> optional = Optional.of("bam");
        if (optional.isPresent()) {
            Assert.assertEquals("bam", optional.get());
        }
        optional.ifPresent((s) -> System.out.println("Present"));
    }

    @Test
    public void testNullCase() {
        Optional<String> optional = Optional.ofNullable(null);
        if (optional.isPresent()) {
            Assert.assertEquals("bam", optional.get());
        }
        optional.ifPresent((s) -> System.out.println("Present"));
    }
}
