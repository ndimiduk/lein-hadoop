# lein-hadoop

This is a plugin for [Leiningen][0] which generates a jar suitable for
submission as a [Hadoop][1] job. Specifically, this is a runable jar
with <tt>lib/</tt> containing all project dependencies. The contents
of <tt>lib/dev</tt> are excluded.

The name of the generated jar can be overridden by specifying a custom
value for <tt>:hadoop-name</tt> or <tt>:jar-name</tt> in project.clj.

You can use this plugin to build any Hadoop application which requires
a runable jar, including projects using [MapReduce][2],
[Cascading][3], and [Cascalog][4].

## Installation

Add to your project.clj

    :dev-dependencies [[lein-hadoop "1.1.0"]]

## Usage

    $ lein clean, deps, hadoop

## License

Copyright © 2010-2012 Nick Dimiduk

Distributed under the Eclipse Public License, the same as Leiningen
uses.

Thanks to the Leiningen team for a relatively pleasant build tool!

[0]: https://github.com/technomancy/leiningen "Hair Extinguisher"
[1]: http://hadoop.apache.org/ "Apache Hadoop"
[2]: http://hadoop.apache.org/mapreduce/ "Hadoop MapReduce"
[3]: http://www.cascading.org/ "Cascading"
[4]: http://www.cascalog.org/ "Cascalog"
