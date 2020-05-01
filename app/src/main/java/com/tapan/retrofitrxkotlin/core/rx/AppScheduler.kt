package com.tapan.retrofitrxkotlin.core.rx

import io.reactivex.Scheduler

interface AppScheduler {
    fun ui(): Scheduler?
    fun computation(): Scheduler?
    fun io(): Scheduler?
}