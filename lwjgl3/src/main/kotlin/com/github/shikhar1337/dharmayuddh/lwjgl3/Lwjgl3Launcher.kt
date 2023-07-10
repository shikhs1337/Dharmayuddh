@file:JvmName("Lwjgl3Launcher")

package com.github.shikhar1337.dharmayuddh.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.github.shikhar1337.dharmayuddh.DharmayuddhGame

/** Launches the desktop (LWJGL3) application. */
fun main() {
    // This handles macOS support and helps on Windows.
    if (StartupHelper.startNewJvmIfRequired())
      return
    Lwjgl3Application(DharmayuddhGame(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("Dharmayuddh")
        setWindowedMode(1366, 768)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
