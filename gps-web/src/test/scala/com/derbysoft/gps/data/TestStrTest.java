package com.derbysoft.gps.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TestStrTest {
    @Test
    public void testS() {
        TestStr testStrTest = new TestStr();
        String translate = testStrTest.translate("12321");
        assertEquals("3", translate);

        String translate2 = testStrTest.translate("31321");
        assertEquals("1", translate2);
        String translate1 = testStrTest.translate("");
    }

    public void testJson(){
        ObjectMapper objectMapper = new ObjectMapper();
    }
}