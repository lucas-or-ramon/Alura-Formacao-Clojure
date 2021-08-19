(ns estoque.aula3)

(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for maior que 100."
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 100))
(println (valor-descontado 1000))

;PREDICATE
(defn deve-aplicar-desconto?
  [valor-bruto]
  (if (> valor-bruto 100) true false))

(println (deve-aplicar-desconto? 100))
(println (deve-aplicar-desconto? 1000))


;PREDICATE
(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100) true false))

(println (deve-aplicar-desconto? 100))
(println (deve-aplicar-desconto? 1000))


(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for maior que 100."
  [valor-bruto]
  (if (aplica-desconto? 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 100))
(println (valor-descontado 1000))

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(println (aplica-desconto? 100))
(println (aplica-desconto? 1000))
(println (valor-descontado 100))
(println (valor-descontado 1000))


(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for maior que 100."
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(defn mais-caro-que-100?
  [valor-bruto]
  (> valor-bruto 100))

(println "Chamado com parâmentros")
(println (valor-descontado mais-caro-que-100? 100))
(println (valor-descontado mais-caro-que-100? 1000))
