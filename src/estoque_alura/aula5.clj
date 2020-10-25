(ns estoque-alura.aula5)

; define um simbolo para um map { "mochila": 5, "caderno": 10 }
(def estoque {"mochila" 10
              "caderno" 5})
(println estoque)

; boa prática que se for na mesma linha colocar vírgula
(def estoque {"mochila" 10, "caderno" 5})
(println estoque)

; para retornar somente as keys do map usar (keys estoque)
(println (keys estoque))

; para retornar os valores do map usar (vals estoque)
(println (vals estoque))

; a forma de usar string não muito comum em maps de clojure
; por isso devemos usar keywords
; :mochila e :caderno
(def estoque {:mochila 10
              :caderno 5})
(println estoque)

; para incluir um novo item em map devemos usar
; a função assoc, que irá associar um novo valor
; sem alterar o primeiro mapa claro, pela imutabilidade
(println (assoc estoque :bola 12))
(println estoque)

; para retirar um item do map função dissoc
(println (dissoc estoque :mochila))
(println estoque)

; é possível usar o update em maps também
; funciona da mesma forma que com vetores
; passando qual o índice que iremos modificar
(println (update estoque :caderno inc))

(defn tira-um
  [valor]
  (- valor 1))

(println (update estoque :mochila tira-um))

; com lambda ficaria
(println (update estoque :mochila #(- % 1)))

; posso definir um mapa com várias coisas dentro (aninhamento)
(def pedido {:mochila {:quantidade 10, :preco 80}
             :caderno {:quantidade 15, :preco 90}})
(println pedido)

; posso atualizar isso
(def pedido (assoc pedido :bola {:quantidade 10, :preco 70}))
(println pedido)

; para ver posso usar o símbolo como função
(println (pedido :mochila))

; ou usar a função get
(println (get pedido :mochila))

; posso também usar o get com um valor default em caso de retorno vazio
(println (get pedido :vassoura {}))

; melhores práticas para valores em maps é usar
; a keyword como função
(println (:mochila pedido))
; também é possível colocar um valor padrão
(println (:vassour pedido {}))

; podemos realizar um update dentro de um map que está
; dentro de outro map
(println pedido)
(println (update-in pedido [:mochila :quantidade] inc))

; também é possível usar keywords como funções
; aninhamento prefix
(println (:quantidade (:mochila pedido)))

; Threading
(println (-> pedido
             :mochila
             :quantidade))

; Threding é um encadeamento de funções
(-> pedido
    :mochila
    :quantidade
    println)










