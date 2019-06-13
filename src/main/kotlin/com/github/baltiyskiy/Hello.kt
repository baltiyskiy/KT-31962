package com.github.baltiyskiy

import akka.Done
import akka.actor.ActorSystem
import akka.actor.CoordinatedShutdown
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage

fun main(args: Array<String>) {
    val system = ActorSystem.create("hello")
    CoordinatedShutdown.get(system).addTask(CoordinatedShutdown.PhaseBeforeActorSystemTerminate(), "sample-task") {
        val completionStage: CompletionStage<Done> = CompletableFuture.completedFuture(Done.done())
        completionStage
    }
}

