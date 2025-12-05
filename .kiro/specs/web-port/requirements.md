# Web Port Requirements

## Overview
Port The Last Candle from Java ACM Graphics to HTML5 Canvas + JavaScript while maintaining identical gameplay mechanics and visual fidelity.

## Acceptance Criteria

### AC-1: Canvas Setup
- HTML page must have 800x640 canvas element
- Canvas must have black background with white border
- Page must be centered and responsive

### AC-2: Class Architecture Parity
- JavaScript must replicate all Java classes: Entity, Player, Monster, Item, Inventory, Door
- Class methods must have same signatures and behavior
- Enums must be converted to JavaScript objects

### AC-3: Input Handling
- Support WASD keys for movement
- Support Arrow keys for movement
- Mouse clicks for inventory selection
- ESC key for pause menu

### AC-4: Rendering System
- Use Canvas 2D API for all rendering
- Maintain same sprite positions as Java version
- Support image loading and caching
- Implement same collision detection

### AC-5: Game Loop
- Use requestAnimationFrame for 60 FPS
- Implement update() and render() separation
- Support pane switching architecture

### AC-6: Asset Loading
- Load all sprites from /res directory
- Implement image preloading before game starts
- Handle loading errors gracefully
