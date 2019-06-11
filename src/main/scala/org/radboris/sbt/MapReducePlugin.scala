package org.radboris.sbt

import sbt._
import sbt.Keys._
import sbt.plugins.JvmPlugin
import Main._

object MapReducePlugin extends AutoPlugin {

  override def trigger = allRequirements
  override def requires = JvmPlugin

  object autoImport {
    val exampleSetting = settingKey[String]("A setting that is automatically imported to the build")
    val exampleTask = taskKey[String]("A task that is automatically imported to the build")
    println("in auto import")
  }

  import autoImport._

  override lazy val projectSettings = Seq(
    exampleSetting := "just an example",
    exampleTask := "computed from example setting: " + exampleSetting.value
  )

  override lazy val buildSettings = Seq()

  override lazy val globalSettings = Seq()
  Main.main()
}
