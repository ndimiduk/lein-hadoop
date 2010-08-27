# lein-hadoop

This is a plugin for leiningen which generates a jar suitable to submission
as a hadoop job. Sepcifically, this is a runable jar with lib/ containing all
the project dependencies.

## Installation

Add to your project.clj <tt>:dev-dependencies [lein-hadoop "1.0.0"]]</tt>

## Usage

A new target is added which generates PROJECT-hadoop.jar:

    $ lein hadoop

