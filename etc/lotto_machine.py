# lotto_machine.py

from random import randint


class LottoMachine:

    # class var balls states the number of balls drawn (typically 6 out of 49)
    # class vars lower_bound & upper_bound define range of possible ball rolls
    # class var sorting states if output should be sorted

    balls = 6
    lower_bound = 1
    upper_bound = 49
    sorting = True


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

    # create a string representation of the current lotto_numbers
    def num_string(self):
        actual_nums = [num for num in self.l_n if num != 0]

        # if sorting is enabled, sort actual_nums in-place
        if self.sorting:
            actual_nums.sort()

        num_string = str(actual_nums).strip('[]').replace(',', '')
        return num_string

    '''
    this getter is unnecessary in python - you can just call LottoMachine.lotto_numbers (or its alias l_n) 
    to get the same result much easier
    Equivalent to 'toString' override in Java

    def get_lotto_numbers(self):
        return self.l_n
    '''
    # sets l_n equal to a list comprehension containing LOTTO_BALLS zeroes
    def reset_numbers(self):
        # calculate range of possible values as difference between bounds
        value_range = self.upper_bound - self.lower_bound + 1
        # As any value of balls greater than value_range will create an infinite loop due
        # to the uniqueness condition of the values, change balls to at least as high as upper_bound
        if self.balls > value_range:
            print("Range of possible values cannot be lower than amount of ball rolls. Setting appropriate values...")
            self.balls = self.upper_bound

        self.l_n = [0 for _ in range(self.balls)]

    def make_one_number(self):

        # generate random integer between 1..49 using random.randint()
        num = randint(self.lower_bound, self.upper_bound)

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
        for _ in range(self.balls):
            self.make_one_number()

        return


# test function that makes use of all methods of LottoMachine
def lotto_tester():

    # Instantiate lotto1 as instance of LottoMachine
    lotto1 = LottoMachine()
    lotto1.make_new_numbers()

    # thanks to the custom __str__, this returns the informational representation that we wanted
    print(lotto1)

    # parameters could be changed here
    lotto1.balls = 16
    lotto1.upper_bound = 98
    lotto1.lower_bound = 69
    lotto1.sorting = False

    # reset l_n and run the test once more (with changed parameters)
    lotto1.reset_numbers()

    lotto1.make_new_numbers()
    print(lotto1)

    return

# declare lotto_tester() as main method of the program
if __name__ == "__main__":
    lotto_tester()

# that's it!
