# Web Port Design

## Architecture Translation

### Java → JavaScript Mapping
```
Java Class          → JavaScript Class
GImage              → Image object
GRectangle          → {x, y, width, height}
ArrayList<T>        → Array
Timer               → requestAnimationFrame
MouseEvent          → MouseEvent (native)
KeyEvent            → KeyboardEvent (native)
```

## Correctness Properties

### CP-1: Canvas Initialization (AC-1)
**Property**: Canvas element must be created with correct dimensions and styling.
**Verification**: index.html contains canvas with id="gameCanvas", width=800, height=640

### CP-2: Class Structure (AC-2)
**Property**: All Java classes must have JavaScript equivalents with same methods.
**Verification**: main.js contains Entity, Player, Monster, Item, Inventory, Door classes

### CP-3: Input System (AC-3)
**Property**: Keyboard and mouse events must trigger same game actions as Java version.
**Verification**: Event listeners call keyPressed(), mousePressed() on current pane

### CP-4: Rendering (AC-4)
**Property**: Canvas rendering must produce visually identical output to Java version.
**Verification**: ctx.drawImage() positions match Java GImage.setLocation() calls

### CP-5: Game Loop (AC-5)
**Property**: Game loop must run at 60 FPS with update/render separation.
**Verification**: requestAnimationFrame calls update() then render() each frame

### CP-6: Asset Management (AC-6)
**Property**: All images must load before gameplay starts.
**Verification**: Preloader waits for all Image.onload callbacks before showing menu
