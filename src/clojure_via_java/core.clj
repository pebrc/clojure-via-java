(ns clojure-via-java.core
  (:require [clojure.repl :refer [doc source]]))


;;; Clojure has about 12 data types most of them are familiar to you
;;; already...
;;; ========================================================


1 ;Integers

(type 1)
(type 142938498237489237489237)

2.0 ;Doubles

(type 2.0)

3.0M ;BigDecimals

(type 3.0M)

1/2 ; Ratios

(type 1/2)

"Strings" ; just that

(type "hello")

\A ;characters

(type \A)

:key ;keywords

(type :key)

first ; symbols

(type 'first)

true ;boolean

(type true)

nil  ;Null

(type nil)

#"/s"  ;Regex

(type #"\s")

;;; ... in addition there are 4 data structures you need to know:
;;; ==============================================================



;;; Lists (singly-linked, grow at the front, immutable, persistent)

'(1, 2, 3)

(list 1 2 3)


;;; Vectors (think Array, access by index, grow at the end, immutable, persistent)

[1 2 3 4]


;;; Maps (immutable, persistent)
{ :name "rabbit", :lives-in "hole"}

;;; Sets (immutable, persistent)
#{ "peter" "paul" "mary"}


;;; Syntax
;;; ==================================================================

;;; Everything else is build upon that. You have seen all the syntax
;;; there is.

;;; Functions are just a special way of interpreting lists:

(str "hello" " " "world" "!")

;;; Definitions can be made with a list like this

(def x 1)

x

;;; Similarily you define functions using a list:

(fn [x] (+ x x))

;;; You can give them a name as well

(def add (fn [x] (+ x x)))

;;; or simpler

(defn add [x] (+ x x))

(add  2 )

;;; Java Interop
;;; =====================================================================


;;; Clojure comes with good Java support (as of 1.6 this works both
;;; ways as there now is also a Clojure API from Java)

;;; You can access Java  methods -- static or not -- like this
(. System getProperty "java.vm.version")

;;; If you want to call a method more than one level deep into the
;;; object graph use two dots

(.. System (getProperties) (get "os.name"))

;;; No suprises here: new creates a new object
(new java.util.Date)

;;; In addition there is some cleverness build in to work with the
;;; sometimes awkward Java APIs

;;; doto takes an instance expression and than evaluates the following
;;; method calls on that instance
(doto (new java.util.HashMap) (.put "a" 1) (.put "b" 2))


;;; Bonus Material

;;; What about Polymorphism?
;;; ==================================================================

;;;Excerpt From: Luke VanderHart and Ryan Neufeld. “Clojure Cookbook.” 

(defmulti area
 "Calculate the area of a shape"
 :type)

(defmethod area :rectangle [shape]
  (* (:length shape) (:width shape)))

(area {:type :rectangle :length 2 :width 4})

;; Trying to get the area of a new shape...
(area {:type :circle :radius 1})

(defmethod area :circle [shape]
  (* (. Math PI) (:radius shape) (:radius shape)))

(area {:type :circle :radius 1})



;;; Alternatively you can use Protocols and Records

;; Define the "shape" of a Shape object
(defprotocol Shape
  (area [s] "Calculate the area of a shape")
  (perimeter [s] "Calculate the perimeter of a shape"))

;; Define a concrete Shape, the Rectangle
(defrecord Rectangle [length width]
  Shape
  (area [this] (* length width))
  (perimeter [this] (+ (* 2 length)
                       (* 2 width))))

(->Rectangle 2 4)

(area (->Rectangle 2 4))









