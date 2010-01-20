# lein-hadoop

This is a plugin for leiningen which generates a jar suitable to submission
as a hadoop job. Sepcifically, this is a runable jar with lib/ containing all
the project dependencies.

## Installation

1. Checkout the code
2. Compile and install it with <tt>lein compile ; lein install</tt>
3. Add to your project <tt>:dev-dependencies [[org.clojars.ndimiduk/lein-hadoop "0.0.1-SNAPSHOP"]]</tt>

## Usage

A new target is added:

    $ lein hadoop

