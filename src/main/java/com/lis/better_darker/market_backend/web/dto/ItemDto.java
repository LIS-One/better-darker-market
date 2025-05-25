package com.lis.better_darker.market_backend.web.dto;

import com.lis.better_darker.market_backend.model.*;
import lombok.Getter;

import java.util.Map;
@Getter
public class ItemDto {
   private String id;
    private String archetype;
    private String name;

    private Rarity rarity;
    private ItemType type;
    private ArmorType armorType;
    private HandType handType;
    private MiscType miscType;
    private SlotType slotType;
    private UtilityType utilityType;

    private Integer inventoryWidth;
    private Integer inventoryHeight;
    private Integer vendorPrice;
    private Integer gearScore;
    private Integer adventurePoints;

    // Динамические primary/secondary атрибуты
    private Map<String, Integer> primaryAttributes;
    private Map<String, Integer> secondaryAttributes;

}
