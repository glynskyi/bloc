# Bloc

A predictable state management library witch helps implement the BLoC design pattern with Kotlin.

## Overview

<img src="https://raw.githubusercontent.com/felangel/bloc/master/docs/assets/bloc_architecture.png" alt="Bloc Architecture" />

The goal of this library is to make it easy to separate _presentation_ from _business logic_. It uses all the power of coroutines.

## Using in your projects

The libraries are published to [JCenter](https://bintray.com/bintray/jcenter?filterByPkgName=com.dglynskyi.bloc) repository.

### Maven

Add dependencies (you can also add other modules that you need):

```xml
<dependency>
    <groupId>org.dglynskyi</groupId>
    <artifactId>bloc</artifactId>
    <version>0.0.1</version>
</dependency>
```

And make sure that you use the latest Kotlin version:

```xml
<properties>
    <kotlin.version>1.3.61</kotlin.version>
</properties>
```

### Gradle

Add dependencies (you can also add other modules that you need):

```groovy
dependencies {
    implementation 'org.glynskyi.bloc:0.0.1'
}
```

And make sure that you use the latest Kotlin version:

```groovy
buildscript {
    ext.kotlin_version = '1.3.61'
}
```

Make sure that you have either `jcenter()` or `mavenCentral()` in the list of repositories:

```
repository {
    jcenter()
}
```