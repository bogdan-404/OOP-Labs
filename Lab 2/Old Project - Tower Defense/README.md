# OOP-Lab-2

I decided to implement a **Tower Defense** game. All the entities are divided into 2 main groups: _Enemy Entities_ and _Player (defense) Entities_

## <u>Quick Overview of all Entities:</u>

## Player Entity

Used to store:

- Profile name
- The total lives (If <= 0 then it is the end of game)
- Total resources

Basic behaviour:

- Add or remove resources
- Remove lives
- Getters

## Enemy Infantry Entity

The object can represent one of the available types:

- Soldier
- Armoured Soldier
- Boss Soldier
- Wolf

Depending on the type, the following object properties may vary:

- Hit damage
- Speed
- Maximum health
- Reward for killing
- Rate of hiting
- Alive or not

Behaviour:

- Move
- Receive Damage
- Getters and Setters

## Tower Entity

It takes 1 tile of the map. Used to hit enemies

The object can represent one of the available types:

- Archer Tower
- Mage Tower
- Artillery Tower

Depending on the type, the following object properties may vary:

- Cost to build
- Hit damage
- Hit cooldown
- Hit range

## Barack Entity

Used to spawn defense soldiers near it's position.

The object can represent one of the available types:

- Small
- Big

Depending on the type, the following object properties may vary:

- Cost to build
- Maximum number of alive soldier

## Defense Soldier Entity

Main properties:

- Position
- Health
- Hit damage
- Hit rate
- Alive or not
- Spawn rate (spawns the amount of soldiers to replenish the maximum amount of soldiers a barrack can spawn after the defined seconds)

Behaviour:

- Receives Hit (from enemy infantry)
- Getters and Setters

## Neutral Building Entity

Used to generate resources

Main properties:

- Position
- Reward
- Reward Cooldown
- Cost to build

The properies above can differ depending on one of the 4 types:

- Mill
- Farm
- Mine

## Special Power Entity

Used to hit all enemy entities from a specific range.

Main properties:

- Position (the center of hit range)
- Hit range
- Hit damage
- hit cooldown

The properies above can differ depending on one of the 2 types:

- Thunder
- Rain of bombs
