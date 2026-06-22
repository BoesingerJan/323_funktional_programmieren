package models

import types.TaskTypes

case class Task(
                 name: String,
                 taskType: TaskTypes,
                 subTasks: List[SubTask],
                 isExplicitlyCompleted: Boolean
               ):
  def isCompleted: Boolean =
    if subTasks.isEmpty then
      isExplicitlyCompleted
    else
      subTasks.forall(_.isCompleted)