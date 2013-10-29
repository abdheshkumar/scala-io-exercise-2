package com.xebia
package exercise2

import akka.actor.{ActorContext, ActorRef, Props}

trait CreationSupport {
  def getChild(name:String):Option[ActorRef]
  def createChild(props:Props, name:String):ActorRef
  def getOrCreateChild(props:Props, name:String):ActorRef = getChild(name).getOrElse(createChild(props, name))
}

// TODO create an ActorContextCreationSupport that extends the CreationSupport and uses an ActorContext to implement the three methods
trait ActorContextCreationSupport extends CreationSupport {
  def context:ActorContext

  def getChild(name:String):Option[ActorRef] = context.child(name)
  def createChild(props:Props, name:String):ActorRef = context.actorOf(props, name)
}

