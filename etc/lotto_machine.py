# lotto_machine.py

from random import randint


class LottoMachine:
    LOTTO_BALLS = 6

    def __init__(self, lotto_numbers: list = []):
        self.lotto_numbers = lotto_numbers
        self.l_n = lotto_numbers
        self.reset_numbers()

    def __repr__(self):
        return f"LottoMachine(lotto_numbers={self.l_n})"

    def __str__(self):
        string = f"Actual Lotto numbers are: {self.num_string()}"
        return string

    def num_string(self):
        actual_nums = [num for num in self.l_n if num != 0]
        num_string = str(actual_nums).strip('[]').replace(',', '')
        return num_string

    def reset_numbers(self):
        self.l_n = [0 for _ in range(self.LOTTO_BALLS)]

    def make_one_number(self):
        num = randint(1, 49)
        for i, j in enumerate(self.l_n):
            if j == 0:
                if num in self.l_n:
                    self.make_one_number()
                    return
                self.l_n[i] = num
                return

    def make_new_numbers(self):
        for _ in range(self.LOTTO_BALLS):
            self.make_one_number()
        return


def lotto_tester():
    lotto1 = LottoMachine()
    lotto1.make_new_numbers()
    print(lotto1)
    lotto1.reset_numbers()
    lotto1.make_new_numbers()
    print(lotto1)
    return


if __name__ == "__main__":
    lotto_tester()
