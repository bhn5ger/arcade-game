# Collision! by Brian N.
*Collision!* is a 2D arcade game whose objective is to survive by avoiding collisions. To play it yourself, download it [here](https://drive.google.com/uc?id=1HoqtzSKmzA7hWUmGSo_l7sCMFTZZqFpz&export=download).

## Overview ##
As stated above, the objective is to survive as long as possible by avoiding collisions with enemies. The menu system is animated and includes a way to get help and select difficulty. The controls to play the entire game are either WASD or arrow keys to move, space to use the shop, p to pause, and mouse click to use buttons. In-game, there is a HUD to display player information, and there are 6 types of enemies with different colors, speeds, damage ability, and other characteristics, along with numerous levels with varying enemy spawn intensities. To make the game more enjoyable, there are also coins that spawn in-game with a store to spend them in and music that plays in the background. Below is a full demonstration of the game from the opening screen to the losing screen.

![gameplay](https://user-images.githubusercontent.com/72827220/103486291-d78ce600-4dca-11eb-9de4-b6a7b604f02e.gif)

There are 6 main states of the game that are either a part of the menus or seen in-game: the opening screen, help screen, select difficulty screen, HUD, store, and losing screen. Each are explained in detail below. 

## Opening Screen (menu) ##
The opening screen is the main menu and allows the player to select play, help, or quit. See below.

![openingScreen](https://user-images.githubusercontent.com/72827220/103485359-b379d680-4dc3-11eb-81f9-7b3456396189.gif)

## Help Screen (menu) ##
Selecting help from the opening screen displays information described in the overview section above with pictures. There is a back button at the bottom to return to the opening screen. See the screenshot below.

![help](https://user-images.githubusercontent.com/72827220/103484508-52e79b00-4dbd-11eb-8d3c-5f844222aef2.png)

## Select Difficulty Screen (menu) ##
Selecting play from the opening screen allows the player to select from easy, normal, hard, and back. Selecting back returns to the opening screen. Compared to normal, easy begins with 0.5x the amount of enemies and hard begins with 1.5x the amount of enemies. However, each difficulty has identical coin spawning patterns, store prices, and other variables that affect gameplay. See the screenshot below.

![difficulty](https://user-images.githubusercontent.com/72827220/103484515-5b3fd600-4dbd-11eb-9ab7-176aa71b5018.png)

## HUD (in-game) ##
Selecting any difficulty begins the game, and reveals a HUD which displays player score, level, and health. While playing, the score increases indefinitely at a constant rate and can also instantly increase by gathering coins. Score decreases when spent in the store. Similar to score, level increases indefinitely at a constant rate. Enemy spawning becomes intesified at the end of every level with clouds and rain (every 20 levels). The health bar becomes smaller and less red when colliding, and it can refill and grow its bounds if score is spent in the shop. See screenshot below.

![HUD](https://user-images.githubusercontent.com/72827220/103485034-5d0b9880-4dc1-11eb-8f1c-ad82bd392024.png)

## Store (in-game) ## 
Pressing space while in-game pauses the game and displays a store with prices and messages that update in real time and reveals five purchasable upgrades: upgrade health, refill health, upgrade speed, decrease intensity, and increase coin reward. See screenshot below.

![store](https://user-images.githubusercontent.com/72827220/103485037-5f6df280-4dc1-11eb-880d-1a349a539b17.png)

Upgrading health increases max health and also refills it, with a starting cost of 1,000 score to begin upgrading from 100 max health. After purchasing, max health increases by 10 and cost increases by 1,000. Once max health reaches 300 and cost reaches 21,000, this upgrade is no longer purchasable. Refilling health does what its name implies, with a starting cost of 1,000 score. After purchasing, cost increases by 600. This upgrade is always purchasable as long as health is not completely refilled. Upgrading speed also does what its name implies, with a starting cost of 1,000 score to begin upgrading from 5 speed. After purchasing, speed increases by 1 and cost increases by 1,000. Once speed reaches 15 and cost reaches 11,000, this upgrade is no longer purchasable. Decreasing intensity decreases the number of enemies that spawn, with a starting cost of 5,000 score to begin decreasing from an intensity factor of 2. After purchasing, intensity decreases by 1 and cost increases by 10,000. This upgrade is always purchasable as long as intensity is greater than 1. Increasing coin reward increases the score gained from gathering coins, with a starting cost of only 100 score to begin upgrading from a 400 coin reward. After purchasing, coin reward increases by 350 and cost increases by 200. Once the coin reward reaches 2,500 and cost reaches 1,300, this upgrade is no longer purchasable.

## Losing Screen (menu) ##
Fully depleting health from too many collisions while playing reveals a losing screen, summarizing score and level at the point of losing and difficulty played. There is a try again button at the bottom to return to the opening screen. See below.

![endScreen](https://user-images.githubusercontent.com/72827220/103485158-60ebea80-4dc2-11eb-8256-749ddbbbf8bc.gif)

## Unit Testing ##
Because the positions of game objects rely heavily on a random number generator, JUnit tests were written to make sure game objects would spawn and stay within the frame. As seen below, each game object after spawning and some movement was at a position within the frame as expected.

![junit](https://user-images.githubusercontent.com/72827220/103494300-31f66880-4e04-11eb-8000-ca35889df362.gif)

## To be implemented ##
More enemies, upgrades, and power-ups are in progress.

