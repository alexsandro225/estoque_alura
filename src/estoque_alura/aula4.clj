(ns estoque-alura.aula4)

(def precos [30 700 1000])
(println (precos 0))
(println (get precos 0))
(println (get precos 2))
; get num indice que nao existe da null
; no vetor retorna erro
(println (get precos 18))
;(println (precos 18))
(println (conj precos 5))
(println precos)

; inc recebe um argumento e soma 1
(println (update precos 0 inc))
; dec recebe um argumento e tira 1
(println (update precos 0 dec))

; soma 1 em um valor
(defn soma-1
  [valor]
  (println "Antigo valor:" valor)
  (inc valor))

(println (update precos 0 soma-1))

; soma 3 em um valor
(defn soma-3
  [valor]
  (println "Antigo valor:" valor)
  (+ valor 3))

(println (update precos 0 soma-3))

; ==============================================
; Aula de MAPS / REDUCE

(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(defn valor-descontado
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

; Map - mapeia todos os valores no vetor precos e aplica valor-descontado
(println (map valor-descontado precos))

; Filter - filter - se devolver algo verdadeiro mantém,
; se for falso ou nulo não mantém
; filter aplica uma função a todos os itens igual o map
(println (range 10))
(println (filter even? (range 10)))

(println precos)
(println (filter aplica-desconto? precos))

(println (map valor-descontado (filter aplica-desconto? precos)))

; =======================================================
;REDUCE - Reduz muitos números ou coisas em uma só
(println precos)
(println (reduce + precos))

(defn minha-soma
  [valor-1 valor-2]
  (+ valor-1 valor-2))

(println (reduce minha-soma precos))

; é possível passar o primeiro elemento ao reduce
(println (reduce minha-soma 0 precos))