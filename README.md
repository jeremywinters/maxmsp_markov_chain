###weighted markov model for max/msp###

this project is the java source for a weighted markov model I made many years ago for use via the mxj object in max/msp.

this object operates asynchronously...

- int - input to the markov model (note number)
- bang - output the next note based on random selection
- clear_matrix - clears the markov model

the model keeps track of how many times two notes are played in sequence.  so... if you input the following stream of integers...

36
40
36
42

...sending a series of bangs will output the following...

36 (the first note in is always the first out)
40 or 42 (there is a 50/50 chance)
36 (40 always goes to 36... 42 has no note after it in the map... so it will default to the root)

now!  if you add in a few more notes...

36
40

after note 36 is output... you will see that 40 has a 2/3 chance of being played next.  this is the weighting in effect.

anyways... follow the mxj instructions for compiling and give it a try!