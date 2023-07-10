package com.github.shikhar1337.dharmayuddh.screen

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.utils.Scaling
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.github.quillraven.fleks.world
import com.github.shikhar1337.dharmayuddh.component.ImageComponent
import com.github.shikhar1337.dharmayuddh.component.ImageComponent.Companion.ImageComponentListener
import com.github.shikhar1337.dharmayuddh.system.RenderSystem
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.log.logger

class GameScreen : KtxScreen {

    private val stage: Stage = Stage(ExtendViewport(16f, 9f))
    private val texture: Texture = Texture("assets/graphics/pink_monster/pink_monster_idle.png")
    private val world = world {
        injectables {
            add("stage", stage)
        }

        components {
            add<ImageComponentListener>()
        }

        systems {
            add<RenderSystem>()
        }
    }

    override fun show(){
        super.show()
        log.debug { "Game Screen shown" }
        world.entity {
            add<ImageComponent>{
                image = Image(texture).apply{
                    setScaling(Scaling.fill)
                    setSize(1f, 1f)
                    setPosition(4f, 4f)
                }
            }
        }
    }

    override fun render(delta: Float){
        world.update(delta)
    }

    override fun dispose() {
        stage.disposeSafely()
        texture.disposeSafely()
        world.dispose()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    companion object {
        val log = logger<GameScreen>()
    }

}
