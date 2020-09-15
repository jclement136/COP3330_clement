import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Application {

    @Test
    public void testEncrypt1234to0189() {
        Encrypter e = new Encrypter();
        assertEquals("0189", e.encrypt("1234"));
    }

    @Test
    public void testDecrypt0189to1234() {
        Decrypter e = new Decrypter();
        assertEquals("1234", e.decrypt("0189"));
    }

    /* ADDITIONAL ENCRYPTER TESTS

    public Encrypter e = new Encrypter();

    @Test
    public void testModify() {

        int[] array = e.stringToIntArray("1234");

        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
        assertEquals(4, array[3]);
    }

    @Test
    public void testModifyIntegers() {

        int[] array = e.stringToIntArray("1234");
        int[] modifiedArray = e.modifyIntegers(array);

        assertEquals(8, modifiedArray[0]);
        assertEquals(9, modifiedArray[1]);
        assertEquals(0, modifiedArray[2]);
        assertEquals(1, modifiedArray[3]);
    }

    @Test
    public void testSwap() {

        int[] array = e.stringToIntArray("1234");
        int[] modifiedArray = e.modifyIntegers(array);
        int[] swappedArray = e.swapIntegers(modifiedArray);

        assertEquals(0, swappedArray[0]);
        assertEquals(1, swappedArray[1]);
        assertEquals(8, swappedArray[2]);
        assertEquals(9, swappedArray[3]);
    }

    @Test
    public void testArrayToString() {

        int[] array = e.stringToIntArray("1234");
        int[] modifiedArray = e.modifyIntegers(array);
        int[] swappedArray = e.swapIntegers(modifiedArray);
        String togetherAgain = e.arrayToString(swappedArray);

        assertEquals("0189", togetherAgain);
    }

    END OF ADDITIONAL TESTS */
}