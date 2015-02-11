vlcj-info
=========

A small Java library to make it easy to get media information from local files.

This library uses JNA to provide simple Java bindings to the native
[MediaInfo](https://mediaarea.net/en/MediaInfo) tool.

Maven Dependency
----------------

Add the following Maven dependency to your own project pom.xml:

```
<dependency>
    <groupId>uk.co.caprica</groupId>
    <artifactId>vlcj-info</artifactId>
    <version>1.0.0</version>
</dependency>
```

News
----

??/??/2015 First release at [Maven Central](http://search.maven.org/#search|ga|1|vlcj-info).

Documentation
-------------

The vlcj-info project page is at [github](http://caprica.github.com/vlcj-info "vlcj-info at github").

Online Javadoc is available:

* [1.0.0 (current)](http://caprica.github.com/vlcj-info/javadoc/1.0.0/index.html "1.0.0 Javadoc")

Basic Usage
-----------

Usage is trivial:

```
MediaInfo mediaInfo = MediaInfo.mediaInfo("/home/movies/A-Cool-Movie.mp4");
```

You can then query the return media info instance for general information, audio, video and SPU
tracks and so on.

License
-------

The vlcj-info framework is provided under the GPL, version 3 or later.
