# Coins

Simple game model generator for a game called Coins. It is a variation of NIM game. Two players take turns taking 1 or 2 coins from pile of N coins. First one without coins to take loses.

## Usage
You can use attached .jar file, with parameter N as number of coins.
java -jar coin_model_generator.jar N 

Example:

PS C:\Users\DSS> java -jar coin_model_generator.jar 6
                 /----- BOB-0 (+1;-1)
         /----- ALICE-2
         |       \----- BOB-1
         |               \----- ALICE-0 (-1;+1)
 /----- BOB-4
 |       |       /----- BOB-1
 |       |       |       \----- ALICE-0 (-1;+1)
 |       \----- ALICE-3
 |               |       /----- ALICE-0 (-1;+1)
 |               \----- BOB-2
 |                       \----- ALICE-1
 |                               \----- BOB-0 (+1;-1)
ALICE-6
 |               /----- BOB-1
 |               |       \----- ALICE-0 (-1;+1)
 |       /----- ALICE-3
 |       |       |       /----- ALICE-0 (-1;+1)
 |       |       \----- BOB-2
 |       |               \----- ALICE-1
 |       |                       \----- BOB-0 (+1;-1)
 \----- BOB-5
         |               /----- ALICE-0 (-1;+1)
         |       /----- BOB-2
         |       |       \----- ALICE-1
         |       |               \----- BOB-0 (+1;-1)
         \----- ALICE-4
                 |       /----- ALICE-1
                 |       |       \----- BOB-0 (+1;-1)
                 \----- BOB-3
                         |       /----- BOB-0 (+1;-1)
                         \----- ALICE-2
                                 \----- BOB-1
                                         \----- ALICE-0 (-1;+1)
