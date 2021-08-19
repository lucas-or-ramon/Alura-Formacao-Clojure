(ns loja.aula1)

(def vetor ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])

(map println vetor)
(println (first vetor))
(println (rest vetor))
(println (rest []))
(println (next vetor))
(println (next []))

(println (seq []))
(println (seq [1 2 3 4 5]))

;MAP
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (funcao primeiro)
    (meu-mapa funcao (rest sequencia))))

;(meu-mapa println vetor)

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))

(meu-mapa println vetor)

(def vetor ["daniela" "guilherme" false "carlos" "paulo" "lucia" "ana"])
(meu-mapa println vetor)

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))))

(def vetor ["daniela" "guilherme" false "carlos" "paulo" "lucia" "ana"])
(meu-mapa println vetor)
(meu-mapa println [])
(meu-mapa println nil)

;(meu-mapa println (range 10000))

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))

(meu-mapa println (range 5000))

;REDUCE