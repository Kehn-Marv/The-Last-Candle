# Implementation Plan

- [x] 1. Set up web project structure

- [x] 1.1 Create HTML5 boilerplate
  - Create web/index.html
  - Add DOCTYPE and meta tags
  - Set viewport for responsive design
  - Add page title "The Last Candle"
  - _Requirements: AC-1_

- [x] 1.2 Style canvas element
  - Add canvas with id="gameCanvas"
  - Set dimensions to 800x640
  - Style with black background
  - Add white border
  - Center canvas on page
  - _Requirements: AC-1_

- [x] 1.3 Link JavaScript file
  - Create web/main.js
  - Link script in HTML
  - Set up module structure
  - _Requirements: AC-1_

- [x] 2. Translate core entity classes

- [x] 2.1 Translate Entity base class
  - Create Entity class in JavaScript
  - Add position properties (x, y)
  - Implement sprite management
  - Add visibility state
  - Create getBounds() method
  - Implement setVisible() method
  - _Requirements: AC-2_

- [x] 2.2 Translate Player class
  - Create Player class extending Entity
  - Add sprite arrays (up, down, left, right)
  - Implement keyPressed() handler
  - Implement keyReleased() handler
  - Add movement with dx/dy
  - Implement animation with stepsTaken
  - Add HP system (starting at 3)
  - Create Inventory instance
  - Implement diagonal movement speed adjustment
  - _Requirements: AC-2, AC-3_

- [x] 2.3 Translate Monster class
  - Create Monster class extending Entity
  - Add sprite arrays for animation
  - Implement move(player) method
  - Add distance-based pathfinding
  - Implement touchPlayer() collision detection
  - Set movement speed to 2 pixels/frame
  - _Requirements: AC-2_

- [x] 2.4 Translate Item class
  - Create Item class
  - Add name, sprite, type, map properties
  - Implement pickup state tracking
  - Add description property
  - Create getBounds() method
  - Add inventory sprite management
  - _Requirements: AC-2_

- [x] 2.5 Translate Inventory class
  - Create Inventory class
  - Add invItems array
  - Implement addItem() method
  - Implement deleteItem() method
  - Create updateItemGui() for positioning
  - Add setSelectedItem() method
  - Implement drawSelectedItem() with red box
  - Add description text display
  - _Requirements: AC-2_

- [x] 2.6 Translate Door class
  - Create Door class
  - Add doorBound rectangle
  - Implement locked/unlocked state
  - Add roomType and mapType properties
  - Create unlock() method
  - Implement getRect() method
  - _Requirements: AC-2_

- [x] 3. Translate UI components

- [x] 3.1 Translate GButton class
  - Create GButton class
  - Add rect and message properties
  - Implement render() method with Canvas 2D
  - Add setFillColor() method
  - Add setColor() method
  - Implement button styling
  - _Requirements: AC-2, AC-4_

- [x] 3.2 Translate GParagraph class
  - Create GParagraph class
  - Add multi-line text support
  - Implement processLabels() method
  - Create render() method with Canvas 2D
  - Add setText() method
  - Add setColor() method
  - Add setFont() method
  - _Requirements: AC-2, AC-4_

- [x] 4. Translate game panes

- [x] 4.1 Create GraphicsPane base class
  - Create GraphicsPane class
  - Define showContents() method
  - Define hideContents() method
  - Define mousePressed() method
  - Define keyPressed() method
  - Define keyReleased() method
  - _Requirements: AC-2, AC-5_

- [x] 4.2 Translate MenuPane
  - Create MenuPane extending GraphicsPane
  - Add title text
  - Create navigation buttons
  - Implement mousePressed() handler
  - Implement render() method
  - Add button click detection
  - _Requirements: AC-2, AC-5_

- [x] 4.3 Translate NewGamePane (Living Room)
  - Create NewGamePane extending GraphicsPane
  - Add background rendering
  - Define wall boundaries
  - Add player spawn position
  - Implement keyPressed() for movement
  - Add collision detection
  - Implement door transitions
  - _Requirements: AC-2, AC-4, AC-5_

- [x] 4.4 Translate BedRoomGamePane
  - Create BedRoomGamePane extending GraphicsPane
  - Add background rendering
  - Define wall boundaries
  - Add NPC interaction
  - Implement choice system
  - Add player spawn position
  - Implement door transitions
  - _Requirements: AC-2, AC-4, AC-5_

- [x] 4.5 Translate OfficeGamePane
  - Create OfficeGamePane extending GraphicsPane
  - Add background rendering
  - Define wall boundaries
  - Add monster encounter
  - Implement ending triggers
  - Add player spawn position
  - _Requirements: AC-2, AC-4, AC-5_

- [x] 4.6 Translate ending panes
  - Create GoodEndPane, BadEndPane, TrueEndPane
  - Add ending screen rendering
  - Implement return to menu buttons
  - _Requirements: AC-2, AC-5_

- [x] 5. Implement input system

- [x] 5.1 Add keyboard event listeners
  - Create keydown event listener
  - Create keyup event listener
  - Implement key state tracking
  - Support WASD keys
  - Support Arrow keys
  - Wire events to currentPane.keyPressed()
  - Wire events to currentPane.keyReleased()
  - _Requirements: AC-3_

- [x] 5.2 Add mouse event listeners
  - Create mousedown event listener
  - Create mouseup event listener
  - Create mousemove event listener
  - Track mouse position (x, y)
  - Track mouse pressed state
  - Wire events to currentPane.mousePressed()
  - _Requirements: AC-3_

- [x] 5.3 Implement getElementAt helper
  - Create collision detection for UI elements
  - Check mouse position against buttons
  - Check mouse position against inventory items
  - Return clicked element or null
  - _Requirements: AC-3_

- [x] 6. Implement game loop

- [x] 6.1 Create game loop with requestAnimationFrame
  - Implement gameLoop() function
  - Call update() each frame
  - Call render() each frame
  - Use requestAnimationFrame for 60 FPS
  - _Requirements: AC-5_

- [x] 6.2 Implement update method
  - Create update() function
  - Call currentPane.update() if exists
  - Handle game state updates
  - _Requirements: AC-5_

- [x] 6.3 Implement render method
  - Create render() function
  - Clear canvas each frame
  - Call currentPane.render() if exists
  - Render to Canvas 2D context
  - _Requirements: AC-4, AC-5_

- [x] 6.4 Implement pane switching
  - Create currentPane variable
  - Implement pane assignment
  - Call hideContents() on old pane
  - Call showContents() on new pane
  - _Requirements: AC-5_

- [x] 6.5 Initialize game on load
  - Create init() function
  - Set currentPane to MenuPane
  - Start game loop
  - Wire to window.onload
  - _Requirements: AC-5_

- [x] 7. Implement asset loading

- [x] 7.1 Create Image loading system
  - Use JavaScript Image objects
  - Load sprites from /res directory
  - Implement image caching
  - Handle loading errors gracefully
  - _Requirements: AC-6_

- [x] 7.2 Preload critical assets
  - Load player sprites before game starts
  - Load UI textures
  - Load room backgrounds
  - Show loading state if needed
  - _Requirements: AC-6_

- [x] 7.3 Implement lazy loading for non-critical assets
  - Load monster sprites on demand
  - Load NPC sprites when needed
  - Load ending screens when triggered
  - _Requirements: AC-6_

- [x] 8. Testing and optimization

- [x] 8.1 Test in multiple browsers
  - Test in Chrome
  - Test in Firefox
  - Test in Safari
  - Test in Edge
  - Verify consistent behavior
  - _Requirements: All requirements_

- [x] 8.2 Verify feature parity with Java version
  - Compare player movement
  - Compare monster AI
  - Compare inventory system
  - Compare room transitions
  - Compare endings
  - _Requirements: All requirements_

- [x] 8.3 Performance testing
  - Measure frame rate during gameplay
  - Profile rendering performance
  - Optimize canvas operations
  - Verify 60 FPS maintained
  - _Requirements: All requirements_

- [x] 8.4 Input testing
  - Test WASD keys
  - Test Arrow keys
  - Test mouse clicks on buttons
  - Test mouse clicks on inventory
  - Verify ESC key for pause
  - _Requirements: AC-3_

- [x] 8.5 Cross-platform testing
  - Test on Windows
  - Test on macOS
  - Test on Linux
  - Verify consistent experience
  - _Requirements: All requirements_
