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
    <version>2.0.1</version>
</dependency>
```

News
----

4th May, 2021 - release 2.0.1, fixes an issue when using custom formatting options (or using MediaInfo after using MediaFile)

7th March, 2019 - add API to get individual piece of information from the media file
[Maven Central](http://search.maven.org/#search|ga|1|vlcj-info).

Documentation
-------------

The vlcj-info project page is at [github](http://caprica.github.com/vlcj-info "vlcj-info at github").

Basic Usage
-----------

Usage is trivial:

```
MediaInfo mediaInfo = MediaInfo.mediaInfo("/home/movies/A-Cool-Movie.mp4");
Section video = mediaInfo.first("Video");
Integer width = video.integer("Width");
Integer height = video.integer("Height");
```

You can then query the returned media info instance for general information, audio, video and SPU
tracks and so on.

The previous example extracts the media information en masse, you can use an alternate API to pick
out the particular pieces of information you require (and optionally specify its formatting):

```
MediaInfoFile file = new MediaInfoFile("test.mp4");
if (file.open()) {
    System.out.println(file.info("Video;%Duration%"));
    System.out.println(file.info("Video;%Duration/String3%"));
    System.out.println(file.info("General;%Duration%"));
    file.close();
}
```

The values used when picking out information in this way are the exact same as used by the
MediaInfo tool itself.

Generally the values are `String` values that must be parsed. Since you can specify the formatting
it is up to you to parse those values as required.

License
-------

The vlcj-info framework is provided under the GPL, version 3 or later.
