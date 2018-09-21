package com.chaoscoffee.util;

import org.junit.Test;

/**
 * @author chaoscoffee
 * @date 2018/9/20
 * @description
 */
public class SequenceTests {
    @Test
    public void test() {
        Sequence sequence = new Sequence(0, 0);
        for (int i = 0; i < 100; i++) {
            System.out.printf("第%d次- %s \n", i, sequence.nextId());
        }
    }
}
