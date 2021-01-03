# Collision! by Brian N.
*Collision!* is a 2D arcade game whose objective is to survive by avoiding collisions. To use it yourself, download it [here]().

## Overview ##
As stated above, the objective is to survive as long as possible by avoiding collisions with enemies. The menu system is animated includes a way to get help and select difficulty. The controls to play the entire game are either WASD or arrow keys to move, space to use the shop, p to pause, and mouse click to use buttons. In-game, there is a HUD to display player information, and there are 6 types of enemies with different colors, speeds, damage ability, and other characteristics, along with numerous levels with varying enemy spawn intensities. To make the game more enjoyable, there are also coins that spawn in-game with a store to spend them in and music that plays in the background. Below is a full demonstration of the game from the opening screen to the losing screen.

There are 6 main states of the game that are either a part of the menus or seen in-game: the opening screen, help screen, select difficulty screen, HUD, store, and losing screen. Each are explained in detail below. 

## Opening Screen (menu) ##
The opening screen is the main menu and allows the player to select play, help, or quit. See below.

## Help Screen (menu) ##
Selecting help from the opening screen displays information described in the overview section above with pictures. There is a back button to return to the opening screen. See the screenshot below.

## Select Difficulty Screen (menu) ##
Selecting play from the opening screen allows the player to select from easy, normal, hard, and back. Selecting back returns to the opening screen. Compared to normal, easy begins with 0.5x the amount of enemies and hard begins with 1.5x the amount of enemies. However, each difficulty has identical coin spawning patterns, store prices, and other variables that affect gameplay. See the screenshot below.

## HUD (in-game) ##
Selecting any difficulty begins the game, and reveals a HUD which displays player score, level, and health. While playing, the score increases indefinitely at a constant rate and can also instantly increase by gathering coins. Score decreases when spent in the store. Similar to score, level increases indefinitely at a constant rate. Enemy spawning becomes intesified at the end of every level with clouds and rain (every 20 levels). The health bar becomes smaller and less red when colliding, and it can refill and grow its bounds if score is spent in the shop. See screenshot below.

## Store (in-game) ##

## Losing Screen (menu) ##


## Unit Testing ##


## To be implemented ##
