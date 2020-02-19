# User Guide

## 1. Features 

### 1.1 Viewing help: `help`

Format: `help` 

### 1.2 Listing all tasks: `list`

Format: `list`

Shows a list of all tasks.

### 1.3 Finding task: `find`

Format: `find PARTIAL_TASKNAME`

Finds a task from the task list with a matching substring.

Example:
 
* `find A`

Expected outcome:

* `Found matching task(s):`

    `[T] [ ] eat an apple`
    
    `[D] [ ] MAKE A LIST`

### 1.4 Adding Todo task: `todo`

Format: `todo NAME`

Adds a todo task to the task list.

Example:
 
* `todo make pineapple tarts`

Expected outcome:

* `Added:`

    `[T] [ ] make pineapple tarts`
    
### 1.5 Adding Deadline task: `task`

Format: `deadline NAME /by DATE` - date in YYYY-MM-DD

Adds a deadline task to the task list.

Example:
 
* `deadline make pineapple tarts /by 2020-03-05`

Expected outcome:

* `Added:`

    `[D] [ ] make pineapple tarts (by: Thursday, March 5, 2020)`
    
### 1.6 Adding Event task: `event`

Format: `event NAME /at DATETIME`

Adds a event task to the task list.

Example:
 
* `event make pineapple tarts /by Friday`

Expected outcome:

* `Added:`

    `[E] [ ] make pineapple tarts (at: Friday)`
    
### 1.7 Deleting a task: `delete`

Format: `delete ID`

Deletes the task with the specified id from the task list.

Example:
 
* `delete 7`

Expected outcome:

* `Removed task:`

    `[E] [ ] make pineapple tarts (at: Friday)`
    
### 1.8 Marking a task as done: `done`

Format: `done ID`

Mark a task with id as completed.

Example:
 
* `done 1`

Expected outcome:

* `Good job for completing the task:`

    `[T] [/] sleep`
    
### 1.9 Marking a task as not done: `undo`

Format: `undo ID`

Mark a task with id as incomplete.

Example:
 
* `undo 1`

Expected outcome:

* `o.o well... good luck completing the task:`

    `[T] [ ] sleep`
    
### 1.10 Saving task list: `save`

Format: `save`

Saves the task list to a .txt file.
