## Feedback ##

### Merits ###
* Realistic corpus provided
* Compiles with ant script and runs
* Computes the correct answer
* Case-insensitive

### Demerits ###
* The number of tokens is hard-coded - you have to change the code in two places if you want to change the reference corpus - not good!
* It's a good idea to use a map to store the word/count pairs, but I think it's overkill to have a second map for the sentence. In general, you could have solved this problem with less processing and fewer structures.
* The processing of the reference corpus so that digits and are removed is too much - in reality these would be left in.
* There seems to be two for loops back-to-back which do the same thing - removing empty strings from the list.
* The *text* variable does not need to be global - you are only using it in the main method.
* It isn't very user-friendly to have to end the sentence with a space.

### To Think About ###
* How would you go about handling words that are not in the reference corpus, assuming that you don't want the whole sentence to get a probability of zero?
* What happens to the probability values when the reference corpus and/or the input sentence increase in size?
