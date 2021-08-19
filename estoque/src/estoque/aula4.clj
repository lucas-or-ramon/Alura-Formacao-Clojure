(ns estoque.aula4)

(def precos [30 700 1000])

(println (get precos 3 -1))

(println (conj precos 5))

(println (inc 5))

(println (update precos 0 inc))
(println (update precos 1 dec))
(println precos)

(defn soma-1 [valor] (+ valor 1))
(println (update precos 0 soma-1))

; Código da Aula Anterior
(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for maior que 100."
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 100))
(println (valor-descontado 1000))

(println "map" (map valor-descontado precos))

(println (range 10))
(println "filter" (filter even? (range 10)))

(println "vetor" precos)
(println "filter" (filter aplica-desconto? precos))

(println "map após o filter" (map valor-descontado (filter aplica-desconto? precos)))

(println "vetor" precos)
(println (reduce + precos))

(defn minha-soma
  [valor-1, valor-2]
  (println "Somando" valor-1 valor-2)
  (+ valor-1 valor-2))

(println "vetor" precos)
(println (reduce minha-soma precos))
(println (reduce minha-soma [15]))

(println "vetor" (range 10))
(println (reduce minha-soma 0 (range 10)))
(println (reduce minha-soma 0 [15]))
