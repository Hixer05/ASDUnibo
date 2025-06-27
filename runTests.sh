#!/usr/bin/env sh

# Sorting algorithms
echo "- Sorting algorithms:"
javac ./algorithm/sorting/Sorting.java
javac ./SortingTest.java
javac ./GenericSortingTest.java

echo "-- Compiled."
echo "-- Run int[] test:"
java SortingTest data/list.random.txt selectionsort
java SortingTest data/list.random.txt insertionsort
java SortingTest data/list.random.txt mergesort
java SortingTest data/list.random.txt quicksort

echo "-- Run generic test:"
java GenericSortingTest data/list.random.txt
