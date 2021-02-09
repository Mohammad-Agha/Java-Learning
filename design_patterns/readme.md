# Design Patterns

## What are design patterns?
* Best practices used by developers developers
* Solutions to general problems that software developers faced during software development
* These solutions were derived by trail and error by a huge number of software developers over a long period of time

We have 23 design patterns which can be classifed into three categories: Creational, Structural, Behavioral patterns. There is also another category called J2EE design patterns.

|Creational Patterns| Structural Patterns|Behavioral Patterns |J2EE Patterns|
|-|-|-|-|
|These design patterns provide a way to create objects while hiding the creation logic, rather than instantiating objects directly using new operator. This gives program more flexibility in deciding which objects need to be created for a given use case. | These design patterns concern class and object composition. Concept of inheritance is used to compose interfaces and define ways to compose objects to obtain new functionalities. | These design patterns are specifically concerned with communication between objects. | These design patterns are specifically concerned with the presentation tier. These patterns are identified by Sun Java Center. |

### Factory Pattern
Factory pattern is one of the most used design patterns in Java. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.

In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.

![Factory Pattern](images/factory_pattern_uml_diagram.jpg)