---
inclusion: always
---

# Java Game Development Standards for The Last Candle

## Code Organization

### Package Structure
- `Boilerplate/`: Core engine components, UI elements, and application entry point
- `Entity/`: All game entities (Player, Monster, NPC) and their behaviors
- `GamePanes/`: Individual game screens and room implementations
- `Item/`: Item system, inventory, doors, and type enums

### Naming Conventions
- Classes: PascalCase (e.g., `MainApplication`, `NewGamePane`)
- Methods: camelCase (e.g., `showContents()`, `keyPressed()`)
- Constants: UPPER_SNAKE_CASE (e.g., `CANVAS_WIDTH`, `INVENTORY_Y`)
- Private fields: camelCase with descriptive names

## ACM Graphics Patterns

### Pane Architecture
Each game screen extends `GraphicsPane` and implements:
```java
public void showContents() {
    // Add all visual elements to the pane
}

public void hideContents() {
    // Remove all elements when switching panes
}

public void mousePressed(MouseEvent e) {
    // Handle mouse interactions
}

public void keyPressed(KeyEvent e) {
    // Handle keyboard input
}
```

### Sprite Management
- Use `GImage` for all sprites and backgrounds
- Store animated sprites in `ArrayList<GImage>`
- Update sprite position with `setLocation(x, y)`
- Use `getBounds()` for collision detection

### Event Handling
- Mouse events: Check `getElementAt(e.getX(), e.getY())` for clicked objects
- Keyboard events: Use `e.getKeyCode()` for key detection
- Timer events: Use `Timer` for game loop at 60 FPS

## Game Design Patterns

### Entity System
All entities inherit from base `Entity` class:
- Position (x, y)
- Sprite/image
- Visibility state
- Collision bounds
- Movement methods

### State Management
- Use pane switching for major state changes (menu → game → ending)
- Use boolean flags for in-pane state (dialogue active, monster alive, etc.)
- Store player state in `Player` object (HP, inventory, position)

### Collision Detection
```java
public boolean intersects(GRectangle a, GRectangle b) {
    return a.getX() < b.getX() + b.getWidth() &&
           a.getX() + a.getWidth() > b.getX() &&
           a.getY() < b.getY() + b.getHeight() &&
           a.getY() + a.getHeight() > b.getY();
}
```

## Asset Management

### File Organization
```
res/
├── player/          # Player sprite sheets
├── monsters/        # Monster sprites
├── NPC/            # NPC sprites
├── inventory/      # Item icons
├── texture/        # UI elements and backgrounds
└── music/          # Audio files
```

### Asset Loading
- Load images once in constructor or `showContents()`
- Cache loaded images to avoid repeated file I/O
- Use relative paths from project root: `"res/player/PCU1.png"`

## Horror Game Atmosphere

### Visual Design
- Dark color palette (blacks, grays, muted colors)
- Minimal UI to maintain immersion
- Pixel art style for retro horror aesthetic
- Strategic use of empty space to create tension

### Audio Design
- Looping ambient background music
- No sound effects to maintain eerie silence
- Audio toggle in options for player preference

### Narrative Design
- Environmental storytelling through room design
- Minimal dialogue, maximum impact
- Multiple endings based on player moral choices
- Ambiguous narrative elements for player interpretation

## Performance Guidelines

### Optimization
- Limit sprite redraws to only when position changes
- Use `setVisible(false)` instead of removing/re-adding objects
- Avoid creating new objects in game loop
- Pre-load all assets before gameplay starts

### Frame Rate
- Target 60 FPS for smooth gameplay
- Use `Timer` with 16ms delay (1000ms / 60fps)
- Minimize calculations in timer callback

## Web Port Considerations

### JavaScript Translation
- Maintain same class structure in JavaScript
- Use HTML5 Canvas 2D API as ACM Graphics equivalent
- Replace `GImage` with `Image` objects
- Use `requestAnimationFrame` for game loop

### Cross-Platform Compatibility
- Test keyboard controls work in all browsers
- Ensure canvas scaling works on different screen sizes
- Verify asset paths work with web server structure
- Check audio playback compatibility

## Testing Checklist

### Gameplay Testing
- [ ] Player can move in all 4 directions without clipping through walls
- [ ] Inventory correctly displays and manages items
- [ ] Monster AI chases player and deals damage on collision
- [ ] All doors transition to correct rooms
- [ ] All three endings are reachable
- [ ] Save/load preserves game state accurately

### UI Testing
- [ ] All buttons respond to mouse clicks
- [ ] Text is readable with chosen font
- [ ] Pause menu accessible and functional
- [ ] Options menu toggles audio correctly

### Performance Testing
- [ ] Game maintains 60 FPS during normal gameplay
- [ ] No memory leaks during extended play sessions
- [ ] Room transitions are smooth without lag
