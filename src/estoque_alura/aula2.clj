(ns estoque_alura.aula2)

(defn valor-descontado-a
  "Retorna o valor descontado que é 90% do valor bruto"
  [valor-bruto]
  (* valor-bruto 0.9))

(println (valor-descontado-a 10))

(defn valor-descontado-b
  "Retorna o valor após os 10% de desconto"
  [valor-bruto]
  (* valor-bruto (- 1 0.1)))

(println (valor-descontado-b 10))

(defn valor-descontado-b
  "Retorna o valor após os 10% de desconto se valor maior que 100"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [desconto (/ 10 100)
        descontado (* valor-bruto desconto)]
        (- valor-bruto descontado))))

(println (valor-descontado-b 10))