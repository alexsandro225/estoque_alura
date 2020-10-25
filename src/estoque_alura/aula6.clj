(ns estoque-alura.aula6)

(def pedido {:mochila {:quantidade 10, :preco 100}
             :caderno {:quantidade 20, :preco 50}})

(defn imprimir-chave-valor
  [valor]
  (println valor))

(imprimir-chave-valor pedido)

; se eu usar map em um map ele vai fazer isso
; apenas para o MapEntry
(map imprimir-chave-valor pedido)

; para mudar isso temos que desetruturar o map que é nada mais
; um vetor para a função map
; para isso vamos mudar a função imprimir-chave-valor
(defn imprimir-chave-valor
  [[chave valor]]
  (println chave valor))

(map imprimir-chave-valor pedido)

; posso acessar esse dados de dentro da função
(defn imprimir-chave-valor
  [[chave valor]]
  (* (:quantidade valor) (:preco valor)))

(println (map imprimir-chave-valor pedido))

; posso usar o reduce em cima disso para somar tudo
(println (reduce + (map imprimir-chave-valor pedido)))

; posso acessar esse dados de dentro da função
(defn imprimir-chave-valor
  [[_ valor]]
  (* (:quantidade valor) (:preco valor)))
; passando o undercore para a função então
; entao temos o destruct só do segundo parâmetro
(println (reduce + (map imprimir-chave-valor pedido)))

; usando Threading LAST
; neste caso função vai primeiro e o threading por último
(defn imprimir-total
  [pedido]
  (->> pedido
       (map imprimir-chave-valor ,,,)
       (reduce + ,,,)))

(println (imprimir-total pedido))

; se eu quiser usar o vals com o map reduce para ficar
; mais legível
(defn imprimir-chave-valor
  [produto]
  (* (:quantidade produto) (:preco produto)))

(defn imprimir-total
  [pedido]
  (->> pedido
       vals
       (map imprimir-chave-valor ,,,)
       (reduce + ,,,)))

(println (imprimir-total pedido))