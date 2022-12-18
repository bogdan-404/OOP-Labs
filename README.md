# Requirements
# Lab 0: Environment Set Up

## Intro

In order to get the most smooth introduction in software engineering, it’s highly recommended to use a UNIX-like operating system. This laboratory work will help you get a comfortable basic setup & knowledge for implementing the following laboratory works.

## Tasks

Laboratory work consists of a few small steps to get your environment ready. Having these tasks done, you will be ready for Lab 1.

1. **Install a UNIX-based operating system.** The easiest way would be to install as dual boot one of the popular Linux distributions: Ubuntu, Debian, Fedora, maybe Arch if you suffer from insomnia.
It is important to install the OS, don't just use a virtual machine \
**Note:** Skip this step if you already use a Linux distribution or MacOS.

2. **Install essential tools.** You should install the “starting pack” of a software engineer on your machine. This includes zsh, oh-my-zsh, Git, gcc compiler, your favorite ide/editor.

3. **Create a Git repository.** Write a small hello-world program in C. Compile it using GCC and Make. Commit your changes and push them to your remote repository. \
**Perform all the manipulations with file system, source code compilation, git repository through command line exclusively**. Don't use graphical interfaces.

## Grading Policy

* **Task 1** *(5 points)*
    * **bonus:** having installed Arch Linux or Hackintosh *(1 extra point)*
* **Task 2** *(2 points)*
    * having `zsh` installed. *(1 point)*
    * having `oh-my-zsh` installed with custom configuration. *(1 point)*
* **Task 3** *(3 points)*
    * having published repository with source code, all manipulations done through command line. *(2 point)*
    * having Makefile script for compiling source code. *(1 points)*
# Lab 1: Data Structures and Operations on Them

## Intro

Hi there. In this laboratory work we'll dive into incomprehensible yet beautiful world of data structures. And, to spice the things up, you have to implement this laboratory work in **C programming language** exclusively.

The the **minimal requirement** to gain at least *5 points* is to:
1. Implement one of the data structures from the list below.
1. Add an interactive menu (command line)
1. Add the possibility to load the data structure from a file and display it in the terminal.
1. Add the possibility to input the data structure from keyboard and save it in a file.

Having in mind the minimal conditions, let's see what operations you can additionally implement. \
**Note**: All the operations described below must be able to perform manipulations on data structures loaded from a file and save those changes back.

* **Linked List** (min. *5 points*):
    * Append (*0.5 point*)
    * Prepend (*0.5 point*)
    * Reverse (*0.5 point*)
    * Add a value to the specific index (*0.5 point*)
    * Remove a value the from index (*0.5 point*)
    * Sort the linked list, with re-arranging the cells, not just copying values (*0.5 point*)
    * Search for a value (*0.5 point*)
    * Join two linked lists (*0.5 point*)
    * Backwards traversal, use double-linked-list (*1 point*)
* **Queue** (min. *5 points*):
    * Queue (*0.5 point*)
    * Dequeue (*0.5 point*)
    * Search (*0.5 point*)
    * Sort (*0.5 point*)
    * Reverse (*0.5 point*)
    * Priority queue (*1 point*)
    * Circular queue (*1 point*)
* **Binary Tree** (min. *5 points*):
    * Insert (*0.5 point*)
    * Delete (*0.5 point*)
    * Search (*0.5 point*)
    * In-order traversal (*0.5 point*)
    * Pre-order traversal (*0.5 point*)
    * Post-order traversal (*0.5 point*)
    * Sort, i.e. transform in a binary search tree (*1 point*)
    * Balance, i.e transform in a balanced binary tree (*1 point*)
* **Graph** (min. *5 points*):
    * Insert (*0.5 point*)
    * Delete (*0.5 point*)
    * Search (*0.5 point*)
    * Depth-first traversal (*0.5 point*)
    * Breadth-first traversal (*0.5 point*)
    * Find the path from a vertex to another (*0.5 point*)
    * Find minimum spanning tree (*1 point*)
    * Find the subgraph containing the given vertices (*1 points*)
# Lab 2: Into OOP and Encapsulation

## Intro

Hello, here we meet again. Implementing `Lab 1` you definitely had thoughts that the code of data structures and their operations could be organized in a more structured way. So, here we'll introduce the concept of *Object Oriented Programming* and its principles.
## The Simulation

![matrix: simulation](img/simulation.jpg)

A better way to reveal all the charms of OOP will be a simulation of a system a real world system, a game or any other autonomous entropic system that will "live" by some rules written by you. It can be a simulation of a taxi company, a bank, a restaurant or maybe a game like chess or even Counter-Strike or Tower Defense. Also, you can choose some nonexistent system, but you'll have to develop clear rules of how it's working by yourself.
**Important:** no UI is needed. All you need is to provide a clear way in text to show what's happening inside your system.

## Encapsulation

In first laboratory in this series you'll have to choose the system you want to simulate. Then, you'll try the role of an architect. You need to design the objects/entities/participants/actors of your simulation. Focus on finding the entities and defining them from the perspective of their internal logic. Make sure that your simulation won't be too primitive, so you need to have **at least 10 entities** in it.

So, based your simulation and it's rules, you have to define the list of required objects for you system to work and their internal logic.
**For the presentation you have to instantiate the defined classes and show that they do something.**

Let's recap:
* No UI needed, just text-based way to show what's happening inside the simulation
* No interaction between objects is needed yet, just their internal logic
* Don't choose too primitive simulation

## Allowed Tools

For this project you're allowed to use programming languages as:
* C++
* Java
* Kotlin
* C#
* Ruby

# Lab 3: Into OOP and Inheritance

## Intro

How do you do, fellow kids? This laboratory work is the continuation of the previous. Here you have to broaden your existing set of actors in the simulation.

This laboratory work is the second one in a series of 4 labs (`Lab 2`, -> `Lab 3`, `Lab 4`, `Lab 5`). All of them will represent one project that you'll improve step-by-step.

## Inheritance

Here you have to extend your existing classes using inheritance. You have to create an hierarchy of your entities. Create superclasses that will be extended by concrete classes, to separate some common logic. Use access modifiers to see how you can manage the visibility of class properties and methods. Define abstract classes if the superclass is not supposed to be instantiated. Override methods in concrete classes when you need to define a different behavior from the parent class.

For this laboratory work try the concept of some OOP oriented languages where `everything is an object`, so every class provided by standard library is a descendent of a common-to-all class, typically called `Object`. So, try to think how to tie all your actors in the simulation to be descendent of one general class, `Actor`/`Entity`, call it whatever you want. You can take any number of intermediary levels, don't inherit `Driver` directly from root object, at least add an intermediary level as `Person`, to group it.

**For the presentation you have to draw a diagram depicting the hierarchy of your system and describe it in a README file.**

Let's recap:
* Create and hierarchy of all your classes being inherited from one root class.
* Draw a diagram of your classes.
* Describe the hierarchy in a `README` file and upload it to your remote repository.

# Lab 4: Into OOP and Polymorphism

## Intro

Hello there. Today we will extend a bit more your projects. We'll dive into polymorphism, another base concept of OOP.

This laboratory work is the third one in a series of 4 labs (`Lab 2`, `Lab 3`, -> `Lab 4`, `Lab 5`). All of them will represent one project that you'll improve step-by-step.

## Polymorphism

In this laboratory you have to improve your simulation by using polymorphism mechanisms provided by your programming language. You have to add abstractions using interfaces, to decouple the actual implementation and it's abstraction. This way you can make your program work with different entities sharing the same properties and methods, without need to know what's the actual type of that entity. Use abstract classes to separate some repeating logic in a parent class, but it shouldn't be instantiated, just extended. Use dependency injection when you need to instantiate a class inside of another one. If you need to call the same method but with different arguments, use overloading, of course if your language provides such a feature. Also, when you need to change a method's implementation in a child class,use method overwriting.

So, now you have to implement the scenarios/flow that will happen in your simulation. For example, if we take a restaurant, a scenario will be a client makes an order. But there will be many variations of it, like the kitchen fails to cook it, or waiter was late and so on. 

**Implement those scenarios separately, your project should not run as a simulation yet. Just a set o independently running scenarios of interaction between you objects.**

Let's recap:
* Create scenarios of your simulation.
* Run them separately and show the result as a text log.
* Use polymorphism principles.
* Describe the hierarchy in a `README` file and upload it to your remote repository.

# Lab 5: Wrapping Up the Simulation

## Intro

Hello. In previous laboratory works you built the core of your simulation. Now you'll have to polish it and wrap into a working software.

This laboratory work is the fourth one in a series of 4 labs (`Lab 2`, `Lab 3`, `Lab 4`, -> `Lab 5`, `Lab 6`).

## Simulation

The goal of a simulation software is to reproduce the behavior of an existing system, and give the possibility to experiment on it.
You have to define a set of parameters that user can tune and receive different results, observe some correlations, learn something about the system that is simulated.

Simulation means that the program must run continuously, i.e. we start it and observe the process until we explicitly finish it. No input required to start, no input required to interact with the program. Simulation is an isolated process that represents the work of a system. The user only affects it by changing configurations in runtime or before.

Focus on the details. Try to use less randomness and base the decisions your simulation has to take on some other events that took place previously. In such a way, your simulation will look more like a real-life system.

Also, think on the states your simulation gets through. Think how it is affected by the events that take place in the system. If the majority of the events you implemented doesn't have effects, there is a high probability that they are just useless. Every action should have a consequence.

Let's recap:
* Define parameters to affect the behavior of the simulation.
* Provide some insights, results of simulation runtime. 
* Use random as less as possible. Base the decisions inside your simulation on other events.
* Describe the work done in a `README` file and upload it to your remote repository.

# Lab 6: Architecture and SOLID

## Intro

Hi, it's been a while. In this laboratory work we'll focus on organization of your code. You have to polish your projects, separate the code, put all your building block in a correct way from architectural perspective.

This laboratory work is the fifth one in the series (`Lab 2`, `Lab 3`, `Lab 4`, `Lab 5`, -> `Lab 6`, `...Lab 7?`).

## Refactoring

Any project on its timeline sometime hits the points when it requires refactoring. We will artificially bring this moment in this laboratory work. The main purpose of refactoring is to fight technical debt. It transforms a mess into clean code and simple design.

* Clean code is obvious for other programmers.
* Clean code doesn’t contain duplication.
* Clean code contains a minimal number of classes and other moving parts.
* Clean code passes all tests.
* Clean code is easier and cheaper to maintain!

To achieve this, we recommend to **introduce SOLID principles in your project**. It stands for

* Single-responsibility principle (SRP)
* Open-closed principle (OCP)
* Liskov substitution principle (LSP)
* Interface segregation principle (ISP)
* Dependency inversion Principle (DIP)

On the other hand, you have to **introduce architectural patterns**. An architectural pattern is a general, reusable solution to a commonly occurring problem in software architecture within a given context. Architectural patterns are similar to software design pattern but have a broader scope.

The three most popular patterns are MVC, MVP, and MVVM. The MVC stands for model, view, and controller, whereas MVP stands for model, view, and presenter, and MVVM for model, view, and view model.

Why do we need patterns?

* Split complex tasks into simpler tasks.
* Reduce bugs.
* Produce testable and maintainable code.

But without an architectural pattern, you may face difficulties maintaining your app’s business logic.

Before you look at each pattern, here are the terms that make them up:

* **Model** stores data and communicates directly with the database. Model is the part that represents your data and application logic. It defines the business rules that manage data handling, modification, or processing.
* **View** displays the model's data and is responsible for the data’s representation in the user interface.
* **ViewModel** is exclusive to MVVM pattern. This is an abstraction of the view layer and also acts as a wrapper for the model data.
* **Controller** is the component that integrates the view and model.
* **Presenter** is a component that only exists in the MVP model. Presenter gets the input from the view component and processes the data with the help of the model.

_I highly recommend to visit [refactoring.guru/](https://refactoring.guru/) for more insights on refactoring, code organizing and design patterns._

**Let's recap:**
* Refactor your code, separate the logic, organize the file structure
* Introduce SOLID principles
* Introduce design patterns
