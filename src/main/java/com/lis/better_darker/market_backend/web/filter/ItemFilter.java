package com.lis.better_darker.market_backend.web.filter;

import com.lis.better_darker.market_backend.model.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.LinkedHashMap;
import java.util.Map;
@Getter
@Setter
public class ItemFilter {
    private String itemId;
    private String archetype;
    private String name;
    private Rarity rarity;
    private ItemType type;
    private ArmorType armor_type;
    private HandType hand_type;
    private MiscType misc_type;
    private SlotType slot_type ;
    private UtilityType utility_type;
    private String inventory_width ;
    private String inventory_height ;
    private String vendor_price ;
    private String gear_score ;
    private String adventure_points ;
    private Integer required_class;
    private String required_knowledge ;
    private Map<String,String> primary;
    private Map<String,String> secondary;

    public MultiValueMap<String,String> toQueryParams(){
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        if(itemId != null) params.add("item_id",itemId);
        if(archetype != null) params.add("archetype",archetype);
        if(name != null) params.add("name",name);
        if(rarity != null) params.add("rarity",rarity.name());
        if(type != null) params.add("type",type.name());
        if(armor_type != null) params.add("armor_type",armor_type.name());
        if(hand_type != null) params.add("hand_type",hand_type.name());
        if(misc_type != null) params.add("misc_type",misc_type.name());
        if(slot_type != null) params.add("slot_type",slot_type.name());
        if(utility_type != null) params.add("utility_type",utility_type.name());
        if(inventory_width != null) params.add("inventory_width",inventory_width);
        if(inventory_height != null) params.add("inventory_height",inventory_height);
        if(vendor_price != null) params.add("vendor_price",vendor_price);
        if(gear_score != null) params.add("gear_score",gear_score);
        if(adventure_points != null) params.add("adventure_points",adventure_points);
        if(required_class != null) params.add("required_class",required_class.toString());
        if(required_knowledge != null) params.add("required_knowledge",required_knowledge);
        if(primary != null) {
            primary.forEach((attr,value)->params.add("primary[" + attr + "]",value));
        };
        if(secondary != null) {
            secondary.forEach((attr,value)->params.add("secondary[" + attr + "]",value));
        };
        return params;
    }
}
