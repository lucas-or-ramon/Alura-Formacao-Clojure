(ns estoque.aula6)

(def pedido {:mochila {:quantidade 10, :preco 50}
             :camiseta {:quantidade 12, :preco 30}})
(println pedido)

(defn imprime-e-15 [valor]
  (println "valor" (class valor) valor))

(println (map imprime-e-15 pedido))

(defn imprime-e-15 [[chave valor]]
  (-> valor :mochila))

(println (map imprime-e-15 pedido))

(defn preco-por-produto [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map preco-por-produto pedido))
(println (reduce + (map preco-por-produto pedido)))

(defn total-do-pedido [pedido]
  (reduce + (map preco-por-produto pedido)))

(println (total-do-pedido pedido))

;Treading Last
(defn total-do-pedido [pedido]
  (->>
    pedido
    (map preco-por-produto)
    (reduce +)))

(println (total-do-pedido pedido))

(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(defn total-do-pedido [pedido]
  (->>
    pedido
    vals
    (map preco-total-do-produto)
    (reduce +)))

(println (total-do-pedido pedido))

(def pedido {:mochila {:quantidade 10, :preco 50}
             :camiseta {:quantidade 12, :preco 30}
             :chaveiro {:quantidade 1}})
(println pedido)

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println "Filtrando Gratuitos")
(println (filter gratuito? (vals pedido)))

(defn gratuito?
  [[_ item]]
  (<= (get item :preco 0) 0))

(println "Filtrando Gratuitos")
(println (filter gratuito? pedido))

(defn gratuito?
  [item]
  (<= (get item :preco 0) 0))

(println "Filtrando Gratuitos")
(println (filter (fn [[_ item]] (gratuito? item)) pedido))

(println (filter #(gratuito? (second %)) pedido))

(defn pago?
  [item]
  (not (gratuito? item)))

(println (filter #(pago? (second %)) pedido))

(def pago? (comp not gratuito?))
(println (filter #(pago? (second %)) pedido))

(def clientes [{ :nome "Guilherme"
                :certificados ["Clojure" "Java" "Machine Learning"] }
               { :nome "Paulo"
                :certificados ["Java" "Ciência da Computação"] }
               { :nome "Daniela"
                :certificados ["Arquitetura" "Gastronomia"] }])

(println (->>
           clientes
           (map :certificados)
           (map count)
           (reduce +)))

