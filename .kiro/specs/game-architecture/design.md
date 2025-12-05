# The Last Candle - Game Architecture Design

## System Architecture

### Component Overview
```
MainApplication (Entry Point)
├── GraphicsPane (Abstract Base)
│   ├── MenuPane
│   ├── NewGamePane (Living Room)
│   ├── BedRoomGamePane
│   ├── OfficeGamePane
│   ├── GoodEndPane
│   ├── BadEndPane
│   ├── TrueEndPane
│   ├── OptionPane
│   └── Credits
├── Entity System
│   ├── Entity (Base Class)
│   ├── Player
│   ├── Monster
│   └── NPC
├── Item System
│   ├── Item
│   ├── Inventory
│   ├── Door
│   └── Enums (ItemType, MapType, RoomType)
└── UI Components
    ├── GButton
    ├── GParagraph
    └── MusicBox
```

## Correctness Properties

### CP-1: Game Engine Initialization (AC-1)
**Property**: When MainApplication starts, it must initialize ACM Graphics window with 800x640 dimensions and set MenuPane as initial pane.

**Verification**: 
- MainApplication.java creates GraphicsProgram instance
- Window size set to CANVAS_WIDTH=800, CANVAS_HEIGHT=640
- Initial pane set to MenuPane via switchToMenu()

### CP-2: Player Movement and Animation (AC-2)
**Property**: Player movement must update sprite position, animate walking frames, and respect collision boundaries.

**Verification**:
- Player.keyPressed() updates dx/dy based on input
- Player.move() cycles through sprite frames (0-7 steps, 2 frames)
- Collision detection prevents movement into walls
- Diagonal movement reduces speed by 50% (dx/dy = ±2 vs ±4)

### CP-3: Inventory Management (AC-3)
**Property**: Inventory must correctly add items, display them in hotbar, allow selection, and show descriptions.

**Verification**:
- Inventory.addItem() appends to invItems array
- Inventory.updateItemGui() positions sprites at y=576 (hotbar)
- Mouse click on item sprite calls setSelectedItem()
- drawSelectedItem() renders red box and description text

### CP-4: Monster Chase Behavior (AC-4)
**Property**: Monsters must move toward player position and deal damage on collision.

**Verification**:
- Monster.move(player) compares x/y coordinates
- Moves in direction that reduces distance to player
- touchPlayer() checks bounding box intersection
- Collision reduces player HP by 1

### CP-5: Room Transition System (AC-5)
**Property**: Doors must transition player between rooms when unlocked and player collides with door bounds.

**Verification**:
- Door objects have doorBound rectangle and locked boolean
- Player collision with door checks isLocked()
- If unlocked, switches to new pane based on roomType
- Player position reset to appropriate spawn point in new room

### CP-6: NPC Dialogue Triggering (AC-6)
**Property**: NPCs must display dialogue when player is within interaction range.

**Verification**:
- NPC has collision bounds
- Player proximity check in keyPressed() handler
- GParagraph displays multi-line text
- Choice buttons appear for decision points

### CP-7: Ending Determination (AC-7)
**Property**: Game ending must be determined by player choices and trigger appropriate ending pane.

**Verification**:
- Choice buttons in BedRoomGamePane set ending flags
- OfficeGamePane checks conditions (monster killed, NPC choice)
- Switches to GoodEndPane, BadEndPane, or TrueEndPane
- Each ending pane displays unique background and text

### CP-8: Menu Navigation (AC-8)
**Property**: Menu buttons must navigate to correct panes and handle game state transitions.

**Verification**:
- MenuPane buttons switch to appropriate panes
- ESC key in game panes shows pause menu
- Pause menu Resume returns to previous pane
- Quit button exits application

### CP-9: Audio Playback (AC-9)
**Property**: Background music must play continuously and be toggleable.

**Verification**:
- MusicBox.playSound() loads and loops WAV file
- OptionPane mute button calls MusicBox.stopSound()
- Audio state persists across pane transitions
- Unmute restarts audio from beginning

### CP-10: Save/Load Persistence (AC-10)
**Property**: Game state must serialize to file and restore correctly on load.

**Verification**:
- SavePane writes player data to file
- Data includes: x, y, HP, inventory items, current room
- Load game reads file and reconstructs game state
- Player spawns in saved room with saved inventory

### CP-11: Web Port Compatibility (AC-11)
**Property**: JavaScript port must replicate Java game mechanics using HTML5 Canvas.

**Verification**:
- main.js implements equivalent classes (Player, Monster, Item, etc.)
- Canvas rendering matches Java ACM Graphics output
- Keyboard event handlers map to same controls
- Game loop uses requestAnimationFrame for 60 FPS

## Implementation Details

### Player Class Design
```java
public class Player extends Entity {
    private ArrayList<GImage> spriteUp, spriteDown, spriteLeft, spriteRight;
    private int dx, dy;
    private int stepsTaken;
    private int HP;
    private Inventory inventory;
    private String playerDirection;
    
    public void move(int direction) {
        // Animate sprite based on stepsTaken
        // Update position by dx/dy
        // Check collision boundaries
    }
}
```

### Monster AI Algorithm
```
1. Calculate distance to player (deltaX, deltaY)
2. If deltaX > 0, move RIGHT
3. Else if deltaX < 0, move LEFT
4. If deltaY > 0, move DOWN
5. Else if deltaY < 0, move UP
6. Check collision with player hitbox
7. If collision, reduce player HP
```

### Room Transition Flow
```
Player collides with Door
→ Check Door.isLocked()
→ If locked, check inventory for key
→ If key exists, Door.unlock()
→ Switch to new pane based on Door.getRoomType()
→ Set player position to spawn point
→ Load room assets (background, walls, items, monsters)
```

### Inventory Rendering
```
Hotbar at y=576, width=400, height=64
Items positioned at x=200 + (32 * index)
Selected item highlighted with red stroke
Description text rendered at y=600
```

## Technical Decisions

### Why ACM Graphics?
- Simplified graphics API for rapid prototyping
- Built-in event handling for mouse/keyboard
- Easy sprite management with GImage
- Suitable for 2D top-down games

### Why Pane-Based Architecture?
- Clean separation of game screens
- Easy to add new rooms/menus
- Simplifies state management
- Each pane handles own rendering and input

### Why Enum-Based Type System?
- Type-safe item/room/map identification
- Prevents invalid state transitions
- Clear intent in code
- Easy to extend with new types

### Web Port Strategy
- Direct class-to-class translation
- Maintain same architecture in JavaScript
- Use Canvas 2D API as ACM Graphics equivalent
- Event listeners replace ACM event handlers
