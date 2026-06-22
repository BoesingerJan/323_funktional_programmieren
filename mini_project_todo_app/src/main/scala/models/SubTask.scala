package models

import types.SubTaskTypes

case class SubTask(
                    name: String,
                    subTaskType: SubTaskTypes,
                    isCompleted: Boolean
                  )