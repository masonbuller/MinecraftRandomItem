<h1>Minecraft Item Randomizer</h1>
<h2>Description</h2>
<p>Project consists of a Java based plugin for Minecraft that generates a random item and places it in the players hotbar every minute. If the players inventory is full, the item will generate on the block that the player is standing on at the time of generation.</p>
<p>The code has different execution paths based on the commands entered in the chat in game. Upon loading into the game, each material available is loaded into an array. Once the start command is passed, and if the sender is a player, a timer is started for 60 seconds. Once 60 seconds has passed, the Random class is used to select a random index to retrieve a material from the materials array. Then, a new item stack is returned to be placed in the first available slot in the players inventory.</p>

<br>

<h2>YouTube Overview</h2>
<p>This video displays the plugin in action and how it functions. You can see the start command being executed, the first random item generated, an item being generated when the player has a full inventory, and the stop command being executed.</p>
<p>
  <a href="https://youtu.be/YyOmFCf_8n8">
  <img src="https://imgur.com/oG44mSn.png" height=80% width= 80% alt="Minecraft Hotbar Randomizer Video Thumbnail">
</a></p>

<br>

<h2>Available Commands</h2>
  <img src="https://imgur.com/IaksGHj.png" height=80% widht=80% alt="Minecraft randomizer commands">

<h2>Languages Used</h2>

- <b>Java</b>


<h2>Frameworks Used</h2>

- <b>Maven</b>


<h2>Plugins Used</h2>

- <b>Minecraft Development</b>
- <b>Spigot</b>


<h2>Environments Used</h2>

- <b>IntelliJ IDEA</b>
- <b>Windows 10</b>
