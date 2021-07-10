
<p>
    <br />
    <img src="https://img.shields.io/badge/Made%20with-Java-red">
    <img src="https://img.shields.io/badge/Made%20with-LWJGL%20-yellow">
    <img src="https://camo.githubusercontent.com/0fa78702c674a5e13004de53a25ae80ed1ce281f92c0e5d6bd5aa7701b3ab483/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f6c6963656e73652f61746861756e2f454f532e737667">
</p>

<p align="center">
  <h2 align="center">NUDGE</h2>
  <p align="center">
    Nudge is a 2D Java game development framework
    <br />
    <a href=""><strong>Explore the docs »</strong></a><br>
    <a href="https://github.com/fre-dahl/Nudge/issues">Report Bug</a>
  </p>


<!-- TABLE OF CONTENTS -->
## Table of Contents

* [Features](#features)
    * [Built With](#built-with)

* [About](#about)
* [Getting Started](#getting-started)
    * [Prerequisites](#prerequisites)
    * [Project Setup](#project-setup)
    * [Documentation](#documentation)
* [Issues](https://github.com/fre-dahl/Nudge/issues)
* [License](#license)
* [Contact](#contact)

## Features

* Modern OpenGL through the LWJGL 3 library for fast GPU rendering.

## About

Nudge is a 2D game library meant to be a template for my own
future game projects. I wanted the framework (Nudge),
and it's development to be publicly available for anyone interested in building
a Game / Game Engine from scratch in Java (Hence the name). Feel free to browse and / or
use any part of the framework.

Nudge is meant to be completed. I's development in meant to end in some predefined final state.
Meaning, it will have support for some core basic features, and hopefully support them well.

Specifically:

* ####2D rendering using OpenGL
  * Orthographic camera
    * Easy to set up
    * culling
  * General sprite batching
  * Particles
    * Instanced rendering
    * Pools
  * Default Shaders
    * Sprites
    * Tile maps
    * UI / Text
    * Normal-mapping
    * Water
    * Lighting
  * Bitmap font rendering
  * Texture packing (atlas)
  * Animation
    * States
  
* ####Lightweight physics system
  * Collision handling
    * Soft (Push pull "springs")
    * Hard (AABB)
    * QuadTree
  
* ####Entity Component System

* ####Game State Management

* ####Serialization and Networking
  * Represent anything as compact binary
  * UDP network transmission protocol
  * Multi-threaded networking
  * Client / Server
  

* ####SteamWorks API integration

* ####Tile maps
  * Runtime procedural generation
  * Low memory footprint
  * Auto-tiling (8-Bit bit-masking)

Nudge will not support:

* Networking security protocols


While Nudge can be used as template for 2D games in general, it is designed with some specific
game genres / concepts in mind. Low resolution, CPU demanding, Top down, RTS, Rogue-like, procedural generation.




## Prerequisites
* OpenGL capable graphics card (minimum `core 330`)
* OpenGL capable graphics driver
* Java 1.8


### Built With
* [LWJGL 3](https://www.lwjgl.org/)

### License
Copyright (c) 2021 MIT License

### Contact
(add contact info)
