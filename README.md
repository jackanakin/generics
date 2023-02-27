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
