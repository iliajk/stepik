package org.stepik.learn.AsciiCharSequence;

public class AsciiCharSequence implements CharSequence {
    byte[] sequence;
    AsciiCharSequence(byte[] bytes) {
        this.sequence = bytes;
    }
    @Override
    public int length() {
        return sequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char) sequence[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] result = new byte[end - start];
        System.arraycopy(sequence, start, result, 0, result.length);
        return new AsciiCharSequence(result);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < sequence.length; i++){
            str.append((char)sequence[i]);
        }
        return str.toString();
    }
}
