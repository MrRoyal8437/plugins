package net.runelite.client.plugins.oneclickagility;

import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.queries.NPCQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;

import java.util.Collection;
import java.util.Collections;


public class WerewolfObstacleArea extends ObstacleArea
{
    private final Client client;

    WerewolfObstacleArea(Client client)
    {
        super(3523, 3549, 9861, 9890, 0, -1);
        this.client = client;
    }

    WorldPoint point = new WorldPoint(3538, 9874, 0);

    @Override
    public MenuEntry createMenuEntry()
    {
        if (getWidgetItem(Collections.singletonList(4179)) != null && new NPCQuery().idEquals(5927).result(client).first() != null)
            return new MenuEntry("Give-Stick",
                    "Agility Trainer",
                    5967,
                    MenuAction.NPC_FIRST_OPTION.getId(),
                    0,
                    0,
                    false);
        else
            return new MenuEntry("Walk here",
                    "",
                    0,
                    MenuAction.WALK.getId(),
                    point.getX(),
                    point.getY(),
                    false);

    }


    public WidgetItem getWidgetItem(Collection<Integer> ids) {
        Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);
        if (inventoryWidget != null) {
            Collection<WidgetItem> items = inventoryWidget.getWidgetItems();
            for (WidgetItem item : items) {
                if (ids.contains(item.getId())) {
                    return item;
                }
            }
        }
        return null;
    }

}
