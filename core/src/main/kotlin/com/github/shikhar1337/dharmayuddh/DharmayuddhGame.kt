package com.github.shikhar1337.dharmayuddh

import com.badlogic.gdx.Application
import com.badlogic.gdx.Gdx
import com.github.shikhar1337.dharmayuddh.screen.GameScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms. */
class DharmayuddhGame : KtxGame<KtxScreen>() {

    override fun create(){
        Gdx.app.logLevel = Application.LOG_DEBUG
        addScreen(GameScreen())
        setScreen<GameScreen>()
    }
}
