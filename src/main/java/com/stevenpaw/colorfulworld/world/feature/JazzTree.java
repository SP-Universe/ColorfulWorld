package com.stevenpaw.colorfulworld.world.feature;

import com.stevenpaw.colorfulworld.init.BlockInitNew;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class JazzTree extends Tree {

    public static final TreeFeatureConfig JAZZ_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockInitNew.JAZZ_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockInitNew.JAZZ_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(3, 1))).baseHeight(5).heightRandA(4).foliageHeight(3).ignoreVines()
            .setSapling((IPlantable) BlockInitNew.JAZZ_SAPLING.get()).build();

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(JAZZ_TREE_CONFIG);
    }
}
