(ns loja.core)

(def vetor ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])

(map println vetor)
(println (first vetor))
(println (rest vetor))
(println (rest []))
(println (next vetor))
(println (next []))

(println (seq []))
(println (seq [1 2 3 4 5]))
