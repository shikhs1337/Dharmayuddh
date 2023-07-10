package com.github.shikhar1337.dharmayuddh.system

import com.badlogic.gdx.scenes.scene2d.Stage
import com.github.quillraven.fleks.*
import com.github.quillraven.fleks.collection.compareEntity
import com.github.shikhar1337.dharmayuddh.component.ImageComponent

@AllOf([ImageComponent::class])
class RenderSystem(
    @Qualifier("stage") private val stage: Stage,
    private val imageComps: ComponentMapper<ImageComponent>

) : IteratingSystem(
    comparator = compareEntity { e1, e2 ->  imageComps[e1].compareTo(imageComps[e2])}
) {

    override fun onTick() {
        super.onTick()
        with(stage){
            viewport.apply()
            act(deltaTime)
            draw()
        }
    }

    override fun onTickEntity(entity: Entity) {
        imageComps[entity].image.toFront()
    }
}
