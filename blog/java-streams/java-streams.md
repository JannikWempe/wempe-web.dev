Java Streams were introduced in Java 8. They provide a **declarative (or more precise: functional) API to work with collections**. The `java.util.stream` has the following [description in the java docs](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html).
> Classes to support **functional-style** operations on streams of elements, such as map-reduce transformations on collections.

There is more about streams besides a functional way to handle collections. It is also about lazy evaluation, parallelism and streams not using collections (e.g. infinite streams, `IntStream`, ...). But covering all these concepts exceed the scope of this article and therefore aren't described here (Maybe in an additional article?).

# Comparison between functional and imperative paradigm
The following repl shows a comparison between a functional and declarative way of summing up som numbers. In my opinion the declarative way using streams isn't only more concise, but also more readable. Therefore, I prefer the functional style.

{% replit @pinutz23/streams-functional %}

# Creating streams
The interface `Collection` ([see documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)) contains the method `default Stream<E> stream() {...};`, which returns a `Stream` instance. Commonly used interfaces like `List`, `Stack` and `Queue` implement the `Collection` interface and thus you can create a `Stream` by calling the `stream()` method on instances of classes implementing these interfaces (e.g. `HashSet`).

{% replit @pinutz23/streams-collection %}

## Bonus: infinite streams
There are also so called *infinite streams*, which are lazily evaluated (which means they are not created ahead of time; they have to, because otherwise they would require an infinite amount of memory). Make sure to limit the stream in order to prevent the program to potentially run endlessly.

{% replit @pinutz23/streams-infinite %}

# Using streams / stream pipeline
There are two different kinds of operations you can do on a stream: **intermediate and terminal operations**. Chaining these operations creates a _**stream pipeline**_. Some operations are shown by examples below. You can read [details about intermediate and terminal operations in the docs](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html#StreamOps).

## Intermediate operations
**Intermediate operations return another Stream**, so you can chain another operator to it. The following subsections show some examples. These are commonly used, but there are more (like `flatMap` or `peek`).

### `Stream<T> filter(Predicate<? super T> predicate)` ([docs](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#filter-java.util.function.Predicate-))
> Returns a stream consisting of the elements of this stream that match the given predicate.

_Example: Getting only books with more than 400 pages._
{% replit @pinutz23/streams-filter %}

### `Stream<T> sorted(Comparator<? super T> comparator)` ([docs](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#sorted-java.util.Comparator-))
> Returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.

_**What?** Sort all books by their title._
{% replit @pinutz23/streams-sorted %}

_**Hint:** there is also the `Stream<T> sorted()` method, which can be used if `T` implements the `Comparable` interfaces `compareTo(T o)` method._

### `<R> Stream<R> map(Function<? super T,? extends R> mapper)` ([docs](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#map-java.util.function.Function-))
> Returns a stream consisting of the results of applying the given function to the elements of this stream.

_**What?** Getting only the title of all books._
{% replit @pinutz23/streams-map %}

### Combining `filter`, `sorted` and `map`
_**What?** Get only books with more than 400 pages, sort them by title and map them to only their title._
{% replit @pinutz23/streams-map %}

By reading the **What?** descriptions, you realize that this is all about declarative programming.

## Terminal operations
**Terminal operations terminate the stream pipeline.** They either produce a **side-effect** (like printing) or a **result** (like reducing). After a terminal operation, the stream is _**consumed**_.

### `void forEach(Consumer<? super T> action)` ([docs](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#forEach-java.util.function.Consumer-))
> Performs an action for each element of this stream.

`forEach` produces a side-effect (it returns void, so it has to produce a side-effect, otherwise it would just do nothing). `forEach` is used in all previous examples to print the result.

### `T reduce(T identity, BinaryOperator<T> accumulator)` ([docs](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#reduce-T-java.util.function.BinaryOperator-))
> Performs a reduction on the elements of this stream, using the provided identity value and an associative accumulation function, and returns the reduced value.

_**What?** Get the sum of all pages of all the books._
{% replit @pinutz23/streams-reduce %}

_**Hint:** There are also other overloads of the `reduce` method._

### `<R,A> R collect(Collector<? super T,A,R> collector)` ([docs](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#collect-java.util.stream.Collector-))
> Performs a mutable reduction operation on the elements of this stream using a Collector.

_**What?** Get a `Set` containing the titles of all books._
{% replit @pinutz23/streams-collect %}

You can do a lot more with `Collectors`. You could also group the result (imagine grouping books by author or genre).

_**Hint:** There are also other overloads of the `collect` method._

# Feedback welcome
This is my very first blog post. I'd really appreciate your feedback. **What did you (not) like? And why?** Please let me know, so I can improve the content.

I also try to create valuable content on Twitter. [Just have a look](https://twitter.com/pinutz23).
