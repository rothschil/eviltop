package io.github.rothschil.jvm;

import org.openjdk.jol.info.ClassLayout;

public class JvmDyncAge {
    public static void main(String[] args) {
        byte[] bytes1 = new byte[4 * 1024 * 1024];
        bytes1 = new byte[4 * 1024 * 1024];
        bytes1 = new byte[4 * 1024 * 1024];

        bytes1 = null;
        byte[] bytes2 = new byte[128 * 1024];

        byte[] bytes3 = new byte[4 * 1024 * 1024];
        bytes3 = new byte[4 * 1024 * 1024];
        bytes3 = new byte[4 * 1024 * 1024];
        bytes3 = new byte[128 * 1024];

        bytes3 = null;

        byte[] bytes4 = new byte[4 * 1024 * 1024];
    }
}
