# Feedback (Jack Smith)

## Comments

* Would have preferred inputting data from the command line.
* Errors should have been detected by testing.
* `~` not implemented.
* Reasonable code.


## Testing

* See Linux/OSX comamnd file `dtg_test` in your directory `7`.
* The following is a list of tests performed and the expected results.
* Your code failed `8` of these tests. _Note that throwing an exception is considered a failure._

````
23 23 + = 46
23 23 - = 0
17 4 / = 4
17 4 % = 1
15 4 * = 60
23 ~ = -23
0  4 /  = 0
4 0 /  = UNDEFINED
4   5   * = 20
4 5 * + = ERROR
4 5 6 * = ERROR OR 30
23 23 + 26 ~ + = 20
1 2 3 4 5 6 * * + + ~ + = -124
1 2 3 4 5 6 7 8 9 10 11 12 * * * * * * * * * * * = 479001600
1 2 3 4 5 6 7 8 9 10 11 12 * * * * * * * * * * * = ERROR OR -898433024 OR 6402373705728000
1 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ = -1
1 2 3 + 5 6 * ~ + 34 - - = 60
````




