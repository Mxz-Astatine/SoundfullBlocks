package org.teamvoided.soundfullblocks.block

import com.ibm.icu.impl.number.Properties
import net.minecraft.core.BlockPos
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.util.RandomSource
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.BlockState


class GenericSoundBlock(properties: BlockBehaviour.Properties, val startSound: SoundEvent, val passiveSound: SoundEvent, val endSound: SoundEvent, val interval: Int) : Block(properties) {

    override fun animateTick(blockState: BlockState, level: Level, blockPos: BlockPos, randomSource: RandomSource) {
        if (level.gameTime % interval == 0L){
            level.playLocalSound(blockPos, passiveSound, SoundSource.BLOCKS, 1.0f, 1.0f, true)
        }
        super.animateTick(blockState, level, blockPos, randomSource)
    }

    override fun onPlace(
        blockState: BlockState,
        level: Level,
        blockPos: BlockPos,
        blockState2: BlockState,
        bl: Boolean
    ) {
        level.playLocalSound(blockPos, startSound, SoundSource.BLOCKS, 1.0f, 1.0f, true)
        super.onPlace(blockState, level, blockPos, blockState2, bl)
    }

    override fun onRemove(
        blockState: BlockState,
        level: Level,
        blockPos: BlockPos,
        blockState2: BlockState,
        bl: Boolean
    ) {
        level.playLocalSound(blockPos, endSound, SoundSource.BLOCKS, 1.0f, 1.0f, true)
        super.onRemove(blockState, level, blockPos, blockState2, bl)
    }

}