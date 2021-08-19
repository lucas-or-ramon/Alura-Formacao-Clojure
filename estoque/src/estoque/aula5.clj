(ns estoque.aula5)

(def estoque {"Mochila" 10, "Camiseta" 5})
(println estoque)

(println "Temos" (count estoque))

(println "Chaves" (keys estoque))

(println "Valores" (vals estoque))

; keyword
; :mochila

(def estoque {:mochila 10, :camiseta 5})
(println estoque)

(println (assoc estoque :cadeira 3))
(println estoque)
(println (assoc estoque :mochila 5))

(println estoque)
(println (update estoque :mochila inc))

(defn tira-um
  [valor]
  (println "Tirando um de" valor)
  (- valor 1))

(println estoque)
(println (update estoque :mochila tira-um))

(println estoque)
(println (update estoque :mochila #(- % 3)))

(def pedido {:mochila {:quantidade 10, :preco 50}
             :camiseta {:quantidade 10, :preco 50}})
(println pedido)

(assoc pedido :chaveiro {:quantidade 1, :preco 10})
(println pedido)

(println (pedido :mochila))
(println (get pedido :mochila))
(println (get pedido :cadeira))
(println (get pedido :cadeira {}))
(println (:cadeira pedido))
(println (:mochila pedido))
(println (:cadeira pedido {}))
(println (:quantidade (:mochila pedido)))

(println (update-in pedido [:mochila :quantidade] inc))

; Treading First
(println pedido)
(println (-> pedido
             :mochila
             :quantidade))

(-> pedido :mochila :quantidade println)