# sbab_test

Use Flickr API to search for random images based on input query.

MVVM approach in a multi-modular project, where each feature is a separate module. This approach in my opinion helps
build a scalable app for the future. Potentially all isolated UI components (views, fragments, activities and resources can reside in their own module container)

Some explanation about the approach taken in implementation of the test case

1. Use Dagger to inject dependencies in a multi-modular project. Basically app module is the "core" module that provides
the creating of the dependencies graph, but if for example you have more than 2 modules, it's usually recommended to have a core module
that only maintains the creation of the graph 
2. flickrSearch module is a simple module that provides the search results transformed to UI layer data by exposing all the data
via a simple repository access
3. Other technologies use is view binding instead of kotlin data binding, coroutines and live data.
4. In case of unit testing, I couldn't find any reasonable options to build any other than testing the business logic, which can vary from verifying if the transformation methods are working properly via mocking. Personally I belive for this simple task I didn't need to add any unit tests, potentially mocking of REST responses and verying observers on viewmodel are being invoked.
5. As a personal taste I prefer Kotlin DSL instead of pure gradle files (might contribute to longer build times on large scale projects)
6. Instead of adding a search button I opted for using a debouncer of a couple of ms when searching for keywords.
7. The UI is quite lacking, could contain more information and probably some animations.
