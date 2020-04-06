# lotto_machine.py

from random import randint


class LottoMachine:
    # class var LOTTO_BALLS states the number of balls drawn (typically 6 out of 49)
    LOTTO_BALLS = 6

    # initialise the class and type-hint lotto_numbers as list; fill l_n with zeroes as default
    def __init__(self, lotto_numbers: list = []):
        self.lotto_numbers = lotto_numbers
        self.l_n = lotto_numbers  # for brevity
        self.reset_numbers()

    # this is optional - defining a formal representation of our class using __repr__()
    def __repr__(self):
        return f"LottoMachine(lotto_numbers={self.l_n})"

    # we create a custom informal representation of instances of the LottoMachine class
    def __str__(self):
        string = f"Actual Lotto numbers are: {self.num_string()}"
        return string

    # create a string representation of the current lotto_numbers; sorting would also be possible
    def num_string(self):
        actual_nums = [num for num in self.l_n if num != 0]
        num_string = str(actual_nums).strip('[]').replace(',', '')
        return num_string

    '''
    this is unnecessary in python - you can just call LottoMachine.lotto_numbers (or its alias l_n) 
    to get the same result much easier

    def get_lotto_numbers(self):
        return self.l_n
    '''
    # sets l_n equal to a list comprehension containing LOTTO_BALLS zeroes
    def reset_numbers(self):
        self.l_n = [0 for _ in range(self.LOTTO_BALLS)]

    def make_one_number(self):
        # generate random integer between 1..49 using random.randint()
        num = randint(1, 49)
        # enumerate l_n and loop through
        for i, j in enumerate(self.l_n):
            # look for first zero
            if j == 0:
                # call function again and return if num would be a duplicate
                if num in self.l_n:
                    self.make_one_number()
                    return
                # otherwise, set value in l_n at enumerate position i to random number num and return
                self.l_n[i] = num
                return

    # call make_one_number() as many times as specified in LOTTO_BALLS class var
    def make_new_numbers(self):
        # while 0 in self.lotto_numbers:  # <- equivalent alternative, but duplicate checking handled in make_one_number()
        for _ in range(self.LOTTO_BALLS):
            self.make_one_number()
        return


# test function that makes use of all methods of LottoMachine
def lotto_tester():
    # Instantiate lotto1 as instance of LottoMachine
    lotto1 = LottoMachine()
    lotto1.make_new_numbers()
    # thanks to the custom __str__, this returns the informational representation that we wanted
    print(lotto1)
    # reset l_n and run the test once more
    lotto1.reset_numbers()
    lotto1.make_new_numbers()
    print(lotto1)
    return

# declare lotto_tester() as main method of the program
if __name__ == "__main__":
    lotto_tester()

# that's it!
