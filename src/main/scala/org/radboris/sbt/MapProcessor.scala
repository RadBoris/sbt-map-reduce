package org.radboris.sbt

import sbt._
import sbt.Keys._
import sbt.plugins.JvmPlugin
import akka.actor.{Actor, ActorRef}
import akka.routing.{Broadcast, RoundRobinPool, ConsistentHashingPool}
import akka.routing.ConsistentHashingRouter.ConsistentHashMapping
import akka.remote.routing.{RemoteRouterConfig}

object MapData {

	val STOP_WORDS_LIST = List("a", "am", "an", "and", "are", "as", "at", "be",
    	"do", "go", "if", "in", "is", "it", "of", "on", "the", "to")

	def hashMapping: ConsistentHashMapping = {
	    case Word (word, title) => word
	  }

	def mapper(title: String, content: String, reduceActors: ActorRef) = {
	    for (item <- content.split("[\\p{Punct}\\s]+"))
	      if ((!STOP_WORDS_LIST.contains(item)) && item.exists(_.isUpper)) {
	      	reduceActors ! Word(item, title)
	      }
  	}
}
