# **BIS2151E** - Programming in Java - Prof. Dr. Burkard
## **Testat No. 2 Theory** - Jansen/Gabriel

---

### **Task 1:**  
If you can read this, Task 1 was submitted.

---

### **Task 2:**

#### Math:
1. `pow(double a, double b)` : The static `pow()` method of the Math class
       raises a to the power of b and returns a double as result.
       --> a multiplied b times with itself.

2.  the method is names `abs()` and can be used by calling `Math.abs()`
3.  public static final double	PI	3.141592653589793  *"The double value that is closer than any other to pi, the ratio of the circumference of a circle to its diameter."*

#### String:
4. Splits this string around matches of the given regular expression.
5. `public String toLowerCase()` can be used to lowercase all letters of 
        a string.
        just like `split()`, this is an instance method and needs a String 
        to be called.

#### BigInteger:
6. `public boolean isProbablePrime(int certainty)` can be used for that.
    --> "Returns true if this *BigInteger* is probably prime, false if it's 
        definitely composite. If certainty is ≤ 0, true is returned."
        
#### Thread:
7. `public static void sleep(long millis)`
                  *throws InterruptedException*
       
        can be used to to let a programm sleep for a certain number of 
        milliseconds. Can be used on different, instantiated Threads or the
        main Thread of course.

#### General Java research:
8. Every Java class (except the Object class itself) inherits from the 
       *Object* class.