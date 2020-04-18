/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hspforzheim.testat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


/**
 *
 * @author Lukas Gabriel, Cedric Jansen
 */
public class LottoMachine {
    // Declare variables with default values
    private int lottoBalls = 6;
    private int lottoLowerBound = 1;
    private int lottoUpperBound = 49;
    private boolean sortLotto = false;

    // Declare the empty lottoNumbers array by calling resetNumbers()
    private Integer[] lottoNumbers = resetNumbers();

    // Resets lottoNumbers array to one filled with zeroes
    public Integer[] resetNumbers() {
        // Use ArrayList because it is mutable and we want to be able to change the
        // lottoNumbers length
        final ArrayList<Integer> lottoNumberList = new ArrayList<Integer>();
        // Fill with as many zeroes as specified in lottoBalls
        for (int i = 0; i < lottoBalls; i++) {
            lottoNumberList.add(0);
        }

        // Convert back to array and return
        lottoNumbers = lottoNumberList.toArray(new Integer[0]);

        return lottoNumbers;

    }

    // Creates one random number between 1...49 and puts it into the lottoNumbers
    // array. It searches for the next free place and saves the new number there
    // if the number is not already existing in one of the other 5 places.
    public void makeOneNumber() {
        boolean isPresent = false;
        final int newNumber = ThreadLocalRandom.current().nextInt(lottoLowerBound, lottoUpperBound + 1);

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

    // Call makeOneNumber on every spot in lottoNumbers array
    public void makeNewNumbers() {
        for (final int counter : lottoNumbers) {
            makeOneNumber();
        }
    }

    // Builds a String that contains all non-zero (filled) values in lottoNumbers
    // array
    public String numString() {

        // Creat mutable ArrayList actualNums to track filled values in lottoNumbers
        final ArrayList<Integer> actualNums = new ArrayList<>();

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
        final StringBuilder sb = new StringBuilder();

        for (final int num : actualNums) {
            sb.append(num);
            sb.append(" ");
        }

        final String numString = sb.toString();
        return numString;

    }

    // Used to change class parameters like the number of ball rolls, upper and
    // lower bound of possible values and changes if output is sorted
    public void setParameters(final int newLottoBalls, final int newLowerBound, final int newUpperBound, final boolean newSortLotto) {
        this.lottoBalls = newLottoBalls;
        this.lottoLowerBound = newLowerBound;
        this.lottoUpperBound = newUpperBound;
        this.sortLotto = newSortLotto;
        // Calculate range of possible values as difference between bounds
        final int valueRange = lottoUpperBound - lottoLowerBound + 1;
        if (lottoBalls > valueRange) {
            // As any value of lottoBalls greater than valueRange will create an infinite
            // loop due to the uniqueness condition of the values, change lottoBalls to
            // at least as high as lottoUpperBound
            System.out.println("Range of possible values cannot be lower than amount of ball rolls. Setting appropriate values...");
            this.lottoBalls = lottoUpperBound;
            
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
