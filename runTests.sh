#!/usr/bin/env sh

class_path=./build/classes/java/main/

# Sorting algorithms
# echo ">> Sorting algorithms:"
#
echo ">>- Run int[] random test:"
# java -cp $class_path SortingTest data/list.random.txt selectionsort
# java -cp $class_path SortingTest data/list.random.txt insertionsort
java -cp $class_path SortingTest data/list.random.txt mergesort
java -cp $class_path SortingTest data/list.random.txt quicksort
java -cp $class_path SortingTest data/list.random.txt countingsort

echo ">>- Run int[] quasisorted test:"
java -cp $class_path SortingTest data/list.quasisorted.txt mergesort
java -cp $class_path -Xss20m SortingTest data/list.quasisorted.txt quicksort
java -cp $class_path SortingTest data/list.quasisorted.txt countingsort

# echo ">>- Run generic test:"
# java -cp $class_path GenericSortingTest data/list.random.txt

# Basic Datastructures
echo ">>- Basic datastructures:"

java -cp $class_path ListTest data/ListOperations.txt > my.ListOperations.log.txt
diff -s my.ListOperations.log.txt data/ListOperations.log.txt

java -cp $class_path QueueTest data/QueueOperations.txt > my.QueueOperations.log.txt
diff -s my.QueueOperations.log.txt data/QueueOperations.log.txt

java -cp $class_path StackTest data/StackOperations.txt > my.StackOperations.log.txt
diff -s my.StackOperations.log.txt data/StackOperations.log.txt

echo ""
echo ">>- Trees"

java -cp $class_path TreeTest data/TreeOperations.txt > my.TreeOperations.BST.log.txt bst
diff -s data/TreeOperations.BST.log.txt  my.TreeOperations.BST.log.txt

java -cp $class_path TreeTest data/TreeOperations.txt > my.TreeOperations.AVL.log.txt avl
diff -s data/TreeOperations.AVL.log.txt  my.TreeOperations.AVL.log.txt

echo ""
echo ">>- Dictionaries: HashMap (Java) vs AVLDictionary vs HashTable"
java -cp $class_path DictionarySpeedTest 100000

echo ""
echo ">>- Priority Queues"
java -cp $class_path PriorityQueueTest data/words.txt my.orderedWords.txt > /dev/null

# echo ">>- Union-find"
# echo ""
