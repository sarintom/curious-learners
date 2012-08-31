# Exercise 1: experiments in REPL (= command line)

The task is to use the Scala interpreter for reading a text file (mediakanta.conf) and parsing the contents and printing them to standard output. DO NOT use Eclipse for this task. You should convert the file to a List of lines and then use some of the List operations (map, foreach, filter, sort) for completing the task. Note that Scala strings are Java strings, so you can use all the familiar java string methods (trim, split, matches). Note that in Scala the arrays are indexed with () not with []. The Scala api is you your friend and you may want to check out these classes: List, Source

First, download Scala 2.9.2 and install it to your laptop.

So to the actual assignment. It’s defined just by input and output.

The input file looks like (mediakanta.conf):
preview.image.offset.s = 10
preview.image.dir = "images/previews"
preview.image.width = 720
preview.image.height = 405
preview.image.input.dir = "incoming/images/preview"
preview.image.scales.width = ["620", "220", "160", "65"]

filmstrip.image.dir = "images/filmstrips"
filmstrip.image.width = 720
filmstrip.image.height = 405
filmstrip.interval.seconds = 30
filmstrip.filename.format = "%s-%d.jpg"

And the expected output to console is just the integer values after the ‘=’ in ascending order:
10
30
405
405
720
720

You may want to start the REPL like this (hint: look at the import!):

C:\Users\Antti>scala

Welcome to Scala version 2.9.2 (Java HotSpot(TM) 64-Bit Server VM, Java 1.6.0_24).

Type in expressions to have them evaluated.

Type :help for more information.

scala> import scala.io.Source.fromFile

import scala.io.Source.fromFile

scala> val contents = fromFile(...

