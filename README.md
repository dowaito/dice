Dice
====
A small clojure library which implements a human friendly dice rolling 
mechanic.

Installing
==========
Put this repo in a directory calld "game_utils" somewhere in your classpath.

Example
=======
From the repl:

     (use 'dice)
     (roll :3d6)
     (roll :1d20)
     (roll :4df) # understands fudge dice
     (roll :15d7) # and impossable dice as well
