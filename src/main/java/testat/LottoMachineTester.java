/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testat;

/**
 *
 * @author Cedric Jansen
 */
public class LottoMachineTester {
    
    public static void main(String[] args) {
        LottoMachine myLotto = new LottoMachine();
        
        myLotto.makeNewNumbers();
        System.out.println("Actual Lotto numbers are: " + myLotto);
        myLotto.resetNumbers();
        
        
        
        for( int i = 0; i < 20; i++)
            makePrintReset(myLotto);
    }
    
    
    
    private static void makePrintReset( LottoMachine lottoMachine) {
        lottoMachine.makeNewNumbers();
        System.out.println("Actual Lotto numbers are: " + lottoMachine);
        lottoMachine.resetNumbers();
    }
}
