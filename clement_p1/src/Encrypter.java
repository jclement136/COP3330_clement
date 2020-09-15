import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Encrypter {

    public String encrypt (String value){
        int array[] = stringToIntArray(value);
        int modifiedArray[] = modifyIntegers(array);
        int swappedArray[] = swapIntegers(modifiedArray);
        String restrungArray = arrayToString(swappedArray);
        return restrungArray;
    }

    public static int[] stringToIntArray(String value){
        int [] array = new int [4];
        array [0] = Integer.parseInt("" + value.charAt(0));
        array [1] = Integer.parseInt("" + value.charAt(1));
        array [2] = Integer.parseInt("" + value.charAt(2));
        array [3] = Integer.parseInt("" + value.charAt(3));
        return array;
    }

    public static int[] modifyIntegers(int [] array) {
        array [0] = modify(array [0]);
        array [1] = modify(array [1]);
        array [2] = modify(array [2]);
        array [3] = modify(array [3]);
        return array;
    }

    public static int modify(int originalInt) {
        int modifiedInt = (originalInt + 7) % 10;
        return modifiedInt;
    }

    public static int[] swapIntegers(int [] array) {
        int [] swappedArray = new int [4];

        int firstDigit = array[0];
        int secondDigit = array[1];
        int thirdDigit = array[2];
        int fourthDigit = array[3];

        swappedArray[0] = thirdDigit;
        swappedArray[1] = fourthDigit;
        swappedArray[2] = firstDigit;
        swappedArray[3] = secondDigit;

        return swappedArray;
    }

    public static String arrayToString(int [] swappedArray) {
        String togetherAgain = "" + swappedArray[0] + swappedArray[1] + swappedArray[2] + swappedArray[3];
        return togetherAgain;
    }

}

