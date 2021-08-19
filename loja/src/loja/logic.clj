(ns loja.logic)

(defn total-do-item
  [[_ detelhes]]
  (* (get detelhes :quantidade 0) (get detelhes :preco 0)))

(defn total-do-pedido
  [pedido]
  (reduce + (map total-do-item pedido)))

(defn total-dos-pedidos
  [pedidos]
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantia-de-pedidos-e-gasto-total-por-usuario
  [[usuario pedidos]]
  {:usuario-id usuario,
   :total-de-pedidos (count pedidos)
   :preco-total (total-dos-pedidos pedidos)})

(defn resumo-por-usuario
  [pedidos]
  (->> pedidos
       (group-by :usuario)
       (map quantia-de-pedidos-e-gasto-total-por-usuario)))