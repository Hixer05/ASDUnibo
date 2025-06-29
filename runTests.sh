#!/usr/bin/env sh

# Sorting algorithms
# echo "- Sorting algorithms:"
#
# echo "-- Run int[] random test:"
# # java SortingTest data/list.random.txt selectionsort
# # java SortingTest data/list.random.txt insertionsort
# java SortingTest data/list.random.txt mergesort
# java SortingTest data/list.random.txt quicksort
# java SortingTest data/list.random.txt countingsort

# echo "-- Run int[] quasisorted test:"
# java SortingTest data/list.quasisorted.txt mergesort
# java -Xss20m SortingTest data/list.quasisorted.txt quicksort
# java SortingTest data/list.quasisorted.txt countingsort

# echo "-- Run generic test:"
# java GenericSortingTest data/list.random.txt


# Basic Datastructures
echo "- Basic datastructures:"

java ListTest data/ListOperations.txt > my.ListOperations.log.txt
diff -s my.ListOperations.log.txt data/ListOperations.log.txt

java QueueTest data/QueueOperations.txt > my.QueueOperations.log.txt
diff -s my.QueueOperations.log.txt data/QueueOperations.log.txt

java StackTest data/StackOperations.txt > my.StackOperations.log.txt
diff -s my.StackOperations.log.txt data/StackOperations.log.txt
