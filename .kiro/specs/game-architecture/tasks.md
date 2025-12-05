# Implementation Plan

- [x] 1. Set up project structure and core infrastructure

- [x] 1.1 Initialize Java project with ACM Graphics
  - Create project directory structure
  - Add acm.jar library dependency
  - Set up package structure (Boilerplate, Entity, GamePanes, Item)
  - Configure build system
  - _Requirements: AC-1_

- [x] 1.2 Create base interfaces and abstract classes
  - Implement Displayable interface
  - Implement Interfaceable interface
  - Create GraphicsPane abstract class
  - Define pane lifecycle methods (showContents, hideContents)
  - _Requirements: AC-1, NFR-2_

- [x] 1.3 Implement main application entry point
  - Create MainApplication class extending GraphicsProgram
  - Set canvas dimensions (800x640)
  - Implement pane switching mechanism
  - Add event handling setup
  - _Requirements: AC-1, CP-1_

- [x] 1.4 Create UI component library
  - Implement GButton class with hover effects
  - Implement GParagraph for multi-line text
  - Add button click detection
  - Create reusable styling patterns
  - _Requirements: AC-8, CP-8_

- [x] 1.5 Implement audio system
  - Create MusicBox class for audio playback
  - Add WAV file loading and looping
  - Implement play/stop controls
  - Add audio state management
  - _Requirements: AC-9, CP-9_

- [x] 2. Implement entity system

- [x] 2.1 Create base Entity class
  - Define position properties (x, y)
  - Add sprite/image management
  - Implement visibility state
  - Create collision bounds method
  - Add movement methods
  - _Requirements: AC-2, AC-4, NFR-2_

- [x] 2.2 Implement Player character
  - Create Player class extending Entity
  - Add 4-directional sprite arrays (up, down, left, right)
  - Implement movement with WASD/Arrow keys
  - Add animation system (2 frames per direction)
  - Implement HP system (starting at 3)
  - Add diagonal movement speed adjustment
  - Create Inventory instance
  - _Requirements: AC-2, CP-2_

- [x] 2.3 Implement Monster AI
  - Create Monster class extending Entity
  - Add animated sprite system
  - Implement chase behavior toward player
  - Add distance-based pathfinding
  - Implement collision detection with player
  - Set movement speed (2 pixels/frame)
  - Add damage on collision (1 HP)
  - _Requirements: AC-4, CP-4_

- [x] 2.4 Implement NPC system
  - Create NPC class extending Entity
  - Add positioning in specific rooms
  - Implement proximity detection
  - Add dialogue triggering system
  - Create interaction zones
  - _Requirements: AC-6, CP-6_

- [x] 2.5 Create entity type enums
  - Define MonsterType enum
  - Add entity state tracking
  - _Requirements: NFR-2_

- [x] 3. Implement item and inventory system

- [x] 3.1 Create item type system
  - Define ItemType enum (WEAPON, KEY, HEALING, GUN)
  - Define MapType enum (LIVINGR, BEDR, OFFICE)
  - Define RoomType enum (BEDROOMS, BEDROOML, BEDROOMR, OFFICE, OUT)
  - _Requirements: AC-3, AC-5, NFR-2_

- [x] 3.2 Implement Item class
  - Create Item class with name, sprite, type, map
  - Add pickup state tracking
  - Implement usage state
  - Add description property
  - Create bounds for collision detection
  - Add inventory sprite management
  - _Requirements: AC-3, CP-3_

- [x] 3.3 Implement Inventory system
  - Create Inventory class
  - Add item collection (ArrayList)
  - Implement hotbar display at y=576
  - Add item selection with mouse clicks
  - Create red highlight box for selected item
  - Implement description text display
  - Add item usage and deletion methods
  - Create updateItemGui for positioning
  - _Requirements: AC-3, CP-3_

- [x] 3.4 Implement Door system
  - Create Door class
  - Add door bounds rectangle
  - Implement locked/unlocked state
  - Add room type association
  - Create unlock method
  - Implement collision detection
  - _Requirements: AC-5, CP-5_

- [x] 4. Implement game panes and rooms

- [x] 4.1 Create main menu
  - Implement MenuPane extending GraphicsPane
  - Add background image
  - Create navigation buttons (New Game, Load Game, Options, Credits, Quit)
  - Implement button click handlers
  - Add title text display
  - _Requirements: AC-8, CP-8_

- [x] 4.2 Implement Living Room (starting area)
  - Create NewGamePane extending GraphicsPane
  - Add livingroom.png background
  - Define wall collision boundaries
  - Create doors to other rooms
  - Add items for pickup
  - Set player spawn position (482, 510)
  - Implement collision detection
  - Add pause menu trigger (ESC key)
  - _Requirements: AC-5, CP-5_

- [x] 4.3 Implement Bedroom
  - Create BedRoomGamePane extending GraphicsPane
  - Add BedRoom.png background
  - Define wall boundaries
  - Add NPC with dialogue
  - Implement player choice system (Help/Refuse)
  - Create choice buttons
  - Add doors for room transitions
  - Set player spawn position (722, 474)
  - Store player choice for ending determination
  - _Requirements: AC-5, AC-6, CP-5, CP-6_

- [x] 4.4 Implement Office (final room)
  - Create OfficeGamePane extending GraphicsPane
  - Add room2.png background
  - Define wall boundaries
  - Add monster encounter
  - Implement gun item for combat
  - Create ending trigger logic
  - Add conditional pane switching based on choices
  - Set player spawn position (50, 100)
  - _Requirements: AC-5, AC-7, CP-5, CP-7_

- [x] 4.5 Create options menu
  - Implement OptionPane extending GraphicsPane
  - Add Options Menu.png background
  - Create audio toggle button
  - Implement mute/unmute functionality
  - Add visual feedback (Muted.png, Unmuted.png)
  - Create back button to main menu
  - _Requirements: AC-8, AC-9, CP-8, CP-9_

- [x] 4.6 Create credits screen
  - Implement Credits class extending GraphicsPane
  - Add Credits.png background
  - Display development team information
  - Create back button to main menu
  - _Requirements: AC-8, CP-8_

- [x] 5. Implement endings and narrative

- [x] 5.1 Create Good Ending
  - Implement GoodEndPane extending GraphicsPane
  - Add Good Ending.png background
  - Display ending narrative text
  - Create return to menu button
  - Trigger when player helps NPC and defeats monster
  - _Requirements: AC-7, CP-7_

- [x] 5.2 Create Bad Ending
  - Implement BadEndPane extending GraphicsPane
  - Add Bad Ending.png background
  - Display ending narrative text
  - Create return to menu button
  - Trigger when player refuses to help NPC
  - _Requirements: AC-7, CP-7_

- [x] 5.3 Create True Ending
  - Implement TrueEndPane extending GraphicsPane
  - Add True Ending.png background
  - Display ending narrative text
  - Create return to menu button
  - Trigger with specific action sequence
  - _Requirements: AC-7, CP-7_

- [x] 6. Implement save/load system

- [x] 6.1 Create save functionality
  - Implement SavePane class
  - Add file I/O for game state
  - Serialize player position (x, y)
  - Serialize player HP
  - Serialize inventory items
  - Serialize current room state
  - Write to save file
  - _Requirements: AC-10, CP-10_

- [x] 6.2 Create load functionality
  - Add load game menu option
  - Implement file reading
  - Deserialize game state
  - Restore player position
  - Restore player HP
  - Restore inventory
  - Switch to saved room
  - _Requirements: AC-10, CP-10_

- [x] 7. Create game assets

- [x] 7.1 Create player sprites
  - Design PCU1.png, PCU2.png (up animation)
  - Design PCD1.png, PCD2.png (down animation)
  - Design PCL1.png, PCL2.png (left animation)
  - Design PCR1.png, PCR2.png (right animation)
  - Ensure 32x32 pixel dimensions
  - _Requirements: AC-2, NFR-3_

- [x] 7.2 Create monster sprites
  - Design Tall Monster.png (front view)
  - Design Tall Monster Back.png (back view)
  - Create imposing, threatening appearance
  - _Requirements: AC-4, NFR-3_

- [x] 7.3 Create NPC sprites
  - Design NPC1.png
  - Design NPC2.png
  - Create ghostly, ethereal appearance
  - _Requirements: AC-6, NFR-3_

- [x] 7.4 Create inventory item icons
  - Design Candle.png
  - Design Key.png, Small Key.png
  - Design Knife.png, Small Knife.png
  - Design gun.png
  - Design HotBar.png (inventory background)
  - Ensure 32x32 pixel dimensions
  - _Requirements: AC-3, NFR-3_

- [x] 7.5 Create UI textures
  - Design Main Menu.png
  - Design Pause Menu.png, pause.png, Resume.png, Quit.png
  - Design Options Menu.png, Muted.png, Unmuted.png
  - Design Load Game Menu.png
  - Design HP.png (health indicator)
  - Design choice.png (dialogue choice overlay)
  - Design Good Ending.png, Bad Ending.png, True Ending.png
  - Design Credits.png
  - _Requirements: AC-7, AC-8, NFR-3_

- [x] 7.6 Create room backgrounds
  - Design livingroom.png (starting area)
  - Design BedRoom.png (NPC encounter room)
  - Design room2.png (office/final room)
  - Use dark color palette (#000000, #2c2c2c)
  - _Requirements: AC-5, NFR-3_

- [x] 7.7 Add audio assets
  - Add TestAudio.wav (background music)
  - Ensure looping compatibility
  - Create atmospheric horror theme
  - _Requirements: AC-9, NFR-3_

- [x] 7.8 Add custom font
  - Add prstartk.ttf (Press Start K font)
  - Configure for retro horror aesthetic
  - _Requirements: NFR-3, NFR-4_

- [x] 8. Implement web port

- [x] 8.1 Create HTML structure
  - Create web/index.html
  - Add canvas element (800x640)
  - Style with centered layout
  - Add black background with white border
  - Link to main.js
  - _Requirements: AC-11, CP-11_

- [x] 8.2 Translate core classes to JavaScript
  - Translate Entity class
  - Translate Player class with movement
  - Translate Monster class with AI
  - Translate Item class
  - Translate Inventory class
  - Translate Door class
  - Maintain same method signatures
  - _Requirements: AC-11, CP-11_

- [x] 8.3 Translate UI components to JavaScript
  - Translate GButton class
  - Translate GParagraph class
  - Implement Canvas 2D rendering
  - Add button click detection
  - _Requirements: AC-11, CP-11_

- [x] 8.4 Translate game panes to JavaScript
  - Translate GraphicsPane interface
  - Translate MenuPane
  - Translate NewGamePane
  - Translate BedRoomGamePane
  - Translate OfficeGamePane
  - Translate ending panes
  - _Requirements: AC-11, CP-11_

- [x] 8.5 Implement input system for web
  - Add keyboard event listeners (WASD + Arrow keys)
  - Add mouse event listeners
  - Implement key state tracking
  - Wire events to current pane
  - _Requirements: AC-11, CP-11_

- [x] 8.6 Implement game loop for web
  - Use requestAnimationFrame for 60 FPS
  - Separate update() and render() methods
  - Initialize game on window.onload
  - Implement pane switching
  - _Requirements: AC-11, CP-11_

- [x] 9. Testing and polish

- [x] 9.1 Test player movement and collision
  - Verify 4-directional movement
  - Test wall collision detection
  - Verify diagonal movement speed
  - Test boundary constraints
  - _Requirements: AC-2_

- [x] 9.2 Test inventory system
  - Verify item pickup
  - Test item selection with mouse
  - Verify description display
  - Test item usage and deletion
  - _Requirements: AC-3_

- [x] 9.3 Test monster AI
  - Verify chase behavior
  - Test collision damage
  - Verify pathfinding accuracy
  - Test monster speed balance
  - _Requirements: AC-4_

- [x] 9.4 Test room transitions
  - Verify all doors work correctly
  - Test player position reset
  - Verify locked/unlocked states
  - Test room asset loading
  - _Requirements: AC-5_

- [x] 9.5 Test NPC interactions
  - Verify proximity detection
  - Test dialogue display
  - Verify choice system
  - Test ending determination
  - _Requirements: AC-6_

- [x] 9.6 Test all three endings
  - Verify Good Ending trigger
  - Verify Bad Ending trigger
  - Verify True Ending trigger
  - Test ending screens display
  - _Requirements: AC-7_

- [x] 9.7 Test menu system
  - Verify all menu buttons
  - Test pause menu (ESC key)
  - Test options menu audio toggle
  - Verify credits screen
  - _Requirements: AC-8_

- [x] 9.8 Test save/load system
  - Verify save writes correctly
  - Test load restores state
  - Verify inventory persistence
  - Test room state restoration
  - _Requirements: AC-10_

- [x] 9.9 Test web port
  - Verify feature parity with Java version
  - Test in multiple browsers
  - Verify 60 FPS performance
  - Test keyboard and mouse controls
  - _Requirements: AC-11_

- [x] 9.10 Performance optimization
  - Profile frame rate during gameplay
  - Optimize sprite caching
  - Reduce unnecessary redraws
  - Verify 60 FPS maintained
  - _Requirements: NFR-1_

- [x] 10. Final polish and submission preparation

- [x] 10.1 UI polish pass
  - Verify horror aesthetic consistency
  - Check all text is readable
  - Verify visual feedback for interactions
  - Test color palette adherence
  - _Requirements: NFR-4_

- [x] 10.2 Code cleanup
  - Remove debug code
  - Add code comments
  - Verify naming conventions
  - Check package organization
  - _Requirements: NFR-2_

- [x] 10.3 Asset optimization
  - Verify all assets load correctly
  - Check file sizes
  - Ensure proper asset paths
  - Test asset caching
  - _Requirements: NFR-3_

- [x] 10.4 Documentation
  - Create comprehensive README.md
  - Document controls
  - Add installation instructions
  - Include MIT License
  - _Requirements: Hackathon submission_

- [x] 10.5 Final testing
  - Complete playthrough of all paths
  - Verify all features work
  - Test edge cases
  - Confirm zero known bugs
  - _Requirements: All requirements_
