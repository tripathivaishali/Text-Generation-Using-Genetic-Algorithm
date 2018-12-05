# Text-Search-Using-Genetic-Algorithm

# What is Genetic Algorithm?
The term “Genetic Algorithm” refers to a specific algorithm implemented in a specific way to solve specific sorts of problems. [Daniel Shiffman, Nature of Code – Chapter 9]
This algorithm is inspired by process of “natural selection” which basically belongs to the larger class of evolutionary algorithms (EA).
These algorithms are used to generate high quality solutions to optimize and search problems by relying on bio-inspired operations such as “crossover”, “mutation”, “selection” etc.
John Holland introduced Genetic Algorithm (GA) in 1960 based on the concept of Darwin’s theory of evolution

# Why to use Genetic Algorithm?
Because they are simple to program!
Proven to find the global optimum if given enough time.
Can be applied to diverse problem domains, etc. 
Can be used when we know what’s a good solution but we can’t figure out the road to that solution. It provides a good way to search and traverse the space of possible solutions in a smart way.
Along with easy implementation, it is easy to trace the performance.

# About this project - The Problem Statement
Genetic Algorithms are one of the best ways to go when we know a good solution but we can’t figure out the road to that solution.
 
Let’s consider the string “Program Structures and Algorithms is the best class!!”. This string is 54 characters long. If a system starts guessing this string character by character, the probability that the system guesses all the 54 characters right will be
(1/27) multiplied by itself 54 times!!! I.e.,  (1/27)54
which equals a 1 in 50,857,702,033,867,822,607,895,549,241,096,482,953,017,615,834,735,226,163,958,950 chance of getting it right!

Now, the chances are, if this system has capability of generating one million phrase per second, for the system to have a 99% probability to get the string right, it will have to work for 9,719,096,182,010,563,073,125,591,133,903,305,625,605,017 years.
However, using Genetic Algorithm to do this would hardly take few seconds! And that’s exactly what we are here to demonstrate!

# The demo of this project is available at https://youtu.be/oH2PLkd36lc

# Output Explained
The application accepts any string of user’s choice and applies Genetic Algorithm to generate the same string as an output based on the mutation rate entered by the user.
The total number of generations involved along with the average fitness of the generation and total time taken by the algorithm (benchmarking) to generate the output.

# Observations
The number of generations required to evolve a sentence vary with each execution.
The number of generations  and time required for evolution change drastically with change in the mutation rate
For a given population size, the algorithm with get the results fast and with least number of generations only for a given range of mutation rate. As we go on considering lower or higher mutation rates, the number of generations to reach the target string may increase or the final string may not be correct at all
If string size is too less, then is it normal to go in a infinity loop for a large mutation rate

 
# Conclusion
From this project, we understood that 
Genetic Algorithm can offer efficient way of searching and text generation if the target is known. 
It is not necessary to get the right result every time, unless the combinations of mutation rate and population size selected are in right range
For population size of 10,000, the mutation rate that suited almost all sizes of string is 0.01.


# References
Daniel Shiffman, “Nature of Code”, Chapter 09
Wikipedia
Vijini Mallawaarachchi’s article on “Introduction To Genetic Algorithms” featured at www.towardsdatascience.com
Paper on “A NEW APPROACH FOR DATA ENCRYPTION USING GENETIC ALGORITHMS” featured at www.researchgate.net






