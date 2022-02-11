package io.github.rothschil.jvm;

/** S0 S1 空间为 1M
 *  Eden 空间为 8M
 * @author <a href="https://github.com/rothschil">Sam</a>
 * @date 2022/2/11 - 11:09
 * @since 1.0.0
 */
public class JvmSurviObj {

    public static void main(String[] args) {

        byte[] bytes1 = new byte[3 * 1024 * 1024];
        byte[] bytes2 = new byte[128 * 1024];
        bytes1 = null;
        byte[] bytes3 = new byte[5 * 1024 * 1024];
//        bytes3 = new byte[1 * 1024 * 1024];
    }
}
