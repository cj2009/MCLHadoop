# MCLHadoop

This project contains our MCL Algorithm implemented in Hadoop.

The matrix multiplication is based on the algorithm by Norstad (http://www.norstad.org/matrix-multiply/). Our algorithm has slight modifications in order to be better optimized for the MCL algorithm, rather than just for performing multiplication. We have implemented the algorithm based on Norstad's Strategy 3.

The rest of the algorithm is based on the original MCL algorithm by Stijn van Dongen: (http://micans.org/mcl/index.html).

This project also contains instructions on how to compile and run the MCL program, as well as a couple of other useful programs:
* TransformEdges.java: see the readme at the top of the file
* ExtractEdges.java: simply extracts the first n lines of a file and saves them to a new file
* jblas.jar: version 1.2.4 of the JBLAS library: http://jblas.org/
