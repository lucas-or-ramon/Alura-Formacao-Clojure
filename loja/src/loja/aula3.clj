(ns loja.aula3
  (:require [loja.db :as l.db]))

(println (l.db/todos-os-pedidos))

(println (group-by :usuario (l.db/todos-os-pedidos)))

(defn minha-funcao-de-agrupamento
  [elemento]
  (println "elemento" elemento)
  (:usuario elemento))

(println (group-by minha-funcao-de-agrupamento (l.db/todos-os-pedidos)))

(println (map count (vals (group-by :usuario (l.db/todos-os-pedidos)))))

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     vals
     (map count)
     println)
(defn conta-total-por-usuario
  [[usuario pedido]]
  [usuario (count pedido)])

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)

(defn conta-total-por-usuario
  [[usuario pedidos]]
  {:usuario-id usuario,
   :total-de-pedidos (count pedidos)})

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map conta-total-por-usuario)
     println)

(defn total-do-item
  [[_ detelhes]]
  (* (get detelhes :quantidade 0) (get detelhes :preco 0)))

(defn total-do-pedido
  [pedido]
  (println pedido)
  (reduce + (map total-do-item pedido)))

(defn total-dos-pedidos
  [pedidos]
  (println "** Pedidos:")
  (->> pedidos
       (map :itens)
       (map total-do-pedido)
       (reduce +)))

(defn quantia-de-pedidos-e-gasto-total-por-usuario
  [[usuario pedidos]]
  (println "** Usuário:" usuario)
  {:usuario-id usuario,
   :total-de-pedidos (count pedidos)
   :preco-total (total-dos-pedidos pedidos)})

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map quantia-de-pedidos-e-gasto-total-por-usuario))