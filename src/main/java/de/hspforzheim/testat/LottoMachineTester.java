
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hspforzheim.testat;

/**
 *
 * @author Lukas Gabriel
 */
public class LottoMachineTester {

    public static void main(String[] args) {
        // Instantiate LottoMachine
        LottoMachine myLotto = new LottoMachine();

        // Optional: Change the parameters
        myLotto.setParameters(6, 1, 49, true);

        // Call makeNewNumbers the first time...
        myLotto.makeNewNumbers();

        // ...and print the output
        System.out.println("Actual Lotto numbers are: " + myLotto);

        // Reset the numbers back to zeroes
        myLotto.resetNumbers();

        // Run second step of LottoMachineTester
        testAgain(myLotto);
    }

    private static void testAgain(LottoMachine lottoMachine) {
        // Make new numbers once more and reset them again

        lottoMachine.makeNewNumbers();

        System.out.println("Actual Lotto numbers are: " + lottoMachine);

        lottoMachine.resetNumbers();

    }
}
