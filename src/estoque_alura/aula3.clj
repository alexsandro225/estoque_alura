(ns estoque-alura.aula3)

(defn valor-descontado-b
  "Retorna o valor após os 10% de desconto se valor maior que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [desconto (/ 10 100)
          descontado (* valor-bruto desconto)]
      (- valor-bruto descontado))))

(println (valor-descontado-b 101))

; PREDICATE
(defn deve-aplicar-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

(println (deve-aplicar-desconto? 1000))

; PREDICATE com nomenclatura no padrão
(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true
    false))

(println (aplica-desconto? 1000))

; função agora com predicate
; quando não colocamos um parâmetro ele coloca aridade (arity)
(defn valor-descontado-b
  "Retorna o valor após os 10% de desconto se valor maior que 100"
  [valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [desconto (/ 10 100)
          descontado (* valor-bruto desconto)]
      (- valor-bruto descontado))))

(println (valor-descontado-b 101))
(println (valor-descontado-b 99))

; se eu tirar meu else ele retorna nulo
(defn aplica-desconto?
  [valor-bruto]
  (if (> valor-bruto 100)
    true))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 99))

; bind é feito em tempo de execução e não em tempo de compilação

; when, tudo que for nesse caso em várias linhas
; exemplo when true faça bla bla bla bla bla
(defn aplica-desconto?
  [valor-bruto]
  (when (> valor-bruto 100)
    true))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 99))

; versão sem if e sem when
; retorna true ou false igualzinho
(defn aplica-desconto?
  [valor-bruto]
  (> valor-bruto 100))

(println (aplica-desconto? 1000))
(println (aplica-desconto? 99))

; recebe a função de aplica desconto como parâmetro
(defn valor-descontado-b
  "Retorna o valor após os 10% de desconto se valor maior que 100"
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [desconto (/ 10 100)
          descontado (* valor-bruto desconto)]
      (- valor-bruto descontado))))

(println "Passei aqui.")
(println (valor-descontado-b aplica-desconto? 101))
(println (valor-descontado-b aplica-desconto? 99))

; Testando uma função anônima
(println "Função anônima!")
(println (valor-descontado-b (fn [valor-bruto] (> valor-bruto 100)) 101))
(println (valor-descontado-b (fn [valor-bruto] (> valor-bruto 100)) 99))

; Testando uma função anônima com # ou lambdas
; %1 é o primeiro parâmetro da função
; % é o primeiro parâmetro
(println "Função anônima com lambdas!")
(println (valor-descontado-b  #(> %1 100) 101))
(println (valor-descontado-b #(> %1 100) 99))
(println (valor-descontado-b  #(> % 100) 101))
(println (valor-descontado-b #(> % 100) 99))