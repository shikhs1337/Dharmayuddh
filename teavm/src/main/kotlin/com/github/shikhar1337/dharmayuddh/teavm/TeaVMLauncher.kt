@file:JvmName("TeaVMLauncher")

package com.github.shikhar1337.dharmayuddh.teavm

import com.github.xpenatan.gdx.backends.teavm.TeaApplicationConfiguration
import com.github.xpenatan.gdx.backends.teavm.TeaApplication
import com.github.shikhar1337.dharmayuddh.DharmayuddhGame

/** Launches the TeaVM/HTML application. */
fun main() {
    val config = TeaApplicationConfiguration("canvas").apply {
        width = 640
        height = 480
    }
    TeaApplication(DharmayuddhGame(), config)
}
