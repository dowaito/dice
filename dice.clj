(ns game-utils.dice)

(defn roll-dice
  "Roll x number of y sided dice"
  [x y]
  (loop [cnt x total 0]
    (if (zero? cnt)
      total
      (recur (- cnt 1) (+ total (+ (rand-int y) 1))))))

(defn roll-fudge
  "Roll x number of Fudge dice"
  [x]
  (loop [cnt x total 0]
    (if (zero? cnt)
      total
      (recur (- cnt 1) (+ total ([-1 0 1] (rand-int 3)))))))

(defn parse-dice 
  "Parse number and type of dice from a keyword mask of :xdy"
  [mask]
  (let [dmsk (.split (subs (str mask) 1) "d")]
  (list (Integer. (first dmsk))
        (try (Integer. (last dmsk))
             (catch NumberFormatException e
               (last dmsk))))))

(defn fudge-dice?
  "Are the requested dice Fudge dice?"
  [dice]
  (if (= "f" dice) true false))

(defn roll 
  "Roll friendly dice from keyword mask"
  [d]
  (let [mask (parse-dice d)
        rolls (first mask)
        dice (last mask)]
    (if (fudge-dice? dice)
      (roll-fudge rolls)
      (roll-dice rolls dice))))

