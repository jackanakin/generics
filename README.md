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
Lower Bounded (super) -> PUT<br/>
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

Collections are essentially data structures in the RAM.</br>
They need the whole data in advance before it can be added to the collection.</br>
Streams provide interfaces to data structures representing a sequenced set of values, it's elements are computed on demand.</br>


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

- Random access feature<br/>
- Fast<br/>
- Best use case is to manipulate the last items or access items with known indexes

Disadvantages:<br/>

- Number of items defined at compile-time<br/>
- Must be resized O(N) at runntime if it's full<br/>
- Usually must store items of same type<br/>

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

- Dynamic, can acquire memory at run-time, thus no resizing needed and organic grow.</br>
- Manipulating items at the beggining is fast - O(1).</br>
- Items are not store next to each other in the memory.<br/>
- More complex data structures and abstract data types such as stacks and queues can be implemented.<br/>

Disavantages:<br/>

- No random access, must start looking from the begginig.</br>
- Need more memory to store references.</br>
- Can't go backwards, so no previous item manipulation.</br>
- Running time not predictable.</br>
- Slow to manipulate arbitrary item O(N).</br>

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

### 2.2 Maps

`Aim is to reach O(1) complexity for most of the operations`

Also known as associative arrays or dictionaries.</br>
Collection of key-value pairs.</br>

#### 2.3.1 Hashtables

`Map<Integer, String> map = new HashMap<>();`

Map uses the hashCode function to calculate an index for the item (the key).</br>
If Java detects a collision in a map, it uses the equals() method to find the item (the key).</br>

Principles:</br>

1. if two objects are equal, they must have the same hash code.</br>
2. if two objects have the same hash code, they may or may not be equal.</br>

Adding items - O(1): <br/>
`map.put(1, "Odin");`
`map.put(2, "Zeus");`
Getting items - O(1): </br>
`map.get(1);`
Removing items - O(1): </br>
`map.remove(1);`
Iterate over keys and values at the same time:</br>
`for ( Map.Entry<Integer,String> entry : map.entrySet() ) System.out.println( entry.getKey() + ":" + entry.getValue() );`

[Java Example]()

#### 2.3.2 LinkedHashMap

`Map<Integer, String> map = new LinkedHashMap<>();`

Mantains order in which items are inserted, when using map.keySet() keys are ordered.</br>
Uses extra memory.</br>

#### 2.3.3 TreeMap

`Map<Integer, String> map = new TreeMap<>();`

O(logn) in worst case cenarios.</br>
Uses Red-black Trees in it's implementation.</br>
The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time.</br>
This implementation provides guaranteed log(n) time cost for the containsKey, get, put and remove operations.</br>

[Java Example]()

#### 2.3.3 HashMap

`Map<Integer, String> map = new HashMap<>();`

O(1) for operations if no collision is present.</br>

### 2.4 Sets

`Abstract data type that stores values without particular order and no duplicates.`

#### 2.4.1 HashSet

`Set<String> set = new HashSet<>();`

Hash-function based data structure.</br>
Initial size is 16.</br>
retainAll: mantain only values present on the second Set.</br>
`set.retainAll(set2);`
containsAll: checks if it contains all values of the second Set.</br>
`System.out.println(set.containsAll(set2));`

#### 2.4.2 LinkedHashSet

`Set<String> set = new LinkedHashSet<>();`

Balanced binary tree based data structure.</br>
Mantains the insertion order.</br>

#### 2.4.3 TreeSet

`Set<String> set = new TreeSet<>();`

Red Black Tree based data structure.</br>
Allows Sorting.</br>

### 2.5 Sorting Collections

#### 2.5.1 Sorting Arrays

Java uses QuickSort to sort primitive types (int, float, etc.).</br>
Java uses MergeSort to sort reference types (Integer, String ...).</br>
To get descending order, iterate over the array in reverse order.</br>

`int[] nums = {1,10,3,5,2};`
`Arrays.sort(nums);`

#### 2.5.2 Sorting Collections

`Collections.sort(list);`</br>
`Collections.sort(list, Collections.reverseOrder());`</br>


* Comparable: sorting algorithm defined in base classe:</br>
`public class Book implements Comparable<Book> {}`</br>
`@Override public int compareTo(Book other){}`</br>
`Collections.sort(bookList);`</br>

* Comparator: separate class with particular algorithm, gives more flexibility and allows to define multiple sorting algorithm:</br>
`public class BookComparator implements Comparator<Book> {}`</br>
`@Override public int compare(Book book1, Book 2){}`</br>
`Collections.sort(bookList, new BookComparator());`</br>
`Collections.sort(bookList, new BookComparator().reversed());`</br>

* Lambda: using lambda expressions for sorting:</br>
`Collections.sort(bookList, Comparator.comparing(Person::getName));` Sorting by Name</br>
`Collections.sort(bookList, Comparator.comparing(Person::getAge).reversed());` Sorting by Age</br>
`Collections.sort(bookList, Comparator.comparing(Person::getName).thenComparing(Person::getAge).reversed());` Sorting by Name first, then Age descending (if Names are equal)</br>

#### 2.6.2 Collections Class

Reversing order:</br>
`Collections.reverse(nums);`
Finding max value:</br>
`Collections.max(nums);`
Shuffle:</br>
`Collections.shuffle(nums);`
Rotate:</br>
`Collections.rotate(nums, 1);` Last number will be the first.</br>
`Collections.rotate(nums, 2);` Last two numbers will be first and second.</br>
Replace:</br>
`Collections.replaceAll(nums, 1, 10);` Replaces all numbers 1 with 10.</br>
Immutable collection:</br>
`list = Collections.unmodifiableList(list);` - throws UnsupportedOperationException if modify is attempted.</br>
Synchronized collection: intrinsic lock</br>
`List<Integer> list = Collections.synchronizedList(new ArrayList<>());` - add() and remove() methods are synchronized.</br>

## 3. Reflection
`Is the ability to inspect and dynamically call methods, classes etc.`

Possible to inspect the source code dynamically at run-time.</br>

### 3.1 Get class

Option 1:</br>
`Class<Person> p = Person.class;`</br>
`System.out.println(p.getName());`</br>

Option 2:</br>
`Class personClass = null;`</br>
`try { personClass = Class.forName(com.mypackage.Person); }`</br>
`System.out.println(personClass.getName());`</br>

Getting interfaces classes:</br>
`public class Car implements Vehicle {}`</br>
`public class Bus implements Vehicle {}`</br>
`checkClass(Vehicle vehicle) { Class c = vehicle.getClass(); sysout(c.getName()); }`

### 3.2 Fields

`public class Person { public String name; public int age; }`</br>
`Class personClass = Person.class;`</br>
`Field[] fields = personClass.getFields();` - only public fields will be visible.</br>

Getting private fields: </br>
`Field[] fields = personClass.getDeclaredFields();`</br>
`fields.forEach(field -> { field.setAccessible(true); System.out.println(field); });`</br>

### 3.3 Methods

`Methods[] methods = personClass.getMethods();` - only public fields will be visible.</br>

Getting private fields: </br>
`Methods[] methods = personClass.getDeclaredMethods();`</br>
`methods.forEach(method -> { method.setAccessible(true); System.out.println(method); });`</br>

### 3.4 Constructors and Singletons
`We can instantiate a class with reflection despite it has private constructor`

`Constructor<Person> ctor = Person.class.getDeclaredConstructor();`</br>

We can instantiate a new class:</br>
`Person person = ctor.newInstance();`</br>

### 3.5 Superclasses and Interfaces

`Class[] interfaces = personClass.getInterfaces();`</br>
`personClass.getSuperclass().getName();`</br>

### 3.6 Annotations

`Methods[] methods = personClass.getDeclaredMethods();`</br>
`methods.forEach(method -> { if ( method.isAnnotationPresent(MyAnnotation.class) { sysout(method); } ) } );`</br>
