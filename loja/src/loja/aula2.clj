(ns loja.aula2)

(def vetor ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])

(defn conta
  [total-ate-agora elementos]
  (if (or (nil? elementos) (empty? elementos))
    total-ate-agora
    (recur (inc total-ate-agora) (next elementos))))

(println (conta 0 vetor))


(defn conta

  ([elementos]
   (conta 0 elementos))

  ([total-ate-agora elementos]
   (if (or (nil? elementos) (empty? elementos))
     total-ate-agora
     (recur (inc total-ate-agora) (next elementos)))))

(println (conta vetor))
(println (conta 0 vetor))
(println (conta []))

(defn conta
  [elementos]
  (loop [total-ate-agora 0
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (inc total-ate-agora) (next elementos-restantes))
      total-ate-agora)))

(println (conta vetor))
(println (conta []))