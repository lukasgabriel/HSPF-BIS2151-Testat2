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
const button = document.getElementById("generate");
// Add an event listener to the button to recognize clicks and link a listener
// function to that call.
button.addEventListener("click", generate);





function generate() {
    myLotto.makeNewNumbers();
    displayNumbers();
    myLotto.resetNumbers();
}


function displayNumbers() {
    var array = removeAnimationNumbers();
    var rand = (Math.random() * 20) + 20;
    console.log(array);
    for( let i = 0; i < myLotto.lottoNumbers.length; i++) {
            for( let j = 0; j < rand; j++) {
                   setTimeout(function() {
                       var doc = document.getElementById(i);
                       doc.innerHTML = array[Math.floor(Math.random() * 42)]; 
                   }, 100 * j);
            }
            document.getElementById(i).innerHTML = myLotto.lottoNumbers[i];
    }
}



function removeAnimationNumbers() {
    var lottoArray = myLotto.lottoNumbers;
    var animationNumbers = [...Array(50).keys()]
    animationNumbers.splice(0,1);
    for(var i = 0; i < lottoArray.length; i++) {
        for(var j = 0; j < animationNumbers.length; j++) {
         if( animationNumbers[j] === lottoArray[i]){
             animationNumbers.splice(j, 1);
         }
        }
    }
    
    return animationNumbers;
}

async function sleep(msec) {
    return new Promise(resolve => setTimeout(resolve, msec));
}