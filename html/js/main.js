/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
class LottoMachine {
    
    lottoNumbers;
    
    constructor() {
        this.lottoNumbers = [0, 0, 0, 0, 0, 0];
    };
   
    get lottoNumbers() {
        return this.lottoNumbers;
    }

    resetNumbers() {
        this.lottoNumbers = [0, 0, 0, 0, 0, 0];
    }

    makeOneNumber() {
        var number = Math.floor((Math.random() * 49) + 1);
        var isPresent = false;

        for (var i = 0; i < this.lottoNumbers.length; i++) {
            if (number === this.lottoNumbers[i]) {
                console.log('yes');
                isPresent = true;
            }
        }
        
        if(isPresent) {
            this.makeOneNumber();
        } else {
            for (var j = 0; j < this.lottoNumbers.length; j++) {
                if (this.lottoNumbers[j] === 0) {
                    this.lottoNumbers[j] = number;
                    return;
                }
            }
        }

        
    }
    
    makeNewNumbers() {
        for( var i = 0; i < this.lottoNumbers.length; i++) {
            this.makeOneNumber();
        }
    }
}



const myLotto = new LottoMachine();
var button = document.getElementById("generate");

// Add an event listener to the button to recognize clicks and link a listener
// function to that call.
button.addEventListener("click", generate);


function generate() {
    myLotto.makeNewNumbers();
    displayNumbers();
    myLotto.resetNumbers();
}


function displayNumbers()
{
    for( var i = 0; i < myLotto.lottoNumbers.length; i++) {
        try{
            document.getElementById(i).innerHTML = myLotto.lottoNumbers[i];
        } catch(e) {
            
        }
    }
}