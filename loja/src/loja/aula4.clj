(ns loja.aula4
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))

;(println (l.db/todos-os-pedidos))

(l.logic/resumo-por-usuario (l.db/todos-os-pedidos))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "Resumo:" resumo)
  (println "Ordenado:" (sort-by :preco-total resumo))
  (println "Ordenado ao Contrário:" (reverse (sort-by :preco-total resumo)))
  (println "Ordenado por Id:" (sort-by :usuario-id resumo))
  (println "Pegar Campo Específico: Quantidade" (get-in pedidos [0 :itens :mochila :quantidade])))

(defn resumo-por-usuario-ordenado
  [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :preco-total)
       reverse))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo:" resumo)
  (println "Primeiro:" (first resumo))
  (println "Segundo:" (second resumo))
  (println "Resto:" (rest resumo))
  (println "Total:" (count resumo))
  (println "Class:" (class resumo))
  (println "nth 1:" (nth resumo 1))
  (println "Take:" (take 2 resumo)))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "> 500 filter" (filter #(> (:preco-total %) 500) resumo))
  (println "> 500 some" (some #(> (:preco-total %) 500) resumo)))