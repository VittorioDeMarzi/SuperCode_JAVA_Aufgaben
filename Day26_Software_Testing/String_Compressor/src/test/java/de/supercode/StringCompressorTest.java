package de.supercode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressorTest {

    @Test
    public void canCompressString() {
        String compressed = StringCompressor.compress("aaaaabbbbbccccc");
        assertEquals("a5b5c5", compressed);
    }

    @Test
    public void canCompressString2() {
        String compressed = StringCompressor.compress("abc");
        assertEquals("abc", compressed);
    }

    @Test
    public void canCompressString3() {
        String compressed = StringCompressor.compress("ab");
        assertEquals("ab", compressed);
    }

    @Test
    public void canCompressString4() {
        String compressed = StringCompressor.compress("aa");
        assertEquals("a2", compressed);
    }

    @Test
    public void canCompressString5() {
        String compressed = StringCompressor.compress("a");
        assertEquals("a", compressed);
    }
}
