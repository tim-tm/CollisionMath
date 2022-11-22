# CollisionMath

CollisionMath is a Java library which can help you handle collision math for games, physic engines or anything else.

## Installation

Use the [GitHub releases](https://github.com/Web-Tim/CollisionMath/releases) to install CollisionMath.

**Or install using maven!**
```xml
<dependency>
    <groupId>me.tim</groupId>
    <artifactId>collisionmath</artifactId>
    <version>1.1</version>
</dependency>
```

## Usage

**Two-dimensional example**

```java
public class App {
    // Class to handle collision
    private CollisionHandler handler;
    private BoundingBox2D boundingBox, otherBoundingBox;

    public App() {
        this.handler = new CollisionHandler();
        
        // Some example BoundingBoxes
        this.boundingBox = new BoundingBox2D(0, 0, 100, 100);
        this.otherBoundingBox = new BoundingBox2D(0, 95, 100, 100);
    }

    // Usage-Example (should be probably something like a gameloop)
    public void run() {
        if (this.handler.isColliding(this.boundingBox, this.otherBoundingBox)) {
            // do anything you want
        }
    }
}
```

**Three-dimensional example**

```java
public class App {
    // Class to handle collision
    private CollisionHandler handler;
    private BoundingBox3D boundingBox, otherBoundingBox;

    public App() {
        this.handler = new CollisionHandler();
        
        // Some example BoundingBoxes
        this.boundingBox = new BoundingBox3D(0, 0, 0, 100, 100, 100);
        this.otherBoundingBox = new BoundingBox3D(0, 95, 0, 100, 100, 100);
    }

    // Usage-Example (should be probably something like a gameloop)
    public void run() {
        if (this.handler.isColliding(this.boundingBox, this.otherBoundingBox)) {
            // do anything you want
        }
    }
}
```

## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[GPL-3.0](https://choosealicense.com/licenses/gpl-3.0/)