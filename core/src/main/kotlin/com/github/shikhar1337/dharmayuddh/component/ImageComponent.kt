package com.github.shikhar1337.dharmayuddh.component

import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.github.quillraven.fleks.ComponentListener
import com.github.quillraven.fleks.Entity
import com.github.quillraven.fleks.Qualifier

class ImageComponent: Comparable<ImageComponent> {
    lateinit var image: Image
    override fun compareTo(other: ImageComponent): Int {
        val yDiff = other.image.y.compareTo(this.image.y)
        return if(yDiff != 0){
            yDiff
        }else{
            other.image.x.compareTo(this.image.x)
        }
    }

    companion object {
        class ImageComponentListener(
            @Qualifier("stage") private val stage: Stage
        ): ComponentListener<ImageComponent> {
            override fun onComponentAdded(entity: Entity, component: ImageComponent) {
                stage.addActor(component.image)
            }

            override fun onComponentRemoved(entity: Entity, component: ImageComponent) {
                stage.root.removeActor(component.image)
            }

        }
    }
}
