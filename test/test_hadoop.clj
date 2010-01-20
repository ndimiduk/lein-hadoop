(ns test-hadoop
  (:use [leiningen.core :only [read-project defproject]]
	[leiningen.clean :only [clean]]
	[leiningen.deps :only [deps]]
	[leiningen.hadoop :only [hadoop]] :reload-all)
  (:use [clojure.test]
	[clojure.contrib.set]
	[clojure.contrib.jar :only [filenames-in-jar]]
	[clojure.contrib.java-utils :only [file]])
  (:import [java.util.jar JarFile]))

(def test-project (read-project "sample/project.clj"))

(deftest test-hadoop
  (clean test-project)
  (deps test-project)
  (hadoop test-project)
  (let [jars (set (map #(.getName %)
		       (.listFiles (file (:library-path test-project)))))
	contains (set (remove nil? (map (fn [x]
					  (last (re-find #"^lib/(.*jar)$" x)))
					(filenames-in-jar (new JarFile
							       (str (:root test-project)
								    "/"
								    (:name test-project)
								    "-hadoop.jar"))))))]
    (is (= contains jars))))
