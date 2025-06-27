#!/usr/bin/env sh

# Sorting algorithms
echo "- Sorting algorithms:"
javac ./algorithm/sorting/Sorting.java
javac ./SortingTest.java
javac ./GenericSortingTest.java

echo "-- Compiled."
echo "-- Run int[] random test:"
# java SortingTest data/list.random.txt selectionsort
# java SortingTest data/list.random.txt insertionsort
java SortingTest data/list.random.txt mergesort
java SortingTest data/list.random.txt quicksort
java SortingTest data/list.random.txt countingsort

echo "-- Run int[] quasisorted test:"
java SortingTest data/list.quasisorted.txt mergesort
java -Xss20m SortingTest data/list.quasisorted.txt quicksort
java SortingTest data/list.quasisorted.txt countingsort

# echo "-- Run generic test:"
# java GenericSortingTest data/list.random.txt
