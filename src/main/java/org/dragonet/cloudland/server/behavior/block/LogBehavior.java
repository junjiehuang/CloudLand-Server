package org.dragonet.cloudland.server.behavior.block;

import org.dragonet.cloudland.server.behavior.BlockBehavior;
import org.dragonet.cloudland.server.entity.PlayerEntity;
import org.dragonet.cloudland.server.item.Item;
import org.dragonet.cloudland.server.item.Items;
import org.dragonet.cloudland.server.map.GameMap;

/**
 * Created on 2017/2/26.
 */
public class LogBehavior extends BlockBehavior {

    @Override
    public Item[] getDrops(Item tool) {
        return new Item[]{Items.LOG.newItemInstance(1)};
    }

    @Override
    public long getBreakTime(Item tool) {
        return 2000L;
    }

    @Override
    public Item onPlace(PlayerEntity player, GameMap map, int x, int y, int z, Item tool) {
        return Items.LOG.newItemInstance(1);
    }

    @Override
    public boolean onStartBreak(PlayerEntity player, GameMap map, int x, int y, int z, Item tool) {
        return super.onStartBreak(player, map, x, y, z, tool);
    }
}
