# Exercise 2: Reading Basic RSS

We will create a short and sweet RSS reader that will only show the stuff that you are really interested in.

## Install Eclipse 4.2 + Scala IDE

Instructions in the main README.md:
https://github.com/affected/curious-learners/tree/master/scala

## Create a new Scala Project with Eclipse

With the Eclipse New Project wizard. Use BasicRssReader as name, or not.

## Create a new Scala Object Called BasicRssReader

From the Package Explorer source folder with context menu.
Create a main method in to the object by typing "main" in to the object body and pressing CTRL+SPACE.
Type
  println("Hello World!")
in to the main method and save.

Run the app. Good!

## Get the XML you need

We want to read exciting news from:
http://www.scala-lang.org/rss.xml
(The news from the front page of scala-lang.org.)

Use this Scala library function to load the RSS feed:
scala.xml.XML.load( url )

Print the XML instead of Hello World! to make sure it works. (toString())

If you are using a crappy internet connection, like a train WLAN, save the RSS 
to a file and use another function from XML to load a file instead of URL.

## Scala has XML support built in

You get an Elem from load(). With an elem you can use XPath like queries with \\ and \ operators.
To get the RSS item elements you could use:
  val items = rssElem \\ "item"
To get the title of the first channel in the RSS you could use:
  val channelTitle = (rssElem \ "channel" \ "title").head.text

An RSS channel only has 1 title, but an XML document can have many elements with the same name
so \ always returns a NodeSeq - a list of nodes. The head methods gets the first node from
the list and text returns the text contents of an XML Node.

## Who has written the articles in the feed?

Get the article titles and links to the grouped by the authors name from the RSS feed.
The articles are "item" elements. The authors name is in "dc:creator" element.
The URL to see the article is in the "link" element.

When I did this the result looked like this:

<pre>

plocinic:
  Your Summer of Code 2012 with Scala: http://www.scala-lang.org/node/12565

cunei:
  Scala Training: http://www.scala-lang.org/node/12650

dotta:
  Scala IDE 2.1 Special Edition for 2.10.0-M3 available now!: http://www.scala-lang.org/node/12675
  Scala IDE 2.1 Milestone 1 available now!: http://www.scala-lang.org/node/12604
  Scala IDE 2.0.1 RC2 available now!: http://www.scala-lang.org/node/12571

admin:
  Scala 2.10.0 Milestone 7: http://www.scala-lang.org/node/12797
  Scala 2.10.0 Milestone 6: http://www.scala-lang.org/node/12774
  Scala 2.10.0 Milestone 5: http://www.scala-lang.org/node/12735
  New releases of the Scala IDE for Eclipse: http://www.scala-lang.org/node/12719
  Scala 2.10.0 Milestone 4: http://www.scala-lang.org/node/12702
  Scala 2.10.0 Milestone 3: http://www.scala-lang.org/node/12659
  Scala 2.9.2 final: http://www.scala-lang.org/node/12603
  Scala 2.9.2 RC3: http://www.scala-lang.org/node/12593
  Scala 2.9.2 RC2: http://www.scala-lang.org/node/12578
  Scala 2.9.2 RC1: http://www.scala-lang.org/node/12568
  Typesafe Stack 2.0 released: http://www.scala-lang.org/node/12566
  Scala 2.9.1-1: http://www.scala-lang.org/node/12559
  Scala 2.9.1-1 RC1: http://www.scala-lang.org/node/12555
  Scala 2.10.0 Milestone 2: http://www.scala-lang.org/node/12550

bagwell:
  Scala, Lift and Cloud Foundry: http://www.scala-lang.org/node/12563
  Akka 2.0 Released!: http://www.scala-lang.org/node/12560
  Scala Days 2012 - The Speakers & Talks: http://www.scala-lang.org/node/12558
  Scala Days 2012 - Shaping Up!: http://www.scala-lang.org/node/12473
  Scala Artifacts on Maven Central - Scala-tools retires: http://www.scala-lang.org/node/12437

</pre>

.. but the feed can of course change and the you can format the output any way you want.
My first implementation of this was 23 lines in the whole .scala file. If you go above 
50, ping me and we can talk about the excercise.

## For extra credit

The authors really should be ordered alphabetically and their articles newest first. Go!