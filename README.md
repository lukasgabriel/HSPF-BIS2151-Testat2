# HSPF-BIS2151-Testat2

## To change LottoMachine parameters:


Call 
`LottoMachine.setParameters(lottoBalls, lottoLowerBound, lottoUpperBound, sortLotto);`

---
### Arguments:

- `lottoBalls`: the amount of ball rolls *(real world: 6)*
- `lottoLowerBound`: the lowest number on any ball *(real world: 1)*
- `lottoUpperBound`: the highest number on any ball *(real world: 49)*
- `sortLotto`: should the representation of the lotto result be sorted? *(real world: yes)*

---
### Example (with default values):
```java 
myLotto.setParameters(6, 1, 49, false);
```