# The Last Candle - Game Architecture Requirements

## Overview
A horror-adventure game built with Java ACM Graphics, featuring exploration, inventory management, monster encounters, and multiple endings based on player choices.

## Acceptance Criteria

### AC-1: Core Game Engine
- The game must use ACM Graphics library for rendering
- Must support 800x640 resolution canvas
- Must implement a pane-based architecture for different game screens
- Must support smooth 60 FPS gameplay loop

### AC-2: Player Character System
- Player must have sprite-based movement in 4 directions (up, down, left, right)
- Player must have animated walking sprites (2 frames per direction)
- Player must have collision detection with walls and boundaries
- Player must have HP system (starting at 3 HP)
- Player movement speed must adjust based on diagonal vs cardinal movement

### AC-3: Inventory System
- Player must be able to collect items from the game world
- Inventory must display at bottom of screen (hotbar style)
- Player must be able to select items with mouse clicks
- Selected item must show description text
- Items must have types: WEAPON, KEY, HEALING, GUN
- Inventory must support item usage and deletion

### AC-4: Monster AI System
- Monsters must chase player when in range
- Monsters must have animated sprites
- Monsters must deal damage on collision with player
- Monster movement must be slower than player movement
- Monsters must have pathfinding toward player position

### AC-5: Room/Map System
- Game must support multiple interconnected rooms
- Rooms must include: Living Room, Bedroom, Office
- Each room must have unique background image
- Rooms must have wall collision boundaries
- Doors must connect rooms and support locked/unlocked states

### AC-6: NPC Interaction System
- NPCs must be positioned in specific rooms
- NPCs must trigger dialogue when player approaches
- NPC dialogue must support multi-line text display
- Some NPCs must offer player choices that affect game outcome

### AC-7: Multiple Endings
- Game must support at least 3 different endings:
  - Good Ending
  - Bad Ending
  - True Ending
- Endings must be determined by player choices and actions
- Each ending must have unique screen and narrative

### AC-8: Menu System
- Main menu must include: New Game, Load Game, Options, Credits, Quit
- Pause menu must be accessible during gameplay (ESC key)
- Options menu must support audio muting/unmuting
- Credits screen must display development team information

### AC-9: Audio System
- Game must support background music playback
- Audio must be toggleable via options menu
- Music must loop continuously during gameplay
- Must support WAV audio format

### AC-10: Save/Load System
- Game must support saving player progress
- Save data must include: player position, HP, inventory, room state
- Player must be able to load saved game from main menu
- Save file must persist between game sessions

### AC-11: Web Port
- Game must be portable to HTML5 Canvas + JavaScript
- Web version must maintain same gameplay mechanics
- Web version must support keyboard controls (WASD + Arrow keys)
- Web version must render at same 800x640 resolution

## Non-Functional Requirements

### NFR-1: Performance
- Game must maintain 60 FPS during normal gameplay
- No frame drops during room transitions
- Sprite loading must not cause visible lag

### NFR-2: Code Organization
- Code must be organized into logical packages: Boilerplate, Entity, GamePanes, Item
- Each class must have single responsibility
- Interfaces must define contracts for displayable and interactable objects

### NFR-3: Asset Management
- All sprites must be PNG format
- All sprites must be organized in /res directory structure
- Font must be retro-style (Press Start K)
- Background music must be atmospheric horror theme

### NFR-4: User Experience
- Controls must be intuitive (WASD/Arrow keys for movement)
- Visual feedback for item selection (red highlight box)
- Clear visual distinction between interactive and non-interactive objects
- Atmospheric horror aesthetic with dark color palette
