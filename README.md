# Generics, Reflection & Collections in Java
`https://www.udemy.com/course/introduction-to-generics-in-java/`

[Oracle](https://docs.oracle.com/javase/tutorial/java/generics/index.html)

## 1. Generics

Why use generics ?<br/>
Eliminates type casting (JVM must test type casting at run-time), compile time erros over run time errors, avoid method overloading.

### 1.1 Basic
`class GenericStore<T>`

[Java Example]()

### 1.2 Multiple Generics
`class HashTable<K, V>`

[Java Example]()

### 1.3 Methods
`public <T, V> boolean checkEquality(T t, V v)`

[Java Example]()

### 1.4 Bounded Type Parameters
`<T extends Comparable>`<br/>
`public static <T extends Number> double add(T num1, T num2)`

Restrict the types that can be used as type parameters, like accept only numbers (integers, float, double).<br/>
Allows to invoke methods in defined in the bound.

[Java Example]()

### 1.5 Type Inference
`The ability of the compiler to look at each method invocation and corresponding declaration trying to find the most specific type that works with all of the arguments`

In the example above, the compiler determined the type as Serializable since both String and ArrayList implement it.<br/>
It's the ability of the compiler to determine the type of argument(s) and the type of the returned value.

[Java Example]()

### 1.6 Wildcards
``

#### 1.6.1 Unbounded Wildcards
`List<?> – represents a list of any type - A list of unknown type`

Usefull if:<br/>
Writing a method that can be implemented using functionality provided in the Object class.<br/>
Code is using methods in the generic class that don't depend on the type parameter.<br/>
Class<?> is so often used because most of the methods in Class<T> do not depend on T.<br/>

[Java Example]()

#### 1.6.2 Upper Bounded Wildcards
`List<? extends Number> – represents a list of Number or its subtypes (for instance, Double or Integer)`

An Integer cannot be added to the list because the type can not be guaranteed - it may be a List<Double> since it's a subtype of Number also.<br/>
Upper Bounded Wildcards are used to read items.<br/>
Does not provide immutability.<br/>

[Java Example]()

#### 1.6.3 Lower Bounded Wildcards
`List<? super T>`

Used to insert items into a generic data structure or collection.<br/>
Can accept a list of any superclass of T<br/>

Upper Bounded (extends) -> GET<br/>
Lower Bounded (super)   -> PUT<br/>
Bounded Type Parameters -> GET/PUT<br/>

[Java Example]()

#### 1.6.4 Wildcards Exercise

Copy and insert from one collection to another using both Upper and Lower Bounded Wildcards

[Java Example]()

### 1.7 Type Erasure and Bridge Methods
`The compiler discards the type parameters on the class and replaces them with its first bound, or Object if the type parameter is unbound.`

The final bytecode will contain plain java classes and objects!</br>
Java uses Type Erasure to implement generics, it replaces all generics type parameters and wildcards with their bounds or Object for unbounded type parameters.<br/>
Bridge Method is a synthetic method created by the Java compiler while compiling a class or interface that extends a parameterized class or implements a parameterized interface where method signatures may be slightly different or ambiguous.

[Java Example]()

## 2. Data Structures

### 2.1 List

Extends `Collection` interface.<br/>
Can include duplicate values.<br/>
Full visibility and control over the ordering.<br/>

#### 2.1.1 Array

It's aim is to be as fast as possible.<br/>
Can be used to store any type of item.<br/>
Are identified by an integer value starting at 0 - so-called index (keys).<br/>
Are placed right next to each other in the main memory RAM.<br/>
`memory address = array's address + index * data size`

##### 2.1.1.1 Array
`Default capacity of new ArrayList<>() is 10`

Small sized arrays: less ram but if it must be resized takes O(N).<br/>
Huge arrays: waste memory because of the large size.<br/>

Resizing the array takes O(N).<br/>
`names = new ArrayList<>(); // if not specified, initial capacity is 10`
Adding items: O(1) - new items are inserted at the end of the array.<br/>
`names.add("Jardel");`
Adding item to arbitrary position: O(N) - items must be shifted.<br/>
`names.add(0, "Daniel");`
Removing last item: O(1).<br/>
`names.remove( names.size() - 1 );`
Finding item by value takes O(N).<br/>
`names.contains("Jardel");`
Removing from arbitrary position: O(N) to search for item(if index not known) + O(1) to remove + O(N) to shift other items.<br/>
`names.remove(1);`
Because of iterable interface.<br/>
`for ( String name : names ) sysout( name );`

Advantages:<br/>
* Random access feature<br/>
* Fast<br/>
* Best use case is to manipulate the last items or access items with known indexes

Disadvantages:<br/>
* Number of items defined at compile-time<br/>
* Must be resized O(N) at runntime if it's full<br/>
* Usually must store items of same type<br/>

##### 2.1.1.2 LinkedList
`LinkedList linkedList = new LinkedList<>(); for full features access`

Adding new item: O(1).</br>
`linkedList.add(1);`
Manipulating items at the beggining or at the end: O(1).</br>
`linkedList.addFirst(0);`
`linkedList.removeFirst();`
`linkedList.addLast(100);`
`linkedList.removeLast();`

Aim is to be efficient (insert and remove operations).<br/>
Every node stores tha data and a reference to the next node in the linked list, this is why they need more memory than Arrays.<br/>
By this way, there are no "holes" in the structure and no shifting is required after adding or removing items.<br/>

Advantages:<br/>
* Dynamic, can acquire memory at run-time, thus no resizing needed and organic grow.</br>
* Manipulating items at the beggining is fast - O(1).</br>
* Items are not store next to each other in the memory.<br/>
* More complex data structures and abstract data types such as stacks and queues can be implemented.<br/>

Disavantages:<br/>
* No random access, must start looking from the begginig.</br>
* Need more memory to store references.</br>
* Can't go backwards, so no previous item manipulation.</br>
* Running time not predictable.</br>
* Slow to manipulate arbitrary item O(N).</br>

ArrayList vs LinkedList: main performance difference is manipulating the first item, while ArrayList must shift all items after - O(N), LinkedList simply change the reference - O(1), last item manipulation takes O(1) for both structures.

##### 2.1.1.3 Stacks
`pop(); push(); peek(); - retrieve the value of the last item without removing it`

It's an abstract type, can be implemented either with ArrayList or with LinkedList.</br>
LIFO - Last In First Out.</br>

Creating the data structure:</br>
`Stack<String> names = new Stack<>();`
Manipulating items:</br>
`names.push("Odin");`
`names.push("Odiseu");`
`names.peek();`
`names.pop();`

### 2.2 Queues
`enqueue(); dequeue(); peek();`

It's an abstract type, can be implemented either with ArrayList or with LinkedList.</br>
FIFO - First In First Out.</br>
Usefull for shared resources like in threads.</br>

Creating the data structure:</br>
`Queue<String> queue = new LinkedList<>();`
Adding item: FIFO - O(1).</br>
`queue.add("Odin");`
`queue.add("Thor");`
`queue.add("Loki");`
Removing item:</br>
`queue.remove("Loki");`
`while ( ! queue.isEmpty() ) queue.remove();`

#### 2.2.1 PriorityQueue
`add(); peek(); poll();`

Element with high priority is served first.</br>
Elements are ordered according to their natural ordering defined by the Comparable interface.</br>

[Java Example]()

#### 2.2.2 ArrayDeque
`double ended queue (DEQUE)`

Huge one dimensional arrays, can manipulate both first and last item with O(1) performance.</br>

[Java Example]()

ArrayDeque vs Stack: because Stack is synchronized (it extends the Vector class), it is going to be slower than the ArrayDeque solution. So it is advisable to use ArrayDeque if we are after a LIFO structure.