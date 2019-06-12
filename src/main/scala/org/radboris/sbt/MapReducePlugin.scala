package org.radboris.sbt

import sbt._
import sbt.Keys._
import sbt.plugins.JvmPlugin
import Main._
import util.FileToLines

object MapReducePlugin extends AutoPlugin {

  override def trigger = allRequirements
  override def requires = JvmPlugin

  object autoImport {
  }

  import autoImport._

  override lazy val projectSettings = Seq(
  )

  override lazy val buildSettings = Seq()
  override lazy val globalSettings = Seq()

  Main.main()
  FileToLines.apply("test.txt")
}
