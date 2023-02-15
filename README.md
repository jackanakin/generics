# Generics, Reflection & Collections in Java
`https://www.udemy.com/course/introduction-to-generics-in-java/`

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
