/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testat;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Cedric Jansen
 */
public class LottoMachine {

    private int[] lottoNumbers = {0,0,0,0,0,0};

    // Returns the array lottoNumbers to the caller of the method.
    public int[] getLottoNumbers() {
        return lottoNumbers;
    }

    // Sets all 6 numbers in the array lottoNumbers back to 0.
    public void resetNumbers() {
        for (int i = 0; i < lottoNumbers.length; i++) {
            lottoNumbers[i] = 0;
        }
    }

    // Creates one random number between 1...49 and puts it into the lottoNumbers
    // array. It searches for the next free place and saves the new number there
    // if the number is not already existing in one of the other 5 places.
    public void makeOneNumber() {
        boolean isPresent = false;
        int newNumber = ThreadLocalRandom.current().nextInt(1, 50);

        for (int i = 0; i < lottoNumbers.length; i++) {
            if (newNumber == lottoNumbers[i]) {
                isPresent = true;
            }
        }

        if (isPresent) {
            makeOneNumber();
        } else {
            for (int i = 0; i < lottoNumbers.length; i++) {
                if (lottoNumbers[i] == 0) {
                    lottoNumbers[i] = newNumber;
                    return;
                }
            }
        }
    }

    // Repeats calling makeOneNumber, until the whole array is filled with 6 different numbers from
    // 1 to 49.
    public void makeNewNumbers() {
        for (int placeHolder : lottoNumbers) {
            makeOneNumber();
        }
    }

    // Implementation of the ascending order given in the Testat 2 sheet
    // because I though that's the way how to implement toString and did not
    // continue reading.
    public String toStringOld() {
        String result = "";
        for (int i = 0; i < lottoNumbers.length; i++) {
            result += "lottoNumbers[" + i + "] is " + lottoNumbers[i];
            if (lottoNumbers[i] == 0) {
                result += " (not set)";
            }
            result += "\n";
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (int number : lottoNumbers) {
            result += number + " ";
        }
        return result;
    }
}
