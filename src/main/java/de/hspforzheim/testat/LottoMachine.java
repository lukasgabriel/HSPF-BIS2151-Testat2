/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hspforzheim.testat;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Lukas Gabriel
 */
public class LottoMachine {
    // Declare variables with default values
    private static int lottoBalls = 6;
    private static int lottoLowerBound = 1;
    private static int lottoUpperBound = 49;
    private static boolean sortLotto = false;

    // Declare the empty lottoNumbers array by calling resetNumbers()
    private Integer[] lottoNumbers = resetNumbers();

    // Resets lottoNumbers array to one filled with zeroes
    public Integer[] resetNumbers() {
        // Use ArrayList because it is mutable and we want to be able to change the
        // lottoNumbers length
        ArrayList<Integer> lottoNumberList = new ArrayList<Integer>();
        // Fill with as many zeroes as specified in lottoBalls
        for (int i = 0; i < lottoBalls; i++) {
            lottoNumberList.add(0);
        }

        // Convert back to array and return
        lottoNumbers = lottoNumberList.toArray(new Integer[0]);

        return lottoNumbers;

    }

    // Looks for one empty (filled with zero) spot in lottoNums and fills it with
    // random integer
    public void makeOneNumber() {
        // Generate random integer in range between specified lower and upper bound
        int randNum = ThreadLocalRandom.current().nextInt(lottoLowerBound, lottoUpperBound + 1);

        // Loop through lottoNumbers array
        for (int i = 0; i < lottoNumbers.length; i++) {

            // Look for first zero
            if (lottoNumbers[i] == 0) {

                // Check if number is already present in array
                if (Arrays.asList(lottoNumbers).contains(randNum)) {
                    // If yes, call method again
                    makeOneNumber();
                } else {
                    // If unique, fill spot of zero with randNum and return
                    lottoNumbers[i] = randNum;
                    return;
                }
            }
        }
    }

    // Call makeOneNumber on every spot in lottoNumbers array
    public void makeNewNumbers() {
        for (int counter : lottoNumbers) {
            makeOneNumber();
        }
    }

    // Builds a String that contains all non-zero (filled) values in lottoNumbers
    // array
    public String numString() {

        // Creat mutable ArrayList actualNums to track filled values in lottoNumbers
        ArrayList<Integer> actualNums = new ArrayList<>();

        // Adds all filled values to actualNums
        for (int i = 0; i < lottoNumbers.length; i++) {
            if (lottoNumbers[i] != 0) {
                actualNums.add(lottoNumbers[i]);
            }
        }

        // If sortLotto parameter is true, sort the actualNums (like in the real world)
        if (sortLotto == true) {
            Collections.sort(actualNums);
        }

        // Build string of actualNums contents and return
        StringBuilder sb = new StringBuilder();

        for (int num : actualNums) {
            sb.append(num);
            sb.append(" ");
        }

        String numString = sb.toString();
        return numString;

    }

    // Used to change class parameters like the number of ball rolls, upper and
    // lower bound of possible values and changes if output is sorted
    public void setParameters(int newLottoBalls, int newLowerBound, int newUpperBound, boolean newSortLotto) {
        lottoBalls = newLottoBalls;
        lottoLowerBound = newLowerBound;
        lottoUpperBound = newUpperBound;
        sortLotto = newSortLotto;
        // Calculate range of possible values as difference between bounds
        int valueRange = lottoUpperBound - lottoLowerBound + 1;
        if (lottoBalls > valueRange) {
            // As any value of lottoBalls greater than valueRange will create an infinite
            // loop due to the uniqueness condition of the values, throw an
            // IllegalArgumentEception if such a combination of parameters were to be
            // specified
            throw new IllegalArgumentException("Range of possible values cannot be lower than amount of ball rolls.");
        }
        // Call resetNumbers() once more to accomodate change of lottoNumbers array
        // length after class instantiation
        resetNumbers();
    }

    // Return lottoNumbers array to caller of method
    public Integer[] getLottoNumbers() {
        return lottoNumbers;
    }

    // Override string representation of class to match formatting required in task
    // description
    @Override
    public String toString() {
        return numString();
    }

}
