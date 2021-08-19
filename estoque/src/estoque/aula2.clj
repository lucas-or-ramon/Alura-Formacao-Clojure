(ns estoque.aula2)

(defn imprime-mensagem []
  (println "------------------------")
  (println "Bem-Vindo do meu estoque"))
  
(imprime-mensagem)

(defn valor-descontado [valor-bruto]
  (* valor-bruto 0.9))

(println
  (valor-descontado 100))


(defn valor-descontado
  "Retorna o valor com desconto de 10%."
  [valor-bruto]
  (let [taxa-de-desconto (/ 10 100)
        desconto (* valor-bruto taxa-de-desconto)]
    (println "Calculando desconto de" desconto)
    (- valor-bruto desconto)))

(valor-descontado 100)


(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for maior que 100."
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto         (* valor-bruto taxa-de-desconto)]
      (println "Calculando desconto de" desconto)
      (- valor-bruto desconto))
  valor-bruto))

(valor-descontado 100)


