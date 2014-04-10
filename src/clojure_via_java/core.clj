(ns clojure-via-java.core
  (:require [clojure.repl :refer [doc source]]))


;;; Clojure has 11 data types most of them are familiar to you
;;; already...
;;; -------------------------------


1 ;Integers

(type 1)

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

(type first)

true ;boolean

(type true)

nil  ;Null

(type nil)

#"/s"  ;Regex

(type #"\s")

;;; ... in addition there are 4 data structures you need to know:
;;; ----------------------------------



;;; Lists (singly-linked, append at the front, immutable)

'(1 2 3)

(list 1 2 3)


;;; Vectors (think Array, random-access, append at the end, immutable)

[1 2 3 4]


;;; Maps (immutable)
{ :name "rabbit" :lives-in "hole"}

;;; Sets (immutable)
#{ "peter" "paul" "mary"}


;;; Everything else is build upon that. You have seen all the syntax
;;; there is.

;;; Functions are just a special way of interpreting lists:

(str "hello" " " "world" "!")

;;; You define them using a list:

(fn [x] (+ x x))

;;; You can give them a name as well

(def add (fn [x] (+ x x)))

;;; or simpler

(defn add [x] (+ x x))

(add  2)


;;; Java Interop?




