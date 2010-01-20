(ns leiningen.hadoop
  "Create a jar for submission as a hadoop job."
  (:require [leiningen.compile :as compile])
  (:use [leiningen.pom :only [make-pom make-pom-properties]]
	[leiningen.jar :only [write-jar]]
        [clojure.contrib.java-utils :only [file]]))

(defn- jar
  "Create a $PROJECT-hadoop.jar file containing the compiled .class files
as well as the source .clj files. If project.clj contains a :main symbol, it
will be used as the main-class for an executable jar."
  ([project jar-name]
     (compile/compile project)
     (let [jar-file (str (:root project) "/" jar-name)
           filespecs [{:type :bytes
                       :path (format "meta-inf/maven/%s/%s/pom.xml"
                                     (:group project)
                                     (:name project))
                       :bytes (make-pom project)}
                      {:type :bytes
                       :path (format "meta-inf/maven/%s/%s/pom.properties"
                                     (:group project)
                                     (:name project))
                       :bytes (make-pom-properties project)}
                      (when (and (:resources-path project)
                                 (.exists (file (:resources-path project))))
                        {:type :path :path (:resources-path project)})
                      {:type :path :path (:compile-path project)}
                      {:type :path :path (:source-path project)}
		      {:type :path :path (:library-path project)}
                      {:type :path :path (str (:root project) "/project.clj")}]]
       ;; TODO: support slim, etc
       (write-jar project jar-file filespecs)
       (println "Created" jar-file)
       jar-file))
  ([project] (jar project (str (:name project) ".jar"))))

(defn hadoop
  "Create a jar for submission to hadoop."
  ([project]
     (jar project (str (:name project) "-hadoop.jar"))))

